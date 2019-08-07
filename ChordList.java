/*Growing list of chords that are used in the composing of music*/
public class ChordList
{
    public static Chord GMAJC, CMAJC, FMAJC, CMAJF, FMAJF, BbMAJF, AMIN, DMIN, EMIN;
    
    public static void init()
    {
        /*C CHORD*/
        Note[] chord = new Note[4];
        chord[0] = new Note(60,0,100);
        chord[1] = new Note(64,0,100);
        chord[2] = new Note(67,0,100);
        chord[3] = new Note(72,0,100);
        CMAJC=new Chord(chord,KeyList.CMAJ);
        CMAJF=new Chord(chord,KeyList.FMAJ);
        
        /*F CHORD*/
        chord = new Note[4];
        chord[0] = new Note(65,0,100);
        chord[1] = new Note(69,0,100);
        chord[2] = new Note(72,0,100);
        chord[3] = new Note(77,0,100);
        FMAJC=new Chord(chord,KeyList.CMAJ);
        FMAJF=new Chord(chord,KeyList.FMAJ);
        
        /*G CHORD*/
        chord = new Note[4];
        chord[0] = new Note(67,0,100);
        chord[1] = new Note(71,0,100);
        chord[2] = new Note(74,0,100);
        chord[3] = new Note(79,0,100);
        GMAJC=new Chord(chord,KeyList.CMAJ);
        
        /*B CHORD*/
        chord = new Note[4];
        chord[0] = new Note(70,0,100);
        chord[1] = new Note(74,0,100);
        chord[2] = new Note(77,0,100);
        chord[3] = new Note(82,0,100);
        BbMAJF=new Chord(chord,KeyList.FMAJ);
        
        /*Amin CHORD*/
        chord = new Note[4];
        chord[0] = new Note(69,0,100);
        chord[1] = new Note(72,0,100);
        chord[2] = new Note(76,0,100);
        chord[3] = new Note(81,0,100);
        AMIN=new Chord(chord,KeyList.AMIN);
        
        /*Dmin CHORD*/
        chord = new Note[5];
        chord[0] = new Note(74,0,100);
        chord[1] = new Note(77,0,100);
        chord[2] = new Note(81,0,100);
        chord[3] = new Note(84,0,100);
        chord[4] = new Note(86,0,100);
        DMIN=new Chord(chord,KeyList.AMIN);
        
        /*Emin CHORD*/
        chord = new Note[5];
        chord[0] = new Note(64,0,100);
        chord[1] = new Note(67,0,100);
        chord[2] = new Note(71,0,100);
        chord[3] = new Note(74,0,100);
        chord[4] = new Note(76,0,100);
        EMIN=new Chord(chord,KeyList.AMIN);
    }
    
}