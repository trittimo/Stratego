package stratego.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * This part displays how many pieces and what pieces you have left to use.
 * 
 * @author wuy5
 *
 */
public class PieceDisplayingScreen {
	private static final int PIECE_BOARD_WIDTH = 200;
	private static final int PIECE_BOARD_HEIGHT = 600;
	private static final Point locatePt = new Point(600, 0);

	public PieceDisplayingScreen(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(locatePt.x, locatePt.y, PIECE_BOARD_WIDTH, PIECE_BOARD_HEIGHT);
	}

}
