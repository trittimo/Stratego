package stratego.gui;

import java.awt.Graphics;

public class GameComponent {
	LoadImage piece;
	final String PATH = "/CodeCoverageExample/images";
	int tile;
	String name;

	/**
	 * GameComponent Constructor
	 * 
	 * @param tile
	 * @param sign
	 */
	public GameComponent(int tile, String name) {
		this.piece = new LoadImage();
		this.tile = tile;
		this.name = name;
	}

	/**
	 * Draw the piece
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		piece.draw(g, this.pickPiece(name), 5 + 60 * (int) (tile / 10), 60 * (int)(tile % 10), 60, 60);
	}

	/**
	 * Get the tile
	 * 
	 * @return
	 */
	public int getTile() {
		return this.tile;
	}

	/**
	 * 
	 * @param tile
	 */
	public void setTile(int tile) {
		this.tile = tile;
	}

	/**
	 * 
	 * @param sign
	 * @return
	 */
	public String pickPiece(String sign) {
		switch (sign) {
		case "1":
			return "spy";
		case "2":
			return "scout";
		case "3":
			return "miner";
		case "4":
			return "sergent";
		case "5":
			return "lieutenant";
		case "6":
			return "captain";
		case "7":
			return "major";
		case "8":
			return "colonel";
		case "9":
			return "general";
		case "0":
			return "marshall";
		case "B":
			return "bomb";
		case "F":
			return "flag";
		}
		return sign;
	}
}
