

package foley;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;

/*******************************************************************************
 *Create a JFrame GUI that acts like a Foley machine for a play or radio production.
 *A Foley artist is a sound effects specialist who makes sound effects for cartoons,
 * radio segments, etc. Your GUI should be a machine that the Foley artist can use
 * to generate sound effects. It should have labels with buttons that each play a
 * short sound effect. The user should be able to play the GUI like an instrument
 * by clicking the buttons to make various humorous sounds. The design of the 
 * instrument is up to you, but don’t make it too complicated.
 * 
 * @author milto_000
 ******************************************************************************/
public class Foley {
    public static void main(String[] args) {
       Frame myJFrame = new Frame();
       
       myJFrame.setTitle("Foley Machine");
       myJFrame.setSize(500, 280);
       myJFrame.setLocation(400, 100);
       myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
       myJFrame.setVisible(true); 
       
    }//end main()
    
}// end class Foley
//==============================================================================
class Frame extends JFrame implements ActionListener {
    JButton a = new JButton("Barly");
    JButton b = new JButton("Boy if you dont");
    JButton c = new JButton("Bruh");
    JButton d = new JButton("Illuminati");
    JButton e = new JButton("Oh hell NAW");
    JButton f = new JButton("Why you lying");
    
//==============================================================================    
    public Frame(){
        
        setLayout(new BorderLayout());
        
        JPanel buttonsPanel = new JPanel(new GridLayout(2,3));
        
        buttonsPanel.add(a);
        buttonsPanel.add(b);
        buttonsPanel.add(c);
        buttonsPanel.add(d);
        buttonsPanel.add(e);
        buttonsPanel.add(f);
        add(buttonsPanel, BorderLayout.CENTER);
        
        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        e.addActionListener(this);
        f.addActionListener(this);
        
    }// end Frame()
    //==========================================================================
    public void actionPerformed(ActionEvent e) {
         try {

            // identify the sound file as a File class object
            File soundFile = null;
            if (e.getSource() == a) 
             {
                soundFile = new File("Barely.wav");
             } // end if
            if (e.getSource() == b) 
            {
                soundFile = new File("Boy.wav");
            } // end if
            if (e.getSource() == c) 
            {
                soundFile = new File("Bruh.wav");
            } // end if
            if (e.getSource() == d) 
            {
                soundFile = new File("Illuminati.wav");
            } // end if
            if (e.getSource() == this.e) 
            {
                soundFile = new File("Oh.wav");
            } // end if
            if (e.getSource() == f) 
            {
                soundFile = new File("Why.wav");
            } // end if
            // Create an AudioInputStream for the File object soundFile
            // This allows Java to read the file and read it as audio data in one step.
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            // create an audio Clip object so we can use the Clip class methods 
            Clip myClip = AudioSystem.getClip();

            // open the myClip object and associate it with the audioIn AudioInputStream
            myClip.open(audioIn);

            // start playing the myClip audio Clip
            myClip.start();


        } catch (UnsupportedAudioFileException c) {
            c.printStackTrace();
        } catch (IOException c) {
            c.printStackTrace();
        } catch (LineUnavailableException c) {
            c.printStackTrace();
        }  // end catch
        
    }//end ActionPerformed
            
}//end class Frame
