/**
 * 
 */
package stratego.logic.exceptions;

/**
 * Thrown when an attempt to move a piece to an invalid location is made
 */
public class InvalidMovement extends InvalidAction {
	public InvalidMovement(String pieceName, int x1, int y1, int x2, int y2) {
		super("Cannot move " + pieceName + " from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
	}
	
	public InvalidMovement(String pieceName, int x1, int y1, int x2, int y2, String reason) {
		super("Cannot move " + pieceName + " from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + "): " + reason);
	}
}
