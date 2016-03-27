package stratego.logic;

import static org.junit.Assert.*;

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

}
