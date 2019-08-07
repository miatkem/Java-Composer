public class Chord
{
    private Note[] notes;
    private Note[] key;
    
    public Chord(Note[] notes, Note[] key)
    {
        this.notes=notes;
        this.key=key;
    }
    
    /*RETURNS a random note fromt he chord*/
    public int getRandomNote()
    {
        int rdmNum=(int)(Math.random()*notes.length);
        return notes[rdmNum].getNote();
    }
    
    /*RETURNS array of notes in chord*/
    public Note[] getNotes()
    {
        return notes;
    }
    
    /*RETURNS array of notes in key*/
    public Note[] getKey()
    {
        return key;
    }
}