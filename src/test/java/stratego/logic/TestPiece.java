package stratego.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import stratego.logic.exceptions.InvalidPieceValue;
import stratego.logic.exceptions.InvalidPlayer;

@SuppressWarnings("unused")
public class TestPiece {

	@Test
	public void testPieceConstrutor() {
		Piece newPiece = new Piece(1, 1);
		assertEquals(newPiece.getValue(), 1);
	}

	
	//bva: can only have 2 players 
	//need to test 1, 2, -1, and 3 
	
	@Test
	public void testGetPlayerLower() {
		Piece newPiece = new Piece(1, 1);
		assertEquals(newPiece.getPlayer(), 1);
	}
	
	@Test 
	public void testGetPlayerUpper(){
		Piece newPiece = new Piece(1, 2);
		assertEquals(newPiece.getPlayer(), 2);
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
	//pieces are in a range [1-11]
	//need to test 0, 1, 11, 12
	@Test
	public void testGetPieceNameLower() {
		Piece newPiece = new Piece(1, 1);
		assertEquals(newPiece.getPieceName(), "Marshal");
	}

	@Test
	public void testGetPieceNameUpper() {
		Piece newPiece = new Piece(12, 1);
		assertEquals(newPiece.getPieceName(), "Flag");

	}
	@Test
	public void testInvalidPieceValueLower() {
		try {
			Piece newPiece = new Piece(-0, 1);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPieceValue);
		}
	}
	
	@Test
	public void testInvalidPieceValueUpper(){
		try{
			Piece newPiece = new Piece(12, 1);
		} catch (Exception e){
			assertTrue (e instanceof InvalidPieceValue);
		}
		
		
	}

	//bva: rank is in a range [1-11]
	//would need to test 0, 1, 11, 12
	//but you can't create pieces of value 0 or 12
	//already been tested in testInvalidPieceValue 
	//no need to duplicate code 
	
	@Test
	public void testGetPieceRankLower() {
		Piece newPiece = new Piece(1, 1);
		assertEquals(newPiece.getRank(), 10);
	}
	
	@Test
	public void testGetPieceRankUpper() {
		Piece newPiece = new Piece(11, 1); 
		assertEquals (newPiece.getRank(), 0);
	}

	
	


}
