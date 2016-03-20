package stratego.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WelcomeScreen extends JPanel implements ActionListener{

	private JFrame frame;
	private GameComponent gComp;
	
	public WelcomeScreen(JFrame f) {
		this.frame = f;
		
//		MouseListener mouse = new Mouse
//		frame.addMouseListener(mouse);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(0, 0, 800, 500);
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman", Font.BOLD, 60));
		g.drawString("Welcome to Statego!", 120, 300);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

}
