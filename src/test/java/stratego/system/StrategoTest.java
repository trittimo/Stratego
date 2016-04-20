package stratego.system;

import static org.junit.Assert.*;

import org.junit.Test;

import stratego.logic.Game;

public class StrategoTest {
	@Test
	public void testInvalidGameSetupNullBoard() {
		boolean threwException = false;
		try {
			Game game = new Game(null);
		} catch (Exception e) {
			threwException = true;
		}
		
		assertTrue(threwException);
	}
	
}
