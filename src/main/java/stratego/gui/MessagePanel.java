package stratego.gui;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;

public class MessagePanel {
	JPanel msgP;
	private static final int MSG_PANEL_WIDTH = 800;
	private static final int MSG_PANEL_HEIGHT = 300;
	private static final Point locatePt = new Point(0,500);
	
	
	public MessagePanel(){
		this.msgP = new JPanel();
		msgP.setSize(MSG_PANEL_WIDTH, MSG_PANEL_HEIGHT);
		msgP.setLocation(locatePt);
		msgP.setVisible(true);
		msgP.setBackground(Color.blue);
	}
	
	public JPanel get() {
		return msgP;
	}
	
}
