/**
 * 
 */
package stratego.logic.exceptions;

/**
 * Thrown when an invalid action is taken on the board
 */
public class InvalidAction extends RuntimeException {
	public InvalidAction(String message) {
		super(message);
	}
}
