import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import java.awt.geom.Ellipse2D;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.Timer;

/*UI for the Java Composer*/
public class JavaComposerGUI extends JPanel implements ActionListener
{
    //Buttons and LAbels
    private JLabel title;
    private JButton play;
    //Objects
    private MusicCanvas canvas;
    private MusicPlayer composer;
    private Timer timer;
   
    public static void main(String[] args)
    {
        new JavaComposerGUI();
    }
    
    public JavaComposerGUI()
    {
        /*SET UP WINDOW*/
        JFrame window = new JFrame("Java Composer");
        window.setBackground(new Color(255,0,0));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Java Composer");
        window.setSize(1000,500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        /*TIMER*/
        timer = new Timer(500, this);
        timer.setInitialDelay(100);
        /*FONT*/
        Font f = new Font("Times Roman", Font.PLAIN, 57);
        /*OBJECTS*/
        composer=new MusicPlayer();
        canvas = new MusicCanvas(composer.getMelody(),composer.getChords(),composer.getNotesPlayed());
        
        /*MAIN JPANEL*/
        JPanel userInterface = new JPanel();
        userInterface.setLayout(new BorderLayout(20,10));
        /*MUSIC DISPLAY PANEL*/
        JPanel musicDisplay = new JPanel();
        musicDisplay.setLayout(new GridLayout(1,1));
        musicDisplay.add(canvas);
        /*TITLE PANEL*/
        JPanel titleBar = new JPanel();
        title = new JLabel("JAVA COMPOSER");
        title.setFont(f);
        titleBar.add(title);
        /*PLAY BUTTON PANEL*/
        JPanel buttonBar = new JPanel();
        play = new JButton("PLAY");
        play.addActionListener(this);
        buttonBar.add(play);
        
        /*ADD PANELS TO BORDERLAYOUT*/
        userInterface.add(musicDisplay, BorderLayout.CENTER);
        userInterface.add(titleBar, BorderLayout.NORTH);
        userInterface.add(buttonBar, BorderLayout.SOUTH);
        
        /*DISPLAY WINDOW*/
        window.add(userInterface);
        window.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==play) /*PLAY BUTTON EVENT*/
        {
            /*PREPARE SONG*/
            int chordSet = (int) (Math.random()*3)+1; //pick random chord progression
            composer.newSong(chordSet);
            composer.setSong();
            int tempo = (int) (Math.random()*500)+100; //pick random temp 100-600
            timer = new Timer(tempo, this);
            timer.start(); //start song
        }
        if(e.getSource()==timer) /*TIMER TICK EVENT*/
        {
            composer.nextBeat(); //load next note
            canvas.setData(composer.getMelody(),composer.getChords(),composer.getNotesPlayed()); //update canvas data
            if(composer.songOver()) //check if song is over
                timer.stop();
        }
        canvas.repaint();//repaint after every event
    }
}