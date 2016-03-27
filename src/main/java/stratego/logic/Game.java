package stratego.logic;

public class Game {
	
	private Board gameBoard;
	private int whoseTurn;
	
	
	public Game (Board b){
		this.gameBoard = b; 
		this.whoseTurn = 1;
		
		
	}
	

	public Board getBoard() {
		// TODO Auto-generated method stub
		return this.gameBoard;
	}


	public int whoseTurn() {
		// TODO Auto-generated method stub.
		return this.whoseTurn;
	}


	public void switchTurns() {
		// TODO Auto-generated method stub
		this.whoseTurn = 2;
	}
	
}
