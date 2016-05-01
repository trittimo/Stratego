package stratego.logic;

import stratego.logic.exceptions.InvalidAction;
import stratego.logic.exceptions.InvalidLocation;
import stratego.logic.exceptions.InvalidMovement;
import stratego.logic.exceptions.InvalidPiece;
import stratego.logic.exceptions.InvalidPlacement;

/**
 * The Board class represents the Stratego Board. It contains the pieces that
 * are placed on it. These piece's locations on the board can be manipulated by
 * calling placePiece(), movePiece(), and removePiece()
 */

public class Board {

	private Piece[][] pieces;
	private boolean isBeginning;
	
	public Board(Piece[][] pieces) {
		this.pieces = pieces;
		this.isBeginning = true;
	}

	/**
	 * 
	 * @return
	 */
	public Piece[][] getPieces() {
		return this.pieces;
	}
	
	/**
	 * 
	 * Sets the beginning boolean to what is passed in 
	 *
	 * @param bool- is this the beginning of the game? 
	 */
	
	public void setBeginning(boolean bool){
		this.isBeginning = bool; 
	}

	/**
	 * Return true if it is the river part of the board.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isRiver(int x, int y) {
		if ((x >= 2 && y >= 4 && x <= 3 && y <= 5) || (x >= 7 && y >= 4 && x <= 8 && y <= 5)) {
			return true;
		}
		return false;
	}

	/**
	 * Return if a piece and be put on the position on the board
	 * 
	 * @return
	 */
	public boolean isValidToPlacePiece(int x, int y, int player) {
		if (isRiver(x, y)) {
			return false;
		} else if (this.isBeginning) {
			return ((y < 4 && player == 1) || (y > 5 && player == 2)) && !this.isOccupied(x, y);
		} else {
			return !this.isBeginning && !this.isOccupied(x, y);
		}
	}

	/**
	 * Returns the piece at position (x, y) on the board, or an InvalidPiece
	 * exception if no piece is found
	 * 
	 * @param x
	 *            xPosition of piece on board
	 * @param y
	 *            yPosition of piece on board
	 * @return
	 */
	public Piece getPiece(int x, int y) {
		if (this.pieces[x][y] != null) {
			return pieces[x][y];
		} else {
			throw new InvalidPiece(x, y);
		}
	}

	/**
	 * @return the total number of pieces on the board
	 */
	public int pieceCount() {
		int count = 0;
		for (int i = 0; i < this.pieces.length; i++) {
			for (int j = 0; j < this.pieces[0].length; j++) {
				if (this.pieces[i][j] != null) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Checks whether a location on the board is occupied throws
	 *
	 * @param x
	 *            xPosition to check
	 * @param y
	 *            yPosition to check
	 * @return true if the location is occupied, false otherwise
	 * 
	 */
	public boolean isOccupied(int x, int y) {
		if (x < 0 || y < 0 || x > this.pieces.length || y > this.pieces[0].length) {
			throw new InvalidLocation(x, y);
		}
		return !(this.pieces[x][y] == null);
	}

	/**
	 * Place a piece on the board at position (x, y)
	 * 
	 * @param x
	 *            position of piece on board
	 * @param y
	 *            position of piece on board
	 * @param p
	 *            - the piece object to be placed on the board
	 */
	public void placePiece(int x, int y, Piece p) {
		if (x < 0 || y < 0 || x > pieces.length || y > pieces[0].length) {
			throw new InvalidPlacement(p, this, x, y, "Attempt to place piece outside of the board");
		} else if (isOccupied(x, y)) {
			throw new InvalidPlacement(p, this, x, y, "Attempt to place piece in an already occupied location");
		}
		this.pieces[x][y] = p;
	}

	/**
	 * Check if a piece is allowed to move from (x1, y1) to (x2, y2): only does
	 * distance and directional testing
	 * 
	 * @param x1
	 *            starting position of piece on board
	 * @param x2
	 *            starting position of piece on board
	 * @param y1
	 *            final position of piece on board
	 * @param y2
	 *            final position of piece on board
	 * @return true if a piece can move from (x1, y1) to (x2, y2)
	 */
	public boolean isValidMoveDirection(int x1, int y1, int x2, int y2) {
		Piece piece = this.pieces[x1][y1];
		if (x1 != x2 && y1 != y2) {
			return false;
		} else if (piece.getValue() != 9 && Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1)) > 1) {
			return false;
		}
		return true;
	}

	/**
	 * Move a piece at location (x1, y1) to (x2, y2)
	 * 
	 * @param x1
	 *            starting position of piece on board
	 * @param y1
	 *            starting position of piece on board
	 * @param x2
	 *            final position of piece on board
	 * @param y2
	 *            final position of piece on board
	 */
	public void movePiece(int x1, int y1, int x2, int y2)  {
		if (this.pieces[x1][y1] == null) {
			throw new InvalidMovement("non-existant", x1, y1, x2, y2);
		} else if (this.pieces[x2][y2] != null) {
			throw new InvalidMovement(this.pieces[x1][y1].getPieceName(), x1, y1, x2, y2);
		} else if (!isValidMoveDirection(x1, y1, x2, y2)) {
			throw new InvalidMovement(this.pieces[x1][y1].getPieceName(), x1, y1, x2, y2);
		} else if (!isValidToPlacePiece(x2, y2, this.pieces[x1][y1].getPlayer())){
			throw new InvalidMovement(this.pieces[x1][y1].getPieceName(), x1, y1, x2, y2);
		}

		this.pieces[x2][y2] = this.pieces[x1][y1];
		this.pieces[x1][y1] = null;
	}

	/**
	 * Removes the piece at (x, y)
	 * 
	 * @param x
	 *            position of piece on board
	 * @param y
	 *            position of piece on board
	 */
	public void removePiece(int x, int y) {
		if (this.pieces[x][y] == null) {
			throw new InvalidAction("Cannot remove piece at (" + x + ", " + y + "): piece does not exist");
		}
		this.pieces[x][y] = null;
	}

}
