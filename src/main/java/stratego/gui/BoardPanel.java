package stratego.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class displays the board. I'm setting the game board canvas to be a 500*500 square.
 * It's a 10*10 board, therefore each little squares is 50*50 pixels big.
 * 
 * @author wuy5
 *
 */
public class BoardPanel extends Canvas implements MouseListener{
	
	private final int BOARD_WIDTH = 500;
	private final int BOARD_HEIGHT = 500;
	
	Label message; //Displaying message to user
	
	int playingPlayer,  //Whose turn to play
		currentRow, currentCol; //The current piece's location
	
	//remember to cut the islands total of 8 squares
	//
	public BoardPanel() {
		setBackground(Color.black);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
