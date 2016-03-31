package stratego.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import stratego.Constants;

/**
 * This class would start with all the pieces, so player can put them on board
 * wherever they desire the piece to be. This part displays how many pieces and
 * what pieces you have left to use.
 * 
 * @author wuy5
 *
 */
public class PieceDisplayingScreen {
	private static final int PIECE_BOARD_WIDTH = 300;
	private static final int PIECE_BOARD_HEIGHT = 600;
	private static final Point locatePt = new Point(600, 0);
	private ArrayList<GameComponent> pieceList;
	private int[] counters = new int[12];

	/**
	 * Displays the pieces on the graphics
	 */
	public PieceDisplayingScreen() {
		this.pieceList = new ArrayList<GameComponent>();
		this.putPiece();
	}

	/**
	 * Initialize the game with certain number of pieces displayed
	 */
	public void putPiece() {
		int offset = 0;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < Constants.PIECE_COUNTS[i]; j++) {
				pieceList.add(new GameComponent(100 + offset, Constants.PIECES[i]));
				offset++;
			}
			counters[i] = Constants.PIECE_COUNTS[i];
		}

	}

	/**
	 * Draw pieces on graphics
	 * 
	 * @param g
	 */
	public ArrayList<GameComponent> drawOn(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(locatePt.x, locatePt.y, PIECE_BOARD_WIDTH, PIECE_BOARD_HEIGHT);
		for (int i = 0; i < this.pieceList.size(); i++) {
			this.pieceList.get(i).draw(g);

		}
		g.setFont(new Font("Times New Roman", Font.BOLD, 30));
		g.setColor(Color.white);
		g.drawString("X" + counters[0], 600, 100);
		return pieceList;
	}

}
