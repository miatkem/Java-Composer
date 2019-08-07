import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;

/*DRAWING PANEL FOR MUSIC NOTES*/
public class MusicCanvas extends JPanel
{
    Note[] melody;
    Chord[] chords;
    final int STROKE=2;
    int notesPlayed,beats;
    
    public MusicCanvas(Note[] melody, Chord[] chords, int notesPlayed)
    {
        setSize(1000, 250);
        this.melody=melody;
        this.chords=chords;
        this.notesPlayed=notesPlayed;
        beats=0;
    }
    
    /*UPDATE melody, chords and notes played so far*/
    public void setData(Note[] melody, Chord[] chords, int notesPlayed)
    {
        this.melody=melody;
        this.chords=chords;
        this.notesPlayed=notesPlayed;
        beats=0;
    }
    
    /*CALLED WITH REPAINT*/
    public void paintComponent (Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fill(new Rectangle2D.Double(0,0,1000,250));//clear screen
        
        g2.setColor(Color.BLACK);
        paintBarLines(g2);
        paintNotes(g2);
        
    }
    
    /*PAINT STAFFING LINES*/
    public void paintBarLines(Graphics2D g2)
    {
        for(int i = 0; i<5; i++)
            g2.draw(new Line2D.Double(20,i*15+75,975,i*15+75));
    }
    
    public void paintNotes(Graphics2D g2)
    {
        int xtag=30;
        int ytag=225;
        int space=0;
        int note=0;
        int beats=0;
        
        for(int i=0; /*i=notesPlayed-29;*/ i<notesPlayed; i++)
        {
            /*UPDATE NOTE AND BEAT TRACKER*/
            beats+=melody[i].getLength();
            note=melody[i].getNote();
            
            /*SWITCH to show where each note belongs on the staff*/
            switch(note-60)
            {
                case 0: space = 11; break;
                case 1:
                case 2: space = 12; break;
                case 3: 
                case 4: space = 13; break;
                case 5: space = 14; break;
                case 6: 
                case 7: space = 15; break;
                case 8: 
                case 9: space = 16; break;
                case 10: 
                case 11: space = 17; break;
                
                case 12: space = 18; break;
                case 13: 
                case 14: space = 19; break;
                case 15: 
                case 16: space = 20; break;
                case 17: space = 21; break;
                case 18: 
                case 19: space = 22; break;
                case 20: 
                case 21: space = 23; break;
                case 22: 
                case 23: space = 24; break;
                
                case 24: space = 25; break;
                case 25: 
                case 26: space = 26; break;
                case 27: 
                case 28: space = 27; break;
                case 29: space = 28; break;
                case 30: 
                case 31: space = 29; break;
                case 32: 
                case 33: space = 30; break;
                case 34: 
                case 35: space = 31; break;
                case 36: space = 32; break;
                
            }
            /*DRAW NOTE*/
            if(i>notesPlayed-30) //fits on screen
            {
                g2.fill(new Ellipse2D.Double(xtag,ytag-(space*7.5),20,15));//note head
                g2.draw(new Line2D.Double(xtag+20,ytag-(space*7.5)+7.5,xtag+20,ytag-(space*7.5)-30));//stem
                if(melody[i].getLength()==1)//flag if eigth note
                    g2.draw(new Arc2D.Double(xtag+15, ytag-(space*7.5)-30, 15, 30, 0, 90, Arc2D.OPEN));

                if(space<12||space>22)//outside the staff gets assisting staff lines
                {
                    if(space%2!=0)
                        g2.draw(new Line2D.Double(xtag-5,ytag-(space*7.5)+7.5,xtag+20,ytag-(space*7.5)+7.5));
                    else
                        g2.draw(new Line2D.Double(xtag-2.5,ytag-((space-1)*7.5)+7.5,xtag+22.5,ytag-((space-1)*7.5)+7.5));
                }
                xtag+=30;
                
                /*Draw measure bar*/
                if(beats%8==0)
                {
                    g2.draw(new Line2D.Double(xtag,0*15+75,xtag,4*15+75));
                    xtag+=15;
                }
            }
        }
    }
}