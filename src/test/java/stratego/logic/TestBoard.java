package stratego.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBoard {

	@Test
	public void testGetPieces() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		assertEquals(b.getPieces(), pieces);
	}

}
