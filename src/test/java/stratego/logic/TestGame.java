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
		
		
	}
	
	
	

}
