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
		Piece[][] piecestest = new Piece[3][3];
		Board b = new Board(pieces);
		Piece p = new Piece(10, 0);
		b.placePiece(0, 0, p);
		piecestest[0][0] = p;
		assertEquals(b.getPieces()[0][0].getValue(), piecestest[0][0].getValue());
	}
	
	@Test
	public void testPlacePiece2() {
		Piece[][] pieces = new Piece[3][3];
		Piece[][] piecestest = new Piece[3][3];
		Board b = new Board(pieces);
		Piece p = new Piece(10, 0);
		b.placePiece(0, 0, p);
		piecestest[0][0] = new Piece(10, 0);
		assertArrayEquals(b.getPieces(), piecestest);
		Piece p2 = new Piece(5, 1);
		b.placePiece(0, 1, p2);
		piecestest[0][1] = new Piece(5, 1);
		assertArrayEquals(b.getPieces(), piecestest);
	}
}
