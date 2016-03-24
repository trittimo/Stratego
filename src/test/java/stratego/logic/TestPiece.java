package stratego.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import stratego.logic.exceptions.InvalidPieceValue;
import stratego.logic.exceptions.InvalidPlayer;

public class TestPiece {

	@Test
	public void testPieceConstrutor() {
		Piece newPiece = new Piece(1, 1);
		assertEquals(newPiece.getValue(), 1);
	}

	@Test
	public void testGetPlayer() {
		Piece newPiece = new Piece(1, 1);
		assertEquals(newPiece.getPlayer(), 1);
	}

	@Test
	public void testGetPieceName() {
		Piece newPiece = new Piece(1, 1);
		assertEquals(newPiece.getPieceName(), "Marshal");

	}

	@Test
	public void testGetPieceName2() {
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

	@Test
	public void testInvalidPlayer() {
		try {
			Piece newPiece = new Piece(1, -1);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPlayer);
		}
	}
}
