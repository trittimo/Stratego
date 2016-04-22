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
    
    public TestIntegration(Piece p1_1, Piece p1_2, Piece p2_1, Piece p2_2){
    	this.piece1_1 = p1_1;
    	this.piece1_2 = p1_2;
    	this.piece2_1 = p2_1;
    	this.piece2_2 = p2_2;
    }

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }  //need to change this
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
		
		g.makeMove(0, 0, 1, 0);
		g.makeMove(2, 0, 1, 0);
		
	}

}
