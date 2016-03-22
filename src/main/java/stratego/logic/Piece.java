package stratego.logic;

public class Piece {
	
	private int value;
	private int player;
	
	public Piece(int value, int player){
		this.value = value;
		this.player = player;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public int getPlayer(){
		return this.player;
	}
	
	public String getPieceName(){
		return "Marshal";
	}

}
