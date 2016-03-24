/**
 * 
 */
package stratego.logic.exceptions;

import stratego.logic.Piece;

/**
 * Thrown when an invalid piece value is passed to the constructor {@link Piece}
 */
public class InvalidPieceValue extends RuntimeException {
	public InvalidPieceValue(int value) {
		super("'" + value + "' is an invalid piece value: Pieces values must fall within the range [1-12]");
	}
}
