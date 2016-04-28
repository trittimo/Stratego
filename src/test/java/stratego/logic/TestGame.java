package stratego.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Test;

import stratego.logic.exceptions.InvalidMovement;
import stratego.logic.exceptions.InvalidPiece;

public class TestGame {
		

	@Test
	public void testGetGameBegin(){
		Piece[][] p = new Piece[10][10];

		Board fakeBoard = EasyMock.niceMock(Board.class);

		Game g = new Game(fakeBoard);
		
		EasyMock.replay();
		
		assertTrue(g.isBeginning());
		
	}

	@Test
	public void testInvalidMoveWithNullPiece() {
		Piece[][] p = new Piece[10][10];

		Board fakeBoard = EasyMock.niceMock(Board.class);

		Game g = new Game(fakeBoard);

		EasyMock.expect(fakeBoard.isOccupied(1, 1)).andReturn(false);
		fakeBoard.movePiece(0, 0, 1, 1);
		EasyMock.expectLastCall().andThrow(new InvalidMovement("fakePiece", 0, 0, 1, 1));

		EasyMock.replay(fakeBoard);

		boolean testPasses = false;
		try {
			g.makeMove(0, 0, 1, 1);
		} catch (Exception e) {
			testPasses = e instanceof InvalidPiece;
		}
		assertTrue(testPasses);

		EasyMock.verify(fakeBoard);
	}

	@Test
	public void testInvalidMoveOffBoard() {
		Piece[][] p = new Piece[10][10];
		Board fakeBoard = EasyMock.niceMock(Board.class);
		Game g = new Game(fakeBoard);

		// Piece fakePiece = EasyMock.niceMock(Piece.class);

		EasyMock.expect(fakeBoard.isOccupied(-1, -1)).andThrow(new IndexOutOfBoundsException());

		EasyMock.replay(fakeBoard);

		assertFalse(g.makeMove(0, 0, -1, -1));

		EasyMock.verify(fakeBoard);
	}

	@Test
	public void testBoardEmpty() {

		Board fakeBoard1 = EasyMock.niceMock(Board.class);
		Game g = new Game(fakeBoard1);

		Board fakeBoard2 = EasyMock.niceMock(Board.class);

		EasyMock.expect(fakeBoard1.pieceCount()).andReturn(0);
		EasyMock.expect(fakeBoard2.pieceCount()).andReturn(0);

		EasyMock.replay(fakeBoard1, fakeBoard2);

		assertEquals(g.getBoard().pieceCount(), fakeBoard2.pieceCount());

		EasyMock.verify(fakeBoard1, fakeBoard2);
	}

	@Test
	public void addPieceToBoardTest() {

		Piece[][] p1 = new Piece[10][10];

		Board fakeBoard1 = EasyMock.niceMock(Board.class);
		Game g = new Game(fakeBoard1);

		Piece[][] p = new Piece[10][10];

		Board fakeBoard2 = EasyMock.niceMock(Board.class);

		Piece fakePiece = EasyMock.niceMock(Piece.class);

		fakeBoard1.placePiece(3, 0, fakePiece);
		fakeBoard2.placePiece(3, 0, fakePiece);

		EasyMock.expect(fakeBoard1.pieceCount()).andReturn(1);
		EasyMock.expect(fakeBoard2.pieceCount()).andReturn(1);

		EasyMock.replay(fakeBoard1, fakeBoard2);

		fakeBoard1.placePiece(3, 0, fakePiece);
		fakeBoard2.placePiece(3, 0, fakePiece);

		assertEquals(g.getBoard().pieceCount(), fakeBoard2.pieceCount());

		EasyMock.verify(fakeBoard1, fakeBoard2);
	}

	@Test
	public void whoseTurnTest() {
		Piece[][] p1 = new Piece[10][10];

		Board fakeBoard = EasyMock.niceMock(Board.class);
		Game g = new Game(fakeBoard);

		EasyMock.replay(fakeBoard);

		assertEquals(g.whoseTurn(), 1);

		EasyMock.verify(fakeBoard);
	}

	@Test
	public void switchTurnsTest() {
		Piece[][] p1 = new Piece[10][10];
		Board fakeBoard = EasyMock.niceMock(Board.class);
		Game g = new Game(fakeBoard);

		EasyMock.replay(fakeBoard);

		assertEquals(g.whoseTurn(), 1);

		g.switchTurns();

		assertEquals(g.whoseTurn(), 2);

		EasyMock.verify(fakeBoard);
	}

	@Test
	public void switchTurnsMultipleTimesTest() {
		Piece[][] p1 = new Piece[10][10];
		Board fakeBoard = EasyMock.niceMock(Board.class);
		Game g = new Game(fakeBoard);

		assertEquals(g.whoseTurn(), 1);

		g.switchTurns();

		assertEquals(g.whoseTurn(), 2);

		g.switchTurns();
		assertEquals(g.whoseTurn(), 1);

		g.switchTurns();
		g.switchTurns();
		g.switchTurns();
		g.switchTurns();
		g.switchTurns();
		g.switchTurns();
		g.switchTurns();

		assertEquals(g.whoseTurn(), 2);

	}

