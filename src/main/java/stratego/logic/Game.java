package stratego.logic;

/**
 * This class contains the information about the game itself as well as the gameplay 
 */
public class Game {
	
	
	private Board gameBoard;
	private int whoseTurn;
	
	
	
	
	public Game (Board b){
		this.gameBoard = b; 
		this.whoseTurn = 1;
		
	}
	
	/**
	 * @return the Board object assigned for this game 
	 */

	public Board getBoard() {
		return this.gameBoard;
	}

	/**
	 * @return the integer value of the player 
	 */
	public int whoseTurn() {
		return this.whoseTurn;
	}

	/**
	 * void method that switches the player turns 
	 * to be called after moves are made 
	 */

	public void switchTurns() {
		if (whoseTurn == 1)
			this.whoseTurn = 2;
		else
			this.whoseTurn = 1;
	}
	
}
