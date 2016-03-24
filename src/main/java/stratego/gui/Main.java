package stratego.gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import sun.awt.RepaintArea;


public class Main extends JPanel implements ActionListener{
	 
	final static int WINDOW_WIDTH = 800;
	final static int WINDOW_HEIGHT = 800;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("Statego!");
		
		MessagePanel mp = new MessagePanel();
		f.add(mp.get());
		BoardPanel bp = new BoardPanel();
		f.add(bp.get());
		PieceDisplayingBoard pp = new PieceDisplayingBoard();
		f.add(pp.get());
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		f.setVisible(true);
		
	}
	
	public Main() {
		Timer timer = new Timer(20,this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
		LoadImage image = new LoadImage();
		image.draw(g, "map", 300, 0, 500, 500);
	}
	
	

}
