package stratego.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


/**
 * This class displays the board. I'm setting the game board canvas to be a 500*500 square.
 * It's a 10*10 board, therefore each little squares is 50*50 pixels big.
 * 
 * @author wuy5
 *
 */
public class BoardScreen{
	
	private final int BOARD_WIDTH = 500;
	private final int BOARD_HEIGHT = 500;
	private static final Point locatePt = new Point(300,0);
	LoadImage image;
	
	public BoardScreen(Graphics g){
		g.setColor(Color.red);
		g.fillRect(300, 0, BOARD_WIDTH, BOARD_HEIGHT);
		image=new LoadImage();
		image.draw(g, "map", 285, 0, BOARD_WIDTH, BOARD_HEIGHT);
		
	}
	
}
