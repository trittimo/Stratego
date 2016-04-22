package stratego.logic.exceptions;

public class InvalidAttacker extends InvalidAction {
	
	public InvalidAttacker(int value){
		super("Cannot attack with piece with value of " + value + "! (either bomb or flag)");
	}
}
