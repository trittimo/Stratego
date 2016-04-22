package stratego.logic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestIntegration {
	
	private Piece piece1_1;
    private Piece piece1_2;
    private Piece piece2_1;
    private Piece piece2_2;
    private int winnerA;
    private int winnerB;
    
    public TestIntegration(Piece p1_1, Piece p1_2, Piece p2_1, Piece p2_2, int winA, int winB){
    	this.piece1_1 = p1_1;
    	this.piece1_2 = p1_2;
    	this.piece2_1 = p2_1;
    	this.piece2_2 = p2_2;
    	this.winnerA = winA;
    	this.winnerB = winB;
    }

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { new Piece(9, 1), new Piece(12, 1), new Piece(9, 2), new Piece(9, 2), -1, 9 },
                 { new Piece(8, 1), new Piece(11, 1), new Piece(11, 2), new Piece(6, 2), 8, 11 },
                 { new Piece(1, 1), new Piece(2, 1), new Piece(2, 2), new Piece(1, 2), 1, 1 },
                 { new Piece(10, 1), new Piece(10, 1), new Piece(1, 2), new Piece(1, 2), 10, 1 },
                 { new Piece(10, 1), new Piece(10, 1), new Piece(9, 2), new Piece(10, 2), 9, -1 },
           });
    }
    
    
    
    
	@Test
	public void test() {
		
		Piece [][] pieces = new Piece[3][3];
		Board board = new Board(pieces);
		Game g = new Game(board);
		
		Board game_board = g.getBoard();
		
		//place pieces in initial positions
		game_board.placePiece(0, 0, this.piece1_1);
		game_board.placePiece(0, 2, this.piece1_2);
		game_board.placePiece(2, 0, this.piece2_1);
		game_board.placePiece(2, 2, this.piece2_2);
		
		//starts with player 1
		assertEquals(g.whoseTurn(), 1);
		
		g.makeMove(0, 2, 1, 2); //defender
		
		g.switchTurns();
		assertEquals(g.whoseTurn(), 2);
		
		g.makeMove(2, 2, 1, 2); //attacker
		
		g.switchTurns();
		assertEquals(g.whoseTurn(), 1);
		
		assertEquals(this.winnerB, game_board.getPiece(1, 2).getValue());
		
		g.switchTurns(); //this is so the the correct pieces move on the right turns for this test
		assertEquals(g.whoseTurn(), 2);
		
		g.makeMove(2, 0, 1, 0); //defender

		g.switchTurns();
		assertEquals(g.whoseTurn(), 1);
		
		g.makeMove(0, 0, 1, 0); //attacker
		
		g.switchTurns();
		assertEquals(g.whoseTurn(), 2);
		
		assertEquals(this.winnerA, game_board.getPiece(1, 0).getValue());
	}

}
