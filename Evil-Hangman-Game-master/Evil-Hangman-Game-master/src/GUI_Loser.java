import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class GUI_Loser implements ActionListener
{
    private JFrame MainMenu;
    private JFrame Suck;
    private JLabel SecretWord;
    private JLabel GameResult;
    private JButton ReturnBtn;
    private JLabel loserPic;
    private Clip clip;
    public GUI_Loser(String Letters,JFrame frame)
    {
        //play the audio
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("loser.wav"));
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        }

        catch(UnsupportedAudioFileException uae) {
            System.out.println(uae);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        catch(LineUnavailableException lua) {
            System.out.println(lua);
        }
        
        MainMenu = frame;
        Suck = new JFrame("You are the loser!");
        Suck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Suck.setSize(new Dimension(300,470));
        Suck.setLayout(new FlowLayout());
        
        SecretWord = new JLabel("The answer is "+Letters+".");
        GameResult = new JLabel("You are the Loser!");
        ReturnBtn = new JButton("Return to the main menu");
        
        ReturnBtn.addActionListener(this); 
        
        ImageIcon icon = new ImageIcon("loser.gif"); 
        loserPic = new JLabel(icon);

        
        Suck.add(SecretWord);
        Suck.add(GameResult);
        Suck.add(ReturnBtn);
        Suck.add(loserPic);
        
        Suck.setVisible(true);
        
     
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //when player click the button:
        clip.stop();//audio stop
        Suck.dispose();//the loser menu closed
        MainMenu.setVisible(true);//Main menu is set visible
    }
}