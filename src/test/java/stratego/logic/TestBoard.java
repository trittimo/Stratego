package stratego.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBoard {

	@Test
	public void testGetPieces() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		assertArrayEquals(b.getPieces(), pieces);
	}

	@Test
	public void testPlacePiece() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		Piece p = new Piece(10, 0);
		b.placePiece(0, 0, p);
		assertArrayEquals(b.getPieces(), pieces);
	}
}
