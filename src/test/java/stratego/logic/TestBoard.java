package stratego.logic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
		Board b = new Board(pieces);
		Piece p = new Piece(10, 0);
		b.placePiece(0, 0, p);
		assertEquals(b.getPieces()[0][0].getValue(),p.getValue());
		Piece p2 = new Piece(5, 1);
		b.placePiece(0, 1, p2);
		assertEquals(b.getPieces()[0][1].getValue(), p2.getValue());
	}
	
	@Test
	public void testMove1(){
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		Piece p = new Piece(10, 0);
		b.placePiece(0, 0, p);
		assertEquals(b.getPieces()[0][0].getValue(),p.getValue());
		
		b.movePiece(0, 0, 2, 2);
		assertEquals(b.getPieces()[2][2].getValue(), p.getValue());
		
	}
	
	@Test
	public void testMove2(){
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		Piece p = new Piece(10, 0);
		b.placePiece(0, 0, p);
		assertEquals(b.getPieces()[0][0].getValue(),p.getValue());
		
		b.movePiece(0, 0, 1, 1);
		assertEquals(b.getPieces()[1][1].getValue(), p.getValue());
		
	}
	
	@Test
	public void testRemove(){
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		Piece p = new Piece(10, 0);
		b.placePiece(0, 0, p);
		b.removePiece(0, 0);
		
		assertEquals(b.getPieces()[0][0], null);
		
	}
}
