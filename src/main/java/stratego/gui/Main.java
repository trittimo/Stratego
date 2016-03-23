package stratego.gui;

import javax.swing.JFrame;

public class Main {
	final static int WINDOW_WIDTH = 800;
	final static int WINDOW_HEIGHT = 800;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("Statego!");
		
		MainPanel mp = new MainPanel(f);
		
//		f.add(mp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		f.setVisible(true);
		
	}
	

}
