<<<<<<< HEAD
package stratego.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


/**
 * This is the message displaying part on the main game screen.
 * 
 * @author wuy5
 *
 */
public class MessageScreen {
	private static final int MSG_PANEL_WIDTH = 900;
	private static final int MSG_PANEL_HEIGHT = 300;
	private static final Point locatePt = new Point(0,600);
	
	/**
	 * Constructor
	 * @param g
	 */
	public MessageScreen(Graphics g){
		g.setColor(Color.darkGray);
		g.fillRect(locatePt.x,locatePt.y,MSG_PANEL_WIDTH,MSG_PANEL_HEIGHT);
	}
	
	
}
=======
package stratego.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * This is the message displaying part on the main game screen.
 * 
 * @author wuy5
 *
 */
public class MessageScreen {
	private static final int MSG_PANEL_WIDTH = 800;
	private static final int MSG_PANEL_HEIGHT = 200;
	private static final Point locatePt = new Point(0, 600);

	public MessageScreen(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(locatePt.x, locatePt.y, MSG_PANEL_WIDTH, MSG_PANEL_HEIGHT);
	}

}
>>>>>>> origin/master
