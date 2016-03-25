package stratego.gui;

import java.awt.Graphics;

public class GameComponent {
	LoadImage piece;
	final String PATH = "/CodeCoverageExample/images";
	int tile;
	String sign;
	
	public GameComponent(int tile, String sign){
		this.piece = new LoadImage();
		this.tile = tile;
		this.sign = sign;
	}
	
	public void draw(Graphics g) {
		piece.draw(g, this.pickPiece(sign), 10+60*tile/10, 60*(tile%10), 60, 60);
	}
	
	public int getTile(){
		return this.tile;
	}
	
	public void setTile(int tile){
		this.tile = tile;
	}
	
	public String pickPiece(String sign){
//		sign = "0";
		switch(sign){
		case "1":
			return "spy";
		case "2":
			return PATH+"/scout";
		case "3":
			return PATH+"/minor";
		case "4":
			return PATH+"/sergent";
		case "5":
			return PATH+"/lieutenant";
		case "6":
			return PATH+"/captain";
		case "7":
			return PATH+"/major";
		case "8":
			return PATH+"/colonel";
		case "9":
			return PATH+"/general";
		case "0":
			return PATH+"/marshall";
		case "B":
			return PATH+"/bomb";
		case "F":
			return PATH+"/flag";
		}
		return sign;
	}
}
