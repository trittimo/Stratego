package stratego.logic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import stratego.logic.exceptions.InvalidPieceValue;
import stratego.logic.exceptions.InvalidPlayer;

@SuppressWarnings("unused")
@RunWith(Parameterized.class)
public class TestPiece {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{3, 11, 3}, // Miner defuses bomb
			{10, 1, 10}, // Spy beats Marshal if spy attacks
			{1, 10, 1}, // Marshal beats spy if marshal attacks
			{1, 11, 11}, // Marshal loses to bomb
			{1, 5, 1}, // Marshal beats captain
			{5, 5, -1}, // Nobody wins if ranks are equal
			{5, 1, 1} // Captain loses to marshal
		});
	}
	
	
	private int pieceAValue;
	private int pieceBValue;
	private int expectedWinner;
	public TestPiece(int pieceAValue, int pieceBValue, int expected) {
		this.pieceAValue = pieceAValue;
		this.pieceBValue = pieceBValue;
		this.expectedWinner = expected;
	}
	

	
	@Test
	public void testGetWinner() {
		assertEquals(expectedWinner, Piece.getWinner(pieceAValue, pieceBValue));
	}
	
	@Test
	public void testPieceConstrutor() {
		Piece newPiece = new Piece(1, 1);
		assertEquals(1, newPiece.getValue());
	}

	// bva: can only have 2 players
	// need to test 1, 2, -1, and 3
	@Test
	public void testGetPlayerLower() {
		Piece newPiece = new Piece(1, 1);
		assertEquals(1, newPiece.getPlayer());
	}

	@Test
	public void testGetPlayerUpper() {
		Piece newPiece = new Piece(1, 2);
		assertEquals(2, newPiece.getPlayer());

	}

	@Test
	public void testInvalidPlayerLower() {
		try {
			Piece newPiece = new Piece(1, -1);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPlayer);
		}
	}

	@Test
	public void testInvalidPlayerUpper() {
		try {
			Piece newPiece = new Piece(1, 3);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPlayer);
		}
	}

	// boundary value analysis:
	// pieces are in a range [1, 12]
	// need to test 1, 12, 0, 13
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
	public void testInvalidPieceValueUpper() {
		try {
			Piece newPiece = new Piece(13, 1);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidPieceValue);
		}
	}

	// bva: rank is in a range [-1, 10]
	// would need to test pieces of value 0, 1, 11, 12
	// but you can't create pieces of value 0 or 12
	// already been tested in testInvalidPieceValue
	// no need to duplicate code

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

	@Test
	public void testInvalidAttacker() {
		try {
			Piece.getWinner(0, 5);
			fail("Should throw InvalidPieceValue Exception");
		}catch(Exception e){
			assertThat(e, IsInstanceOf.instanceOf(InvalidPieceValue.class));
			assertEquals(e.getMessage(), "'0' is an invalid piece value: Pieces values must fall within the range [1-12]");
		}
	}
	
	@Test
	public void testInvalidAttacker2() {
		try {
			Piece.getWinner(13, 5);
			fail("Should throw InvalidPieceValue Exception");
		}catch(Exception e){
			assertThat(e, IsInstanceOf.instanceOf(InvalidPieceValue.class));
			assertEquals(e.getMessage(), "'13' is an invalid piece value: Pieces values must fall within the range [1-12]");
		}
	}
}
