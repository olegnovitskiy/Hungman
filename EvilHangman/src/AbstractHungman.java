
public abstract class AbstractHungman implements HangmanGame {
	
	protected String originSecretWord = "";//To store the secret word
    protected int guessesRemaining;//to store the number of guess for the user
    protected String currentState = "";//store the current guessing situation
    protected String history = "";//store the letter user has tried
    protected char guess;//the letter the user guess right now


	
	public String getSecretWord()
    {
        return originSecretWord;
    }

	
	public abstract boolean makeGuess(char ch);

	public abstract boolean isWin();

	
	public abstract boolean gameOver();

	
	public int numGuessesRemaining() {
		return guessesRemaining;
	}

	public abstract int numLettersRemaining();

	@Override
	public String displayGameState()
    {
        return currentState;
    }

	@Override
	public String lettersGuessed()
    {
        return history;
    }
	
  public boolean alreadyGuessed(char c)
    {
    	for (int i = 0; i < history.length(); i++) {
    		if (history.charAt(i) == c) return true;
    	}
    	return false;
    }

}