	@Test
	public void makeMoveTest() {
		Piece[][] p = new Piece[10][10];
		Board fakeBoard = EasyMock.niceMock(Board.class);
		Game g = new Game(fakeBoard);

		Piece fakePiece1 = EasyMock.niceMock(Piece.class);
		Piece fakePiece2 = EasyMock.niceMock(Piece.class);

		fakeBoard.placePiece(0, 0, fakePiece1);
		EasyMock.expect(fakeBoard.isOccupied(0, 1)).andReturn(false);

		fakeBoard.movePiece(0, 0, 0, 1);

		EasyMock.expect(fakePiece1.getPlayer()).andReturn(1);
		EasyMock.expect(fakePiece2.getPlayer()).andReturn(1);
		EasyMock.expect(fakePiece1.getValue()).andReturn(2);
		EasyMock.expect(fakePiece2.getValue()).andReturn(2);

		EasyMock.replay(fakeBoard, fakePiece1, fakePiece2);

		g.getBoard().placePiece(0, 0, fakePiece1);
		g.makeMove(0, 0, 0, 1);

		assertEquals(fakePiece1.getPlayer(), fakePiece2.getPlayer());
		assertEquals(fakePiece1.getValue(), fakePiece2.getValue());

		EasyMock.verify(fakeBoard, fakePiece1, fakePiece2);
	}

	@Test
	public void makeMoveAttackWinTest() {
		Piece[][] p = new Piece[10][10];
		// Board b1 = new Board(p);
		Board fakeBoard = EasyMock.niceMock(Board.class);
		Game g = new Game(fakeBoard);

		// Piece p1 = new Piece(3, 1);
		// Piece p2 = new Piece(4, 2);
		Piece fakePiece1 = EasyMock.niceMock(Piece.class);
		Piece fakePiece2 = EasyMock.niceMock(Piece.class);
		Piece fakePiece3 = fakePiece1;

		fakeBoard.placePiece(0, 0, fakePiece1);
		fakeBoard.placePiece(0, 1, fakePiece2);

		EasyMock.expect(fakeBoard.isOccupied(0, 1)).andReturn(true);

		EasyMock.expect(fakeBoard.getPiece(0, 0)).andReturn(fakePiece1);
		EasyMock.expect(fakePiece1.getRank()).andReturn(8);
		EasyMock.expect(fakeBoard.getPiece(0, 1)).andReturn(fakePiece2);
		EasyMock.expect(fakePiece2.getRank()).andReturn(7);

		fakeBoard.removePiece(0, 1);
		fakeBoard.movePiece(0, 0, 0, 1);

		EasyMock.expect(fakePiece1.getPlayer()).andReturn(1);
		EasyMock.expect(fakePiece3.getPlayer()).andReturn(1);
		EasyMock.expect(fakePiece1.getValue()).andReturn(8);
		EasyMock.expect(fakePiece3.getValue()).andReturn(8);

		EasyMock.replay(fakeBoard, fakePiece1, fakePiece2);

		g.getBoard().placePiece(0, 0, fakePiece1);
		g.getBoard().placePiece(0, 1, fakePiece2);

		g.makeMove(0, 0, 0, 1);

		assertEquals(fakePiece1.getPlayer(), fakePiece3.getPlayer());
		assertEquals(fakePiece1.getValue(), fakePiece3.getValue());

		EasyMock.verify(fakeBoard, fakePiece1, fakePiece2);
	}

	@Test
	public void makeMoveAttackLoseTest() {
		Piece[][] p = new Piece[10][10];
		// Board b1 = new Board(p);
		Board fakeBoard = EasyMock.niceMock(Board.class);
		Game g = new Game(fakeBoard);

		// Piece p1 = new Piece(5, 1);
		// Piece p2 = new Piece(3, 2);
		Piece fakePiece1 = EasyMock.niceMock(Piece.class);
		Piece fakePiece2 = EasyMock.niceMock(Piece.class);
		Piece fakePiece3 = fakePiece2;

		fakeBoard.placePiece(0, 0, fakePiece1);
		fakeBoard.placePiece(0, 1, fakePiece2);

		// what is expected for g.makeMove(0, 0, 0, 1)
		EasyMock.expect(fakeBoard.isOccupied(0, 1)).andReturn(true);

		EasyMock.expect(fakeBoard.getPiece(0, 0)).andReturn(fakePiece1);
		EasyMock.expect(fakePiece1.getRank()).andReturn(6);
		EasyMock.expect(fakeBoard.getPiece(0, 1)).andReturn(fakePiece2);
		EasyMock.expect(fakePiece2.getRank()).andReturn(8);

		fakeBoard.removePiece(0, 0);

		// makeMove is finished, mock fakePiece2 and fakePiece3 getPlayer and
		// getValue
		EasyMock.expect(fakePiece2.getPlayer()).andReturn(2);
		EasyMock.expect(fakePiece3.getPlayer()).andReturn(2);
		EasyMock.expect(fakePiece2.getValue()).andReturn(8);
		EasyMock.expect(fakePiece3.getValue()).andReturn(8);

		EasyMock.replay(fakeBoard, fakePiece1, fakePiece2);

		g.getBoard().placePiece(0, 0, fakePiece1);
		g.getBoard().placePiece(0, 1, fakePiece2);

		g.makeMove(0, 0, 0, 1);

		assertEquals(fakePiece2.getPlayer(), fakePiece3.getPlayer());
		assertEquals(fakePiece2.getValue(), fakePiece3.getValue());

		EasyMock.verify(fakeBoard, fakePiece1, fakePiece2);
	}

}
