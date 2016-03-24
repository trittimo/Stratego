/**
 * 
 */
package stratego.logic;

import org.junit.Test;

/**
 * An integration test which tests the logic of the program
 */
public class TestLogic {

	@Test
	/* @formatter:off */
	public void testGame1() {
		int[][] initPositions = { 
				{ 11, 11, 1, 2, 3, 11 }, 
				{ 11, 11, 4, 5, 6, 11 },
				{ 11, 11, 7, 8, 9, 11 }, 
				{ 3, 3, 3, 4, 5, 6 }, 
				{ 11, 3, 5, 1, 2, 3 },
				{ 9, 10, 3, 2, 1, 3 }};

		Board board = fillBoard(initPositions);

	}

	public Board fillBoard(int[][] fill) {
		Piece[][] pieces = new Piece[fill.length][fill[0].length];
		for (int i = 0; i < fill.length; i++) {
			for (int j = 0; j < fill[0].length; j++) {
				if (i < fill.length / 2) {
					pieces[j][i] = new Piece(fill[i][j], 1);
				} else {
					pieces[j][i] = new Piece(fill[i][j], 2);
				}
			}
		}
		return new Board(pieces);
	}
}
