/**
 * 
 */
package stratego.logic.exceptions;

/**
 *
 */
public class InvalidPiece extends RuntimeException {
	public InvalidPiece(int x, int y) {
		super("Piece at (" + x + ", " + y + ") appears to be an invalid piece");
	}
}
