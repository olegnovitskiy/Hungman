import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.sound.sampled.*;

public class GUI_Winner extends GUI_GameOver implements ActionListener
{
    private JFrame congratulationsFrame;
    private JLabel answerLabel;
    
    
    private ImageIcon background;
    private JPanel imagePanel;
    
    public GUI_Winner(String Letters,JFrame frame)
    {
        super(Letters, frame);
        congratulationsFrame = new JFrame("You are the winner!!!");
        bg(congratulationsFrame);
        answerLabel = new JLabel("The answer is ");
        
        secretWordLabel = new JLabel(Letters);
        secretWordLabel.setFont(new Font("Default",Font.PLAIN,23));
        secretWordLabel.setForeground(Color.red);
        gameResultLabel = new JLabel("You are winner!");
       

       
        
        congratulationsFrame.add(answerLabel);
        congratulationsFrame.add(secretWordLabel);
        congratulationsFrame.add(gameResultLabel);
        congratulationsFrame.add(returnBtn);
        congratulationsFrame.setVisible(true);

    }

    public void bg(JFrame frame)
    {
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
        congratulationsFrame.dispose();
        super.actionPerformed(e);
        
    }
}