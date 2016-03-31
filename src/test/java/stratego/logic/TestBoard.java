package stratego.logic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import stratego.logic.exceptions.InvalidAction;
import stratego.logic.exceptions.InvalidMovement;
import stratego.logic.exceptions.InvalidPlacement;

public class TestBoard {

	@Test
	public void getPiece() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		Piece p = new Piece(3, 1);
		b.placePiece(2, 2, p);
		assertTrue(b.getPiece(2, 2) == p);
	}

	@Test
	public void testPlacementOutsideBoard() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		try {
			b.placePiece(4, 4, new Piece(3, 1));
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPlacement);
		}
	}

	@Test
	public void testPlacementOnPiece() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		b.placePiece(2, 2, new Piece(3, 1));
		try {
			b.placePiece(2, 2, new Piece(4, 1));
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPlacement);
		}
	}

	@Test
	public void testRemoveNonExistantPiece() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		try {
			b.removePiece(2, 2);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidAction);
		}

	}

	@Test
	public void testMoveNonExistantPiece() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		try {
			b.movePiece(1, 1, 2, 2);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidMovement);
		}
	}

	@Test
	public void testMoveOverPiece() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		b.placePiece(1, 1, new Piece(3, 1));
		b.placePiece(2, 2, new Piece(3, 2));
		try {
			b.movePiece(1, 1, 2, 2);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidMovement);
		}
	}

	@Test
	public void testMoveTooFar() {
		Piece[][] pieces = new Piece[5][5];
		Board b = new Board(pieces);
		b.placePiece(1, 1, new Piece(1, 1));
		try {
			b.movePiece(1, 1, 1, 4);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidMovement);
		}
	}

	@Test
	public void testMoveInvalidDirection() {
		Piece[][] pieces = new Piece[5][5];
		Board b = new Board(pieces);
		b.placePiece(1, 1, new Piece(1, 1));
		try {
			b.movePiece(1, 1, 2, 2);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidMovement);
		}
	}

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
		Piece p = new Piece(10, 1);
		b.placePiece(0, 0, p);
		piecestest[0][0] = p;
		assertEquals(b.getPieces()[0][0].getValue(), piecestest[0][0].getValue());
	}

	@Test
	public void testPlacePiece2() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		Piece p = new Piece(10, 1);
		b.placePiece(0, 0, p);
		assertEquals(b.getPieces()[0][0].getValue(), p.getValue());
		Piece p2 = new Piece(5, 1);
		b.placePiece(0, 1, p2);
		assertEquals(b.getPieces()[0][1].getValue(), p2.getValue());
	}

	@Test
	public void testMove1() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		Piece p = new Piece(10, 1);
		b.placePiece(0, 0, p);
		assertEquals(b.getPieces()[0][0].getValue(), p.getValue());

		b.movePiece(0, 0, 1, 0);
		assertEquals(b.getPieces()[1][0].getValue(), p.getValue());

	}

	@Test
	public void testMove2() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		Piece p = new Piece(9, 1);
		b.placePiece(0, 0, p);
		assertEquals(b.getPieces()[0][0].getValue(), p.getValue());

		b.movePiece(0, 0, 2, 0);
		assertEquals(b.getPieces()[2][0].getValue(), p.getValue());

	}

	@Test
	public void testRemove1() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		Piece p = new Piece(10, 1);
		b.placePiece(0, 0, p);
		b.removePiece(0, 0);

		assertEquals(b.getPieces()[0][0], null);
	}

	@Test
	public void testRemove2() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		Piece p = new Piece(10, 1);
		b.placePiece(1, 0, p);
		b.removePiece(1, 0);

		assertEquals(b.getPieces()[1][0], null);
	}

	@Test
	public void testIsOccupied1() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);

		assertEquals(b.isOccupied(0, 0), false);
	}

	@Test
	public void testIsOccupied2() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);

		Piece p = new Piece(10, 1);
		b.placePiece(0, 0, p);

		assertEquals(b.isOccupied(0, 0), true);
	}

	@Test
	public void testPieceCount() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);

		assertEquals(b.pieceCount(), 0);

		Piece p = new Piece(10, 1);
		b.placePiece(0, 0, p);

		assertEquals(b.pieceCount(), 1);
	}
}
