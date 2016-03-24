package stratego.logic;

public class Board {

	private Piece[][] pieces;
	
	public Board(Piece[][] pieces) {
		this.pieces = pieces;
	}
	
	public Piece[][] getPieces(){
		return this.pieces;
	}

	public void placePiece(int x, int y, Piece p) {
		this.pieces[x][y] = p;
	}

	public void movePiece(int x1, int y1, int x2, int y2) {
		this.pieces[x2][y2] = this.pieces[x1][y1];
		this.pieces[x1][y1] = null;
	}

	public void removePiece(int x, int y) {
		this.pieces[x][y] = null;
	}

	public boolean isOccupied(int x, int y) {
		if(this.pieces[x][y] == null){
			return false;
		}else{
			return true;
		}
	}

	public int pieceCount() {
		int count = 0;
		for(int i = 0; i < this.pieces.length; i++){
			for(int j = 0; j < this.pieces[0].length; j++){
				if(this.pieces[i][j] != null){
					count++;
				}
			}
		}
		return count;
	}
	
}
