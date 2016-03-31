package stratego.gui;

import java.awt.Graphics;

import stratego.Constants;

public class GameComponent {
	private LoadImage piece;
	private static final String IMAGES_PATH = "/CodeCoverageExample/images";
	private int tile;
	private String name;

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
		ImageData data = new ImageData(this.pickPiece(name), 5 + 60 * (tile / 10), 60 * (tile % 10),
				60, 60);
		piece.draw(g, data);
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
		if (sign.equals("F") || sign.equals("B")) {
			return sign.equals("F") ? "flag" : "bomb";
		}
		try {
			return Constants.PIECES[Integer.parseInt(sign)];
		} catch (Exception e) {
			return sign;
		}
	}
}
