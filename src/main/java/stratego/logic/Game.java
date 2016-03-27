package stratego.logic;

public class Game {
	
	private Board gameBoard; 
	
	
	public Game (Board b){
		this.gameBoard = b; 
		
		
		
	}
	

	public Board getBoard() {
		// TODO Auto-generated method stub
		return this.gameBoard;
	}


	public int whoseTurn() {
		// TODO Auto-generated method stub.
		return 1;
	}
	
}
