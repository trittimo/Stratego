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
		if (whoseTurn == 1)
			this.whoseTurn = 2;
		else
			this.whoseTurn = 1;
	}


	public void makeMove(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		
		this.gameBoard.movePiece(0, 0, 0, 1);
	}
	
}
