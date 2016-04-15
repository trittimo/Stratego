package stratego.logic;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

import stratego.logic.exceptions.InvalidAction;
import stratego.logic.exceptions.InvalidMovement;
import stratego.logic.exceptions.InvalidPlacement;

public class TestBoard {

	@Test
	public void getPiece() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);

		Piece fakePiece = EasyMock.niceMock(Piece.class);
		EasyMock.replay(fakePiece);

		b.placePiece(2, 2, fakePiece);
		assertTrue(b.getPiece(2, 2) == fakePiece);

		EasyMock.verify(fakePiece);
	}

	@Test
	public void testPlacementOutsideBoard() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);

		Piece fakePiece = EasyMock.niceMock(Piece.class);

		EasyMock.replay();

		try {
			b.placePiece(4, 4, fakePiece);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPlacement);
		}

		EasyMock.verify();
	}

	@Test
	public void testPlacementOnPiece() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);

		Piece fakePiece = EasyMock.niceMock(Piece.class);

		EasyMock.replay();

		b.placePiece(2, 2, fakePiece);
		try {
			b.placePiece(2, 2, fakePiece);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPlacement);
		}

		EasyMock.verify();
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

		Piece fakePiece = EasyMock.niceMock(Piece.class);

		EasyMock.expect(fakePiece.getPieceName()).andReturn("piece");

		EasyMock.replay(fakePiece);

		b.placePiece(1, 1, fakePiece);
		b.placePiece(2, 2, fakePiece);
		try {
			b.movePiece(1, 1, 2, 2);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidMovement);
		}

		EasyMock.verify(fakePiece);
	}

	@Test
	public void testMoveTooFar() {
		Piece[][] pieces = new Piece[5][5];
		Board b = new Board(pieces);

		Piece fakePiece = EasyMock.niceMock(Piece.class);

		EasyMock.expect(fakePiece.getPieceName()).andReturn("piece");

		EasyMock.replay(fakePiece);

		b.placePiece(1, 1, fakePiece);
		try {
			b.movePiece(1, 1, 1, 4);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidMovement);
		}

		EasyMock.verify(fakePiece);
	}

	@Test
	public void testMoveInvalidDirection() {
		Piece[][] pieces = new Piece[5][5];
		Board b = new Board(pieces);
		Piece fakePiece = EasyMock.niceMock(Piece.class);

		b.placePiece(1, 1, fakePiece);

		EasyMock.replay(fakePiece);
		assertFalse(b.isValidMoveDirection(1, 1, 2, 2));
		EasyMock.verify(fakePiece);
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
		
		Piece fakePiece = EasyMock.niceMock(Piece.class);

		b.placePiece(0, 0, fakePiece);
		piecestest[0][0] = fakePiece;

		EasyMock.replay(fakePiece);
		assertFalse(b.isValidMoveDirection(1, 1, 2, 2));
		assertEquals(b.getPieces()[0][0].getValue(), piecestest[0][0].getValue());
		EasyMock.verify(fakePiece);
	}

	@Test
	public void testPlacePiece2() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		
		Piece fakePiece = EasyMock.niceMock(Piece.class);
		Piece fakePiece2 = EasyMock.niceMock(Piece.class);
		
		b.placePiece(0, 0, fakePiece);
		b.placePiece(0, 1, fakePiece2);

		EasyMock.replay(fakePiece,fakePiece2);
		assertEquals(b.getPieces()[0][0].getValue(), fakePiece.getValue());
		assertEquals(b.getPieces()[0][1].getValue(), fakePiece2.getValue());
		EasyMock.verify(fakePiece,fakePiece2);		
	}

	@Test
	public void testMove1() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		Piece fakePiece = EasyMock.niceMock(Piece.class);
		
		EasyMock.replay(fakePiece);
		b.placePiece(0, 0, fakePiece);
		assertEquals(b.getPieces()[0][0].getValue(), fakePiece.getValue());

		b.movePiece(0, 0, 1, 0);
		assertEquals(b.getPieces()[1][0].getValue(), fakePiece.getValue());
		EasyMock.verify(fakePiece);		

	}

	@Test
	public void testMove2() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
	
		Piece fakePiece = EasyMock.niceMock(Piece.class);
		
		EasyMock.expect(fakePiece.getValue()).andReturn(9);
		EasyMock.expect(fakePiece.getValue()).andReturn(9);
		EasyMock.expect(fakePiece.getValue()).andReturn(9);
		
		EasyMock.replay(fakePiece);
		
		b.placePiece(0, 0, fakePiece);
		assertEquals(b.getPieces()[0][0].getValue(), fakePiece.getValue());

		b.movePiece(0, 0, 2, 0);
		assertEquals(b.getPieces()[2][0].getValue(), fakePiece.getValue());
		
		EasyMock.verify(fakePiece);

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
