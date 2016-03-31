package stratego.logic;

/**
 * This class contains the information about the game itself as well as the
 * gameplay
 */
public class Game {

	private Board gameBoard;
	private int whoseTurn;

	public Game(Board b) {
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
	 * switches the player turns to be called after moves are made
	 */
	public void switchTurns() {
		if (whoseTurn == 1)
			this.whoseTurn = 2;
		else
			this.whoseTurn = 1;
	}

	/**
	 * Attempts to move a piece at position (x1, y1) to position (x2, y2)
	 * @param x1 piece1 x
	 * @param y1 piece1 y
	 * @param x2 piece2 x
	 * @param y2 piece2 y
	 */
	public boolean makeMove(int x1, int y1, int x2, int y2) {
		Board b = this.gameBoard;
		try {
			if (b.isOccupied(x2, y2)) {
	
				if (b.getPieces()[x1][y1].getRank() > b.getPieces()[x2][y2].getRank()) {
					b.removePiece(x2, y2);
					b.movePiece(x1, y1, x2, y2);
				} else {
					b.removePiece(x1, y1);
				}
	
			} else {
				b.movePiece(x1, y1, x2, y2);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
