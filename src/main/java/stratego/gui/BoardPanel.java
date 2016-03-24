package stratego.gui;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * This class displays the board. I'm setting the game board canvas to be a 500*500 square.
 * It's a 10*10 board, therefore each little squares is 50*50 pixels big.
 * 
 * @author wuy5
 *
 */
public class BoardPanel{
	
	JPanel boardP;
	private final int BOARD_WIDTH = 500;
	private final int BOARD_HEIGHT = 500;
	private static final Point locatePt = new Point(300,0);

	
	public BoardPanel(){
		this.boardP = new JPanel();
		boardP.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		boardP.setLocation(locatePt);
		boardP.setVisible(true);
		boardP.setBackground(Color.red);
		
	}
	
	public JPanel get() {
		return boardP;
	}
	
}
