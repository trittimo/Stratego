package stratego.gui;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;

public class PieceDisplayingBoard {
	JPanel pieceP;
	private static final int PIECE_BOARD_WIDTH = 800;
	private static final int PIECE_BOARD_HEIGHT = 300;
	private static final Point locatePt = new Point(0,0);
	
	
	public PieceDisplayingBoard() {
		this.pieceP = new JPanel();
		pieceP.setSize(PIECE_BOARD_WIDTH,PIECE_BOARD_HEIGHT);
		pieceP.setLocation(locatePt);
		pieceP.setVisible(true);
		pieceP.setBackground(Color.green);
	}
	
	public JPanel get() {
		return pieceP;
	}	
}
