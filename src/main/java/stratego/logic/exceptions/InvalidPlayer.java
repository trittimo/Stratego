/**
 * 
 */
package stratego.logic.exceptions;

/**
 * Thrown when there is an attempt to use an invalid player
 */
@SuppressWarnings("serial")
public class InvalidPlayer extends RuntimeException {
	public InvalidPlayer(int player) {
		super("'" + player + "' is an invalid player: players must fall within the range [1,2]");
	}
}
