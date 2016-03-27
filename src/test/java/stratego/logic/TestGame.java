package stratego.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGame {

	@Test
	public void testBoardEmpty() {
		
		Piece[][] p1 = new Piece[10][10];
		Board b1 = new Board(p1);
		Game g = new Game(b1);
		
		Piece[][] p = new Piece[10][10];
		Board b2 = new Board(p);
		
		assertEquals(b1.pieceCount(), b2.pieceCount());
	}
	
	@Test
	public void addPieceToBoardTest() {
		
		Piece[][] p1 = new Piece[10][10];
		Board b1 = new Board(p1);
		Game g = new Game(b1);
		
		Piece[][] p = new Piece[10][10];
		Board b2 = new Board(p);
		
		assertEquals(b1.pieceCount(), b2.pieceCount());
		
		Piece p2 = new Piece (1, 1);
		b1.placePiece(3, 0, p2);
		
		b2.placePiece(3, 0, p2);
		
		assertEquals(g.getBoard().pieceCount(), b2.pieceCount());
	}
	
	@Test
	public void whoseTurnTest(){
		Piece[][] p1 = new Piece[10][10];
		Board b1 = new Board(p1);
		Game g = new Game(b1);
		
		assertEquals(g.whoseTurn(), 1);
		
	}
	
	@Test
	public void switchTurnsTest(){
		Piece[][] p1 = new Piece[10][10];
		Board b1 = new Board(p1);
		Game g = new Game(b1);
		
		assertEquals(g.whoseTurn(), 1);
		
		g.switchTurns();
		
		assertEquals(g.whoseTurn(), 2);	
	}
	
	@Test
	public void switchTurnsMultipleTimesTest(){
		Piece[][] p1 = new Piece[10][10];
		Board b1 = new Board(p1);
		Game g = new Game(b1);
		
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
	public void makeMoveTest(){
		Piece[][] p = new Piece[10][10];
		Board b1 = new Board(p);
		Game g = new Game(b1);
		
		Piece p1 = new Piece(5, 1);
		g.getBoard().placePiece(0, 0, p1);
		
		g.makeMove(0, 0, 0, 1);
		
		Piece p2 = g.getBoard().getPieces()[0][1];
		assertEquals(p1.getPlayer(), p2.getPlayer());
		assertEquals(p1.getValue(), p2.getValue());
	}
	
	@Test
	public void makeMoveAttackTest(){
		Piece[][] p = new Piece[10][10];
		Board b1 = new Board(p);
		Game g = new Game(b1);
		
		Piece p1 = new Piece(5, 1);
		g.getBoard().placePiece(0, 0, p1);
		
		Piece p2 = new Piece (4, 2);
		g.getBoard().placePiece (0, 1, p2);
		
		g.makeMove(0, 0, 0, 1);
		
		Piece p3 = g.getBoard().getPieces()[0][1];
		assertEquals(p1.getPlayer(), p3.getPlayer());
		assertEquals(p1.getValue(), p3.getValue());
	}
	

	
	

}
