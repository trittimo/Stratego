package stratego.logic;

public class Piece {
	
	private int value;
	private int player;
	
	public Piece(int value, int player){
		this.value = value;
		this.player = player;
	}
	
	public int getValue(){
		return 1;
	}
	
	public int getPlayer(){
		return 1;
	}
	
	public String getPieceName(){
		return "Marshal";
	}

}
