/*BASED ON CHORD PROGRESSION CREATES A SONG USING MELODY CREATOR, KEYLISTS and CHORDLISTS*/
public class SongCreator
{
    private ChordList chordList;
    private KeyList keyList;
    private Note[] melody;
    private Chord[] chords;
    private MelodyCreator melodyMold;
    private int chordProgression;
    
    public SongCreator(int chordProgression)
    {
        this.chordProgression=chordProgression;
        keyList.init();
        chordList.init();
        createSong();
    }
    /*CREATE chords to be played and generate a melody*/
    public void createSong()
    {
        fillChords();
        melodyMold=new MelodyCreator(chords,4);
        melodyMold.createMelody();
        melody=melodyMold.getMelody();
    }
    /*RETURN melody (array of notes)*/
    public Note[] getMelody()
    {
        return melody;
    }
    /*RETURN chords (array of chords)*/
    public Chord[] getChords()
    {
        return chords;
    }
    /*based on chord progressions create a list of chords to played in a certain order*/
    private void fillChords()
    {
        if(chordProgression==1)
        {
            chords= new Chord[12];
            for(int i =0; i<3; i++)
            {
                int j=4*i;
                chords[0+j]=ChordList.CMAJC;
                chords[1+j]=ChordList.FMAJC;
                chords[2+j]=ChordList.GMAJC;
                chords[3+j]=ChordList.CMAJC;
            }
        }
        else if(chordProgression==2)
        {
            chords= new Chord[12];
            for(int i =0; i<3; i++)
            {
                int j=4*i;
                chords[0+j]=ChordList.FMAJF;
                chords[1+j]=ChordList.BbMAJF;
                chords[2+j]=ChordList.CMAJF;
                chords[3+j]=ChordList.FMAJF;
            }
        }
        
        else if(chordProgression==3)
        {
            chords= new Chord[12];
            for(int i =0; i<3; i++)
            {
                int j=4*i;
                chords[0+j]=ChordList.AMIN;
                chords[1+j]=ChordList.DMIN;
                chords[2+j]=ChordList.EMIN;
                chords[3+j]=ChordList.AMIN;
            }
        }
        
        else
        {
            chords= new Chord[4];
            chords[0]=ChordList.FMAJC;
            chords[1]=ChordList.FMAJC;
            chords[2]=ChordList.FMAJC;
            chords[3]=ChordList.FMAJC;
        }
    }
    
}