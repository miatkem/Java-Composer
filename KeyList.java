/*Growing list of keys that are used in the composing of music*/
public class KeyList
{
    public static Note[] GMAJ, CMAJ, FMAJ, AMIN;
    
    public static void init()
    {
        /*F MAJOR*/
        Note [] key = new Note[7];
        key[0] = new Note(0,0,100);
        key[1] = new Note(2,0,100);
        key[2] = new Note(4,0,100);
        key[3] = new Note(5,0,100);
        key[4] = new Note(7,0,100);
        key[5] = new Note(9,0,100);
        key[6] = new Note(10,0,100);
        FMAJ=key;
        
        /*C MAJOR/A MINOR*/
        key = new Note[7];
        key[0] = new Note(0,0,100);
        key[1] = new Note(2,0,100);
        key[2] = new Note(4,0,100);
        key[3] = new Note(5,0,100);
        key[4] = new Note(7,0,100);
        key[5] = new Note(9,0,100);
        key[6] = new Note(11,0,100);
        
        CMAJ=key;
        AMIN=key;
        
        /*G MAJOR*/
        key = new Note[7];
        key[0] = new Note(0,0,100);
        key[1] = new Note(2,0,100);
        key[2] = new Note(4,0,100);
        key[3] = new Note(6,0,100);
        key[4] = new Note(7,0,100);
        key[5] = new Note(9,0,100);
        key[6] = new Note(11,0,100);
        
        GMAJ=key;
    }
    
}