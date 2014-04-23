import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_GuessMenu implements ActionListener
{
    private JFrame MainMenu;
    //private Var for GuessMenu
    private JFrame GuessFrame;
    private JLabel Notification;
    private JLabel GameState;
    private JLabel GuessRemaining;
    private HangmanGame game = new evilHangMan(10,16);
    private char InputLetter;
    private boolean IsEvil = true;
    private JLabel result;
    private JLabel hangmanPic;

    public GUI_GuessMenu(JFrame frame)
    {
        MainMenu = frame;
        GuessFrame = new JFrame("Evil Hangman");
        GuessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GuessFrame.setSize(new Dimension(360,670));
        GuessFrame.setLayout(new FlowLayout());
        GuessFrame.setResizable(false);
        
        Notification = new JLabel("Enjoy the Evil Hangman!");
        
        
        
        GameState = new JLabel("Secret Word: "+game.displayGameState());
        GameState.setFont(new Font("Default",Font.PLAIN,23));
       
        GuessRemaining = new JLabel(String.valueOf("Guesses Remaining: "+ game.numGuessesRemaining()));
        result = new JLabel("");
        result.setForeground(Color.red);
        
        
        //this generates an image file
        ImageIcon icon = new ImageIcon("hangman.gif"); 
        hangmanPic = new JLabel(icon);

        GuessFrame.add(Notification);
        GuessFrame.add(GameState);
        GuessFrame.add(GuessRemaining);


        GuessFrame.add(result);
        
        GuessFrame.add(hangmanPic);
        
        //add user choice
        for(int i = 65; i<91;i++)
        {
            char x = (char)i;
            JButton tempBtn = new JButton(String.valueOf(x));
            tempBtn.addActionListener(this);
            GuessFrame.add(tempBtn);
            
        }
        
        GuessFrame.setResizable(false);
        GuessFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //to figure out which button the user press
        JButton temp = (JButton)e.getSource();
        temp.setEnabled(false);
        InputLetter = temp.getText().charAt(0);//the system will get the user choice
        //check the input. Now since I use the button choice, it seems unnecessary. But I don't want to change it
        //because it is some kind of template.
        if(check(InputLetter))
        {
            Notification.setForeground(Color.black);
            Notification.setText("Enjoy the Evil Hangman!");
            controller();
        }
        else
        {
            Notification.setForeground(Color.red);
            Notification.setText("Please input the letters of an alphabet!");
        }
    }

    
    public void controller()
    {
        //handle the user choice, and pass the data to the model
        char nextLetter = Character.toUpperCase(InputLetter);

        if(game.makeGuess(nextLetter))
        {
            if(IsEvil)//judge whether the hangman is evil
            {
                //if in the evil statement, and the user guess right, it means it is the time to turn the evil to the regular hangmam
                result.setText("Yes!");
                String RealSecretString = game.getSecretWord();
                int GuessRemaining = game.numGuessesRemaining();
                String LetterHistory = game.lettersGuessed();
                game = new MyHangmanGame(RealSecretString, GuessRemaining,LetterHistory);//turn the evil to regular hangman
                IsEvil = false;
                game.makeGuess(nextLetter);//re-value the user guess when turn to the regular hangman for the first time
            }
            else
            {
                result.setText("Yes!");
            }
        }
        else
        {
            result.setText("Nope!");
        }

        GameState.setText("Secret Word: "+game.displayGameState());
        GuessRemaining.setText(String.valueOf("Guesses Remaining: "+ game.numGuessesRemaining()));
        if(game.gameOver())
        {
            GuessFrame.dispose();//destroy the GuessFrame, and let player jump to either Winner or Loser frame
            if(game.isWin())
            {
                new GUI_Winner(game.displayGameState(),MainMenu);
            }
            else
            {
                new GUI_Loser(game.getSecretWord(),MainMenu);
            }
        }
    }

    public boolean check(char input)
    {
        //do the input check. Player can just input the English letters.
        if((input >= 'a' && input <= 'z') || (input >= 'A' && input <= 'Z'))
            return true;
        else
            return false;
    }

}