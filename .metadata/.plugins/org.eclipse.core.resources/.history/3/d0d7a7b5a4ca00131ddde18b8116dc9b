/**
 * <p>A class that keeps track of the current state of a game of hangman.</p>
 * <p> The class is constructed with a secret word and some number of guesses.</p>
 * <p>Everytime a letter is guessed, the state of the game is updated appropriately
 * integrating the guessed letter into the word, updating the number of guesses
 * remaining, etc.</p>
 * 
 * <p>This class can then be used by a user interface to administer a regular game of Hangman.</p>
 */
import java.util.*;
public class MyHangmanGame implements HangmanGame
{
    
    //Add your private member variables here
	private String OriginSecretWord = "";//To store the secret word
    private int GuessRemainingNum;//to store the number of guess for the user
    private int LetterLeftNum;//to store the number of the letters in the secret word has not been guessed correctly
    private String CurrentState = "";//store the current guessing situation
    private String LetterGuessHistory = "";//store the letter user has tried
    private char LetterGuess;//the letter the user guess right now

    /**
     * Constructor sets up the game to be played with a word and some number of
     * guesses.  The class should have private variables that keep track of:
     * <li>The original secret word
     * <li>The number of guesses remaining
     * <li>The number of letters that still need to be guessed
     * <li>The current state of word to be guessed (e.g. "L A B _ R A _ _ R Y")
     * @param secretWord the word that the player is trying to guess
     * @param numGuesses the number of guesses allowed
     */
    public MyHangmanGame(String secretWord, int numGuesses, String LetterHistory){
        OriginSecretWord = secretWord;
        GuessRemainingNum = numGuesses;
        LetterLeftNum = secretWord.length();
        for(int i = 0; i < secretWord.length(); i++)
        {
            CurrentState += "_ ";
            for(int j = i; j > 0; j--)
            {
                if(secretWord.charAt(i) == secretWord.charAt(j-1))
                {
                    LetterLeftNum--;//If the letter appears many times in the secret word, it will be counted just once.
                    break;
                }
            }
        }
        LetterGuessHistory = LetterHistory;
    }   
    //add your methods below
    public String getSecretWord()
    {
        return OriginSecretWord;
    }
    public int numGuessesRemaining()
    {
        return GuessRemainingNum;
    }
    public int numLettersRemaining()
    {
        return LetterLeftNum;
    }
    public boolean isWin()
    {
        if(GuessRemainingNum == 0)
            return false;//if the user have no chance to guess again, it means the user loses.
        else
            return true;
    }
    public boolean gameOver()
    {
        if(GuessRemainingNum == 0 || LetterLeftNum == 0)
            return true;
        else
            return false;
    }
    public String lettersGuessed()
    {
        LetterGuessHistory = LetterGuessHistory + LetterGuess;
        return LetterGuessHistory;
    }
    public String displayGameState()
    {
        return CurrentState;
    }
    public boolean makeGuess(char ch)
    {
        boolean tempB = true;
        LetterGuess = ch;
        int i;
        for(i = 0; i < OriginSecretWord.length(); i++)
        {
            if(OriginSecretWord.charAt(i) == ch)//if the user guess right, adjust the current state.
            {
                String temp = "";
                for(int j = 0; j < OriginSecretWord.length(); j++)
                {
                    if(OriginSecretWord.charAt(j) == ch)
                    {
                        temp = temp + ch + " ";
                    }
                    else
                    {
                        temp = temp + CurrentState.charAt(2*j) + CurrentState.charAt(2*j+1);              
                    }
                }
                CurrentState = temp;
                tempB = true;
                break;
            }
            else
            {
                tempB = false;
            }
        }
        if(!RepeatInput())
        {
            if(tempB)
            {
                LetterLeftNum--;
            }
            else
            {
                GuessRemainingNum--;
            }
            return tempB;
        }
        else//if the user input some letter as the same as he guessed before, the user should try another letter.
        {
            System.out.println("Please don't make a same guess");
            System.out.print("Next guess: ");
            Scanner S2  = new Scanner(System.in);
            String input = "";
            input = S2.nextLine().toUpperCase(); //ensure all guesses converted to upper case
            System.out.println(); //force the line break
            char ch2 = input.charAt(0);
            S2.close();
            return makeGuess(ch2);        
        }
    }
    public boolean RepeatInput()
    {
        return false;
    }
    
   
}
    
       