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
		// TODO Auto-generated method stub
		this.pieces[r][c] = p;
	}
	
}
