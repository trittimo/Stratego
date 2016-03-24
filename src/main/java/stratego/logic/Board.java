package stratego.logic;

public class Board {

	private Piece[][] pieces;
	
	public Board(Piece[][] pieces) {
		this.pieces = pieces;
	}
	
	public Piece[][] getPieces(){
		return this.pieces;
	}

	public void placePiece(int r, int c, Piece p) {
		this.pieces[r][c] = p;
	}

	public void movePiece(int r1, int c1, int r2, int c2) {
		this.pieces[r2][c2] = this.pieces[r1][c1];
		this.pieces[r1][c1] = null;
	}

	public void removePiece(int r, int c) {
		this.pieces[r][c] = null;
	}

	public boolean isOccupied(int r, int c) {
		if(this.pieces[r][c] == null){
			return false;
		}else{
			return true;
		}
	}

	public int pieceCount() {
		return 0;
	}
	
}
