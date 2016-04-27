package stratego.logic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import stratego.logic.exceptions.InvalidAction;
import stratego.logic.exceptions.InvalidLocation;
import stratego.logic.exceptions.InvalidMovement;
import stratego.logic.exceptions.InvalidPiece;
import stratego.logic.exceptions.InvalidPlacement;

@RunWith(Parameterized.class)
public class TestBoard {

	@Parameters
	public static Collection<Object[]>data(){
		return Arrays.asList(new Object[][]{
			{new Object[] {2,4,1,1}, false}, // River
			{new Object[] {7,5,2,1}, false}, // River
			{new Object[] {5,5,6,1}, false}, // Not river, but can't place since game is starting
			{new Object[] {2,7,10,2}, true}, // Fine
			{new Object[] {2,7,10,1}, false}, // Player 1 can't place here
			{new Object[] {0,0,1,1}, true}, // Edge case for player 1
			{new Object[] {0,0,1,1, 0,0,2,1}, false} // Can't place on already occupied place
		});
	}

	private Object[] args;
	private boolean expected;
	
	public TestBoard(Object[] args, boolean expected){
		this.args = args;
		this.expected = expected;
	}
	

	@Test
	public void testIsValidToPlacePieceNotAtBeginning(){
		Piece[][] pieces = new Piece[10][10]; 
		Board b = new Board(pieces); 
		b.setBeginning(false); 
		
		
		assertTrue(b.isValidToPlacePiece(1, 1, 1)); 
		
		
		
	}
	
	@Test
	public void testGetPieces() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		assertArrayEquals(b.getPieces(), pieces);
	}
	
	@Test
	public void testPlacePieceAtBeginning(){
		//testing just the beginning
		Board b = new Board(new Piece[10][10]);
		boolean result = true;
		for (int i = 0; i < this.args.length; i+=4) {
			result = result && b.isValidToPlacePiece((int)args[i],(int)args[i+1],(int)args[i+3]);
			if (result) {
				b.placePiece((int)args[i], (int)args[i+1], new Piece((int)args[i+2], (int)args[i+3]));
			}
		}
		assertEquals(expected, result);
	}

	// bva - test whether piece exists, and whether it doesnt
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
	public void getNonExistingPiece() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);

		try {
			b.getPiece(2, 2);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPiece);
		}
	}

	@Test
	public void testPieceCount() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);

		assertEquals(b.pieceCount(), 0);

		Piece fakePiece = EasyMock.niceMock(Piece.class);

		EasyMock.replay(fakePiece);
		b.placePiece(0, 0, fakePiece);

		assertEquals(b.pieceCount(), 1);
		EasyMock.verify(fakePiece);
	}

	// bva: boolean value
	// need to test return true, false, and error
	@Test
	public void testIsOccupiedFalse() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);

		assertEquals(b.isOccupied(0, 0), false);
	}

	@Test
	public void testIsOccupiedTrue() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);

		Piece p = new Piece(10, 1);
		b.placePiece(0, 0, p);

		assertEquals(b.isOccupied(0, 0), true);
	}

	@Test
	public void testIsOccupiedError() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);

		try {
			b.isOccupied(4, 4);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidLocation);
		}

		try {
			b.isOccupied(-1, -1);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidLocation);
		}
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

		EasyMock.replay(fakePiece, fakePiece2);
		assertEquals(b.getPieces()[0][0].getValue(), fakePiece.getValue());
		assertEquals(b.getPieces()[0][1].getValue(), fakePiece2.getValue());
		EasyMock.verify(fakePiece, fakePiece2);
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
		Piece fakePiece = EasyMock.niceMock(Piece.class);

		EasyMock.replay(fakePiece);
		b.placePiece(0, 0, fakePiece);
		b.removePiece(0, 0);

		assertEquals(b.getPieces()[0][0], null);
		EasyMock.verify(fakePiece);
	}

	@Test
	public void testRemove2() {
		Piece[][] pieces = new Piece[3][3];
		Board b = new Board(pieces);
		Piece fakePiece = EasyMock.niceMock(Piece.class);

		EasyMock.replay(fakePiece);
		b.placePiece(1, 0, fakePiece);
		b.removePiece(1, 0);

		assertEquals(b.getPieces()[1][0], null);
		EasyMock.verify(fakePiece);
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

		Piece fakePiece = EasyMock.niceMock(Piece.class);

		EasyMock.replay(fakePiece);
		b.placePiece(0, 0, fakePiece);

		assertEquals(b.isOccupied(0, 0), true);
		EasyMock.verify(fakePiece);
	}

}
