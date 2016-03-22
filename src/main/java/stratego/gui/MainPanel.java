package stratego.gui;

import javax.swing.JPanel;

public class MainPanel {
	  JPanel mainPanel = new JPanel();
	  mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

	  JPanel paintPanel = new JPanel();
	  JPanel textPanel = new JPanel();

	  mainPanel.add(paintPanel);
	  mainPanel.add(textPanel);
}
