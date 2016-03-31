<<<<<<< HEAD
package stratego.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ending extends JPanel{
	
	JFrame frame;
	
	public Ending(JFrame f) {
		this.frame = f;
	}
	
	/**
	 * Just a ending screen says "Game Over!" when ends the game
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Gallic", Font.BOLD, 60));
		g.drawString("Game Over!", 40, 50);
	}
}
=======
package stratego.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ending extends JPanel {

	JFrame frame;

	public Ending(JFrame f) {
		this.frame = f;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Gallic", Font.BOLD, 60));
		g.drawString("Game Over!", 40, 50);
	}
}
>>>>>>> origin/master
