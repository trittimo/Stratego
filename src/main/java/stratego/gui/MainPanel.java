package stratego.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel {
	
	JFrame frame;
	JPanel panel;
	
	public MainPanel(JFrame f) {
		this.frame = f;
		panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel = new JPanel();
		panel.add(panel2, BorderLayout.SOUTH);
		panel.setBackground(Color.blue);
		panel2.setBackground(Color.BLACK);
		frame.add(panel);
	}
	
	public JPanel Get(){
		return this.panel;
	}
	

}
