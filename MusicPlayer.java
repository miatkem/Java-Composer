import javax.sound.midi.*;

/*CREATES AND MANAGES PLAYING OF THE SONG*/
public class MusicPlayer
{
    private int tempo;
    private int instrument;
    private SongCreator song;
    private Note[] melody;
    private Chord[] chords;
    private MidiChannel[] mChannels;
    private int hold,beats,notesPlayed,chordsPlayed;
    
    public MusicPlayer()
    {
        instrument=0;
        hold=beats=notesPlayed=chordsPlayed=0;
        song=new SongCreator(3);
        melody=song.getMelody();
        chords=song.getChords();
        tempo=250;
    }
    /*CREATE NEW SONG (i=chord progression)*/
    public void newSong(int i)
    {
        song=new SongCreator(i);
        melody=song.getMelody();
        chords=song.getChords();
    }
    /*INCREMENT or DECREMENT tempo*/
    public void tempo(int tempoChange)
    {
        tempo+=tempoChange;
    }
    /*RETURN tempo (int)*/
    public int getTempo()
    {
        return tempo;
    }
    /*RETURN melody (array of NOTES)*/
    public Note[] getMelody()
    {
        return melody;
    }
    /*RETURN amount of notes played so far (int)*/
    public int getNotesPlayed()
    {
        return notesPlayed;
    }
    /*RETURN chord progession (array of chords)*/
    public Chord[] getChords()
    {
        return chords;
    }
    /*RETURN TRUE if song has been fully played*/
    public boolean songOver()
    {
        return (beats>=8*chords.length);
    }
    
    /*SET current instrument to a new midi instrument by its int value*/
    public void setInstrument(int inst)
    {
        instrument=inst;
    }
    public void setSong()
    {
        hold=beats=notesPlayed=chordsPlayed=0;
        try{
            /* Create a new Sythesizer and open it */
            Synthesizer midiSynth = MidiSystem.getSynthesizer();
            
            midiSynth.open();
            //get and load default instrument and channel lists
            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            mChannels = midiSynth.getChannels();
            
            midiSynth.loadInstrument(instr[instrument]);//load an instrument
        } catch (MidiUnavailableException e) {}
    }
    
    /*Play the next beat*/
    public void nextBeat()
    {
        //Play chord on downbeat
        if(beats%8==0)
        {
            playChord(chords[chordsPlayed].getNotes(), 100);
            chordsPlayed++;
        }
        
        //hold quater note second beat
        if(hold>1)
            hold--;
        else //otherwise start the next note
        {
            playNote(melody[notesPlayed].getNote(),melody[notesPlayed].getDynamic());
            hold=melody[notesPlayed].getLength();
            notesPlayed++;
        }
        beats++;
    }
    
    /*PLAY CHORD*/
    public void playChord(Note[] chord, int dynamic)
    {
        for(int i=0; i<chord.length; i++)
            mChannels[0].noteOn(chord[i].getNote()-12, dynamic);//On channel 0, play note number 60 with velocity 100
    }
   
    /*PLAY NOTE*/
    public void playNote(int note, int dynamic)
    {
        mChannels[0].noteOn(note, dynamic);
    }
    
}