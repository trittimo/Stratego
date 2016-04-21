package stratego.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import stratego.Constants;

public class GUIMessageDisplay extends JPanel {
	public GUIMessageDisplay() {
		this.setPreferredSize(new Dimension(Constants.Dimensions.MESSAGES_WIDTH, Constants.Dimensions.MESSAGES_HEIGHT));
		this.setBackground(Color.DARK_GRAY);
	}

}
