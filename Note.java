/*Low level object to hold information for a note*/
public class Note
{
    private static final int WHOLE=8, HALF=4,QUATER=2,EIGHTH=1;
    private int note;
    private int dynamic;
    private int length;
    
    public Note(int note, int length, int loudness)
    {
        this.note=note;
        dynamic = loudness;
        this.length=length;
    }
    
    public int getLength()
    {
        return length;
    }
    
    public int getNote()
    {
        return note;
    }
    
    public int getDynamic()
    {
        return dynamic;
    }
    
    public void upOctave()
    {
        note+=12;
    }
    
    public void downOctave()
    {
        note-=12;
    }
}