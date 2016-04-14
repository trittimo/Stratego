package stratego.gui;

import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StrategoPanel extends JPanel {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;

	public StrategoPanel() {
		this.setLocation(0, 0);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	public void refresh() {
		this.revalidate();
		this.repaint();
	}
}
