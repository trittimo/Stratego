package stratego.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import stratego.logic.exceptions.InvalidPieceValue;

public class TestPiece {

	@Test
	public void testPieceConstrutor() throws InvalidPieceValue {
		Piece newPiece = new Piece(1, 1);
		assertEquals(newPiece.getValue(), 1);
	}

	@Test
	public void testGetPlayer() throws InvalidPieceValue {
		Piece newPiece = new Piece(1, 1);
		assertEquals(newPiece.getPlayer(), 1);
	}

	@Test
	public void testGetPieceName() throws InvalidPieceValue {
		Piece newPiece = new Piece(1, 1);
		assertEquals(newPiece.getPieceName(), "Marshal");

	}

	@Test
	public void testGetPieceName2() throws InvalidPieceValue {
		Piece newPiece = new Piece(3, 1);
		assertEquals(newPiece.getPieceName(), "Colonel");

	}

	@Test
	public void testInvalidPieceValue() {
		try {
			Piece newPiece = new Piece(-1, 1);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPieceValue);
		}
	}
}
