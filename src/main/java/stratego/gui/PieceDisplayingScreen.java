package stratego.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


/**
 * This part displays how many pieces and what pieces you have left to use.
 * @author wuy5
 *
 */
public class PieceDisplayingScreen {
	private static final int PIECE_BOARD_WIDTH = 300;
	private static final int PIECE_BOARD_HEIGHT = 500;
	private static final Point locatePt = new Point(0,0);
	
	
	public PieceDisplayingScreen(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0,0,PIECE_BOARD_WIDTH,PIECE_BOARD_HEIGHT);
	}
	
}
