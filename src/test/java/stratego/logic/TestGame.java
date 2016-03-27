package stratego.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGame {

	@Test
	public void testBoardEmpty() {
		Game g = new Game();
		Board b1 = g.getBoard();
		
		Piece[][] p = new Piece[10][10];
		Board b2 = new Board(p);
		
		assertEquals(b1.pieceCount(), b2.pieceCount());
	}
	
	@Test
	public void addPieceToBoardTest() {
		Game g = new Game();
		Board b1 = g.getBoard();
		
		Piece[][] p = new Piece[10][10];
		Board b2 = new Board(p);
		
		assertEquals(b1.pieceCount(), b2.pieceCount());
		
		Piece p1 = new Piece (1, 1);
		b1.placePiece(3, 0, p1);
		
		b2.placePiece(3, 0, p1);
		
		assertEquals(g.getBoard().pieceCount(), b2.pieceCount());
		
		
		
		
		
	}
	

	

}
