/**
 * 
 */
package stratego.logic.exceptions;

import stratego.logic.Board;
import stratego.logic.Piece;

/**
 * Thrown when an attempt to place a piece in an invalid location is made
 */
public class InvalidPlacement extends RuntimeException {
	public InvalidPlacement(Piece piece, Board board, int x, int y, String reason) {
		super("Cannot place piece at position (" + x + ", " + y + "): " + reason);
	}
}
