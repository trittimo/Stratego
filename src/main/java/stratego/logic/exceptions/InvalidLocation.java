package stratego.logic.exceptions;



public class InvalidLocation extends RuntimeException{
	public InvalidLocation (int x, int y){
		super("Board isn't large enough to access space (" + x + ", " + y +")." );
	}
}
