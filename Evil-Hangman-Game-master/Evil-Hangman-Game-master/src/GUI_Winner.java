import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class GUI_Winner implements ActionListener
{
    private JFrame MainMenu;
    private JFrame Congra;
    private JLabel Des;
    private JLabel SecretWord;
    private JLabel GameResult;
    private JButton ReturnBtn;
    private ImageIcon background;
    private JPanel imagePanel;
    private Clip clip;
    public GUI_Winner(String Letters,JFrame frame)
    {
        //Play the audio
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("cheer.wav"));
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
        Congra = new JFrame("You are the winner!!!");
        bg(Congra);
        Des = new JLabel("The answer is ");
        
        SecretWord = new JLabel(Letters);
        SecretWord.setFont(new Font("Default",Font.PLAIN,23));
        SecretWord.setForeground(Color.red);
        GameResult = new JLabel("You are winner!");
        ReturnBtn = new JButton("Return to the main menu");

        ReturnBtn.addActionListener(this); 
        
        Congra.add(Des);
        Congra.add(SecretWord);
        Congra.add(GameResult);
        Congra.add(ReturnBtn);

        Congra.setVisible(true);

    }

    public void bg(JFrame frame)
    {
        //set Background Image
        background = new ImageIcon("Congrats.gif");
        JLabel label = new JLabel(background);
     
        label.setBounds(0, 0, background.getIconWidth(),
            background.getIconHeight());
   
        imagePanel = (JPanel) frame.getContentPane();
        imagePanel.setOpaque(false);

        imagePanel.setLayout(new FlowLayout());

        frame.getLayeredPane().setLayout(null);

        frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(background.getIconWidth(), background.getIconHeight());
        frame.setResizable(false);

    }

    public void actionPerformed(ActionEvent e)
    {
        //when play click the button to go back to the main menu
        //stop the audio
        clip.stop();
        //destroy the frame
        Congra.dispose();
        //Set the MainMenu visible again.
        MainMenu.setVisible(true);
    }
}