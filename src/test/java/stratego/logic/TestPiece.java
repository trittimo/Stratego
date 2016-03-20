package stratego.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPiece {
	
	@Test 
	public void testPieceConstrutor(){
		Piece newPiece = new Piece (1, true);
		assertEquals(newPiece.getValue(), 1);
	}
	 
	@Test
	public void testGetPlayer(){
		Piece newPiece = new Piece (1, true);
		assertEquals(newPiece.getPlayer(), true);
	}
	
	@Test
	public void testGetPieceName(){
		Piece newPiece = new Piece (1, true);
		assertEquals(newPiece.getPieceName(), "Marshal");
		
		
	}

}
