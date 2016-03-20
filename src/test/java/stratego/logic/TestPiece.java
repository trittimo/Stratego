package stratego.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPiece {
	
	@Test 
	public void testPieceConstrutor(){
		Piece newPiece = new Piece (1, true);
		assertEquals(newPiece.getValue(), 1);
	}

}
