package stratego.logic;


public class Piece {
	
	private String[] PieceNames = {"Marshal", "General",
			"Colonel", "Major", "Captain", "Lieutenant", 
			"Sergeant", "Miner", "Scout", "Spy", "Bomb", "Flag"};
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
		return PieceNames[this.getValue()-1];
	}
	

}
