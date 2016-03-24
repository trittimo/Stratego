package stratego.logic;

import stratego.logic.exceptions.InvalidAction;
import stratego.logic.exceptions.InvalidMovement;
import stratego.logic.exceptions.InvalidPlacement;

public class Board {

	private Piece[][] pieces;

	public Board(Piece[][] pieces) {
		this.pieces = pieces;
	}

	public Piece[][] getPieces() {
		return this.pieces;
	}

	public void placePiece(int x, int y, Piece p) {
		if (x < 0 || y < 0 || x > pieces.length || y > pieces[0].length) {
			throw new InvalidPlacement(p, this, x, y,
					"Attempt to place piece outside of the board");
		} else if (isOccupied(x, y)) {
			throw new InvalidPlacement(p, this, x, y,
					"Attempt to place piece in an already occupied location");
		}
		this.pieces[x][y] = p;
	}

	public void movePiece(int x1, int y1, int x2, int y2) {
		if (this.pieces[x1][y1] == null) {
			throw new InvalidMovement("non-existant", x1, y1, x2, y2);
		} else if (this.pieces[x2][y2] != null) {
			throw new InvalidMovement(this.pieces[x1][y1].getPieceName(), x1, y1, x2, y2);
		} else if (!isValidMoveDirection(x1, x2, y1, y2)) {
			throw new InvalidMovement(this.pieces[x1][y1].getPieceName(), x1, y1, x2, y2);
		}

		this.pieces[x2][y2] = this.pieces[x1][y1];
		this.pieces[x1][y1] = null;
	}

	public boolean isValidMoveDirection(int x1, int x2, int y1, int y2) {
		Piece piece = this.pieces[x1][y1];
		if (x1 != x2 && y1 != y2) {
			return false;
		} else if (piece.getValue() != 9 && Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1)) > 1) {
			return false;
		}
		return true;
	}

	public void removePiece(int x, int y) {
		if (this.pieces[x][y] == null) {
			throw new InvalidAction(
					"Cannot remove piece at (" + x + ", " + y + "): piece does not exist");
		}
		this.pieces[x][y] = null;
	}

	public boolean isOccupied(int x, int y) {
		if (this.pieces[x][y] == null) {
			return false;
		} else {
			return true;
		}
	}

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

}
