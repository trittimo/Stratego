<<<<<<< HEAD
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
	
	private final int BOARD_WIDTH = 600;
	private final int BOARD_HEIGHT = 600;
	private static final Point locatePt = new Point(0,0);
	LoadImage image;
	
	/**
	 * Constructor
	 * @param g
	 */
	public BoardScreen(Graphics g){
		g.setColor(Color.red);
		g.fillRect(locatePt.x,locatePt.y, BOARD_WIDTH, BOARD_HEIGHT);
		image=new LoadImage();
		image.draw(g, "map", 0, 0, BOARD_WIDTH, BOARD_HEIGHT);
		
	}
	
}
=======
package stratego.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * This class displays the board. I'm setting the game board canvas to be a
 * 500*500 square. It's a 10*10 board, therefore each little squares is 50*50
 * pixels big.
 * 
 * @author wuy5
 *
 */
public class BoardScreen {

	private final int BOARD_WIDTH = 600;
	private final int BOARD_HEIGHT = 600;
	private static final Point locatePt = new Point(0, 0);
	LoadImage image;

	public BoardScreen(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(locatePt.x, locatePt.y, BOARD_WIDTH, BOARD_HEIGHT);
		image = new LoadImage();
		image.draw(g, "map", 0, 0, BOARD_WIDTH, BOARD_HEIGHT);

	}

}
>>>>>>> origin/master
