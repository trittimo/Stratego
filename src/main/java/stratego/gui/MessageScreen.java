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
	private static final int MSG_PANEL_HEIGHT = 300;
	private static final int URX = 0;//upper right x-coor
	private static final int URY = 500;//upper right y-coor
	
	
	public MessageScreen(Graphics g){
		g.setColor(Color.darkGray);
		g.fillRect(URX,URY,MSG_PANEL_WIDTH,MSG_PANEL_HEIGHT);
	}
	
	
}
