/**
 * 
 */
package stratego;

import java.awt.event.MouseListener;

import javax.swing.JFrame;

import stratego.gui.MainScreen;
import stratego.gui.Mouse;

public class Main {
	final static int WINDOW_WIDTH = 900;
	final static int WINDOW_HEIGHT = 900;
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Statego!");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		f.setVisible(true);

		MainScreen main = new MainScreen();
		MouseListener mouse = new Mouse(main);
		f.add(main);
		f.addMouseListener(mouse);
	}
}
