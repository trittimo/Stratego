package stratego.gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Main extends JPanel implements ActionListener{
	 
	final static int WINDOW_WIDTH = 800;
	final static int WINDOW_HEIGHT = 800;
	Timer timer;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("Statego!");
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		f.setVisible(true);

		Main main = new Main();
		f.add(main);
		main.timer.start();
		
	}
	
	public Main() {
		this.timer = new Timer(20,this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BoardScreen board = new BoardScreen(g);
		PieceDisplayingScreen pieces = new PieceDisplayingScreen(g);
		MessageScreen msg = new MessageScreen(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}
	
	

}
