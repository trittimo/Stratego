package stratego.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

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
	private int spyCounter = 0, scoutCounter = 0, minerCounter = 0, sergentCounter = 0,
			lieutCounter = 0, capCounter = 0, majorCounter = 0, coloCounter = 0, genCounter = 0,
			marshCounter = 0, bombCounter = 0, flagCounter = 0;

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
		for (int i = 0; i < 40; i++) {
			if (i < 1) {
				pieceList.add(new GameComponent(100, "spy"));
				spyCounter += 1;
			} else if (i < 9) {
				pieceList.add(new GameComponent(100 + i, "scout"));
				scoutCounter += 1;
			} else if (i < 15) {
				pieceList.add(new GameComponent(100 + i, "miner"));
				minerCounter += 1;
			} else if (i < 19) {
				pieceList.add(new GameComponent(100 + i, "sergent"));
				sergentCounter += 1;
			} else if (i < 23) {
				pieceList.add(new GameComponent(100 + i, "lieutenant"));
				lieutCounter += 1;
			} else if (i < 27) {
				pieceList.add(new GameComponent(100 + i, "captain"));
				capCounter += 1;
			} else if (i < 30) {
				pieceList.add(new GameComponent(100 + i, "major"));
				majorCounter += 1;
			} else if (i < 32) {
				pieceList.add(new GameComponent(100 + i, "colonel"));
				coloCounter += 1;
			} else if (i < 33) {
				pieceList.add(new GameComponent(100 + i, "general"));
				genCounter += 1;
			} else if (i < 34) {
				pieceList.add(new GameComponent(100 + i, "marshall"));
				marshCounter += 1;
			} else if (i < 35) {
				pieceList.add(new GameComponent(100 + i, "flag"));
				flagCounter += 1;
			} else if (i < 40) {
				pieceList.add(new GameComponent(100 + i, "bomb"));
				bombCounter += 1;
			}

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
		g.drawString("X" + spyCounter, 600, 100);
		return pieceList;
	}

}
