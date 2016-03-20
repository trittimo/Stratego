package stratego.logic;

public class Piece {
	
	private int value;
	private boolean player1;
	
	public Piece(int value, boolean player1){
		this.value = value;
		this.player1 = player1;
	}
	
	public int getValue(){
		return 1;
	}
	
	public boolean getPlayer(){
		return true; 
	}

}
