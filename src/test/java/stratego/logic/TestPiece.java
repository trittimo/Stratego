package stratego.logic;

import org.junit.Test;

public class TestPiece {
	
	@Test 
	public void testPieceConstrutor(){
		Piece newPiece = new Piece (1, true);
		assertEquals(newPiece.getValue(), 1);
	}

}
