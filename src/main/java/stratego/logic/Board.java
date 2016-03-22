package stratego.logic;

public class Board {

	private Piece[][] pieces;
	
	public Board(Piece[][] pieces) {
		this.pieces = pieces;
	}
	
	public Piece[][] getPieces(){
		return pieces;
	}

	public void placePiece(int r, int c, Piece p) {
		// TODO Auto-generated method stub
		pieces[0][0] = new Piece (10, 0);
	}
	
}
