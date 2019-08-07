import java.util.ArrayList;

/*Creates measures (melody) that accompany the chord progression given*/
public class MelodyCreator
{
    private Chord[] chords;
    private ArrayList<Note> melody;
    private Note[] currentKey;
    private Note firstNote;
    
    public MelodyCreator(Chord[] chords, int quaterPerMeasure)
    {
        this.chords=chords;
        melody=new ArrayList<Note>();
        firstNote=null;
    }
    
    public void createMeasure(Chord initialChord, Chord finalChord)
    {
        /*MUSIC GENERATION ALGORITHIM
         * -first note is random note in the chord
         * -last note is random note in the next chord
         * -notes in between are a random path from first note to last note
         *         -with each note the pitch approaches the last note's pitch*/
        
        currentKey=initialChord.getKey();
        ArrayList<Integer> rythm = getRandomRythm();
        int beat=0;
        ArrayList<Note> measure = new ArrayList<Note>();
        if(firstNote==null)
            firstNote = new Note(initialChord.getRandomNote(),2,100);
        Note lastNote = new Note(finalChord.getRandomNote(),2,100);
        measure.add(firstNote);
        int rdmNumOne=(int)(Math.random()*rythm.size());
        for(int i =0; i< rythm.size(); i++)
        {
            int rdmNumTwo=(int)(Math.random()*6)+1;
            rdmNumTwo-=3;
            
            if(i<=rdmNumOne)
                measure.add(new Note(movePitch(lastNote.getNote(),rdmNumTwo),rythm.get(i),100));
            else
                measure.add(new Note(movePitch(firstNote.getNote(),rdmNumTwo),rythm.get(i),100));
            beat++;
        }
        
        firstNote = lastNote;
        
        for(int i =0; i<measure.size(); i++)
        {
            melody.add(measure.get(i));
        }
    }
    
    /*RETURNS melody as an array of notes*/
    public Note[] getMelody()
    {
        Note[] notes = new Note[melody.size()];
        
        for(int i =0; i< notes.length;i++)
        {
            notes[i]=melody.get(i);
        }
        
        return notes;
    }
    
    /*Uses createMeasure() to create a measure for each chord in the array of chords*/
    public void createMelody()
    {
        for(int i=0; i<chords.length-1;i++)
        {
            createMeasure(chords[i],chords[i+1]);
        }
        createMeasure(chords[chords.length-2],chords[chords.length-1]);
    }
    
    /*RETURNS notes a certain amounts steps above or below a note in a key*/
    public int movePitch(int note,int steps)
    {
        int octave=note/12*12;
        int pitch=note%12;
        note = currentKey[Math.floorMod((pitch+steps),7)].getNote()+octave;
        while(note>86)//keep note in range
            note-=12;
        return note;
    }
    
    /*Used to generate a varation of quater and eigth notes that is somewhat random*/
    public ArrayList<Integer> getRandomRythm()
    {
        ArrayList<Integer> rythm = new ArrayList<Integer>();
        int rythmSum=2;
        while(rythmSum!=8)
        {
            int rdmNum=(int)(Math.random()*2)+1;
            if(rythmSum+rdmNum<=8)
            {
                rythm.add(rdmNum);
                rythmSum+=rdmNum;
            }
        }
        return rythm;
    }
}

