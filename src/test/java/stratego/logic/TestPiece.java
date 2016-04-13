package stratego.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import stratego.logic.exceptions.InvalidPieceValue;
import stratego.logic.exceptions.InvalidPlayer;

@SuppressWarnings("unused")
public class TestPiece {
//NOTE: assertEquals(expected, actual) 
	
	@Test
	public void testPieceConstrutor() {
		Piece newPiece = new Piece(1, 1);
		assertEquals(1, newPiece.getValue());
	}

	
	//bva: can only have 2 players 
	//need to test 1, 2, -1, and 3 
	@Test
	public void testGetPlayerLower() {
		Piece newPiece = new Piece(1, 1);
		assertEquals(1, newPiece.getPlayer());
	}
	
	@Test 
	public void testGetPlayerUpper(){
		Piece newPiece = new Piece(1, 2);
		assertEquals(2, newPiece.getPlayer());
		
	}
	
	@Test 
	public void testInvalidPlayerLower(){
		try {
			Piece newPiece = new Piece(1, -1);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPlayer);
		}
	}
	
	@Test
	public void testInvalidPlayerUpper(){
		try{
			Piece newPiece = new Piece(1, 3);
		} catch (Exception e){
			assertTrue (e instanceof InvalidPlayer);
		}
	}
	
	//boundary value analysis:
	//pieces are in a range [1, 12]
	//need to test 1, 12, 0, 13
	@Test
	public void testGetPieceNameLower() {
		Piece newPiece = new Piece(1, 1);
		assertEquals("Marshal", newPiece.getPieceName());
	}

	@Test
	public void testGetPieceNameUpper() {
		Piece newPiece = new Piece(12, 1);
		assertEquals("Flag", newPiece.getPieceName());

	}
	@Test
	public void testInvalidPieceValueLower() {
		try {
			Piece newPiece = new Piece(0, 1);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPieceValue);
		}
	}
	
	@Test
	public void testInvalidPieceValueUpper(){
		try{
			Piece newPiece = new Piece(13, 1);
		} catch (Exception e){
			assertTrue (e instanceof InvalidPieceValue);
		}	
	}

	//bva: rank is in a range [-1, 10]
	//would need to test pieces of value 0, 1, 11, 12
	//but you can't create pieces of value 0 or 12
	//already been tested in testInvalidPieceValue 
	//no need to duplicate code 
	
	@Test
	public void testGetPieceRankLower() {
		Piece newPiece = new Piece(1, 1);
		assertEquals(10, newPiece.getRank());
	}
	
	@Test
	public void testGetPieceRankUpper() {
		Piece newPiece = new Piece(12, 1); 
		assertEquals(-1, newPiece.getRank());
	}

}
