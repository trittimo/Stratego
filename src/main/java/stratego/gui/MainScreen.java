package stratego.gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainScreen extends JPanel implements ActionListener {

	final static int WINDOW_WIDTH = 800;
	final static int WINDOW_HEIGHT = 800;
	Timer timer;
	GameComponent gc, currentPiece;
	boolean clicked;
	GameComponent[] survivalCheckList;
	GameComponent flag, bomb1, bomb2, bomb3, bomb4, bomb5, bomb6, spy, scout1, scout2, scout3, scout4, scout5, scout6,
			scout7, scout8, minor1, minor2, minor3, minor4, minor5, serg1, serg2, serg3, serg4, lieut1, lieut2, lieut3,
			lieut4, cap1, cap2, cap3, cap4, major1, major2, major3, colo1, colo2, gen, marsh;
	ArrayList<GameComponent> pieces;

	public static void main(String[] args) {
		JFrame f = new JFrame("Statego!");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		f.setVisible(true);

		MainScreen main = new MainScreen();
		MouseListener mouse = new Mouse(main);
		f.add(main);
		f.addMouseListener(mouse);
		main.timer.start();

	}

	/**
	 * This is the Main constructor
	 */
	public MainScreen() {
		this.timer = new Timer(20, this);
		
		// this.flag = new GameComponent(2, "F");
		// this.bomb1 = new GameComponent(3, "B");
		// this.bomb2 = new GameComponent(4, "B");
		// this.bomb3 = new GameComponent(5, "B");
		// this.bomb4 = new GameComponent(6, "B");
		// this.bomb5 = new GameComponent(7, "B");
		// this.bomb6 = new GameComponent(8, "B");
		this.gc = new GameComponent(10, "1");
		// this.scout1 = new GameComponent(11, "2");
		// this.scout2 = new GameComponent(11, "2");
		// this.scout3 = new GameComponent(11, "2");
		// this.scout4 = new GameComponent(11, "2");
		// this.scout5 = new GameComponent(11, "2");
		// this.scout6 = new GameComponent(11, "2");
		// this.scout7 = new GameComponent(11, "2");
		// this.scout8 = new GameComponent(11, "2");
		// this.minor1 = new GameComponent(11, "3");
		// this.minor2 = new GameComponent(11, "3");
		// this.minor3 = new GameComponent(11, "3");
		// this.minor4 = new GameComponent(11, "3");
		// this.minor5 = new GameComponent(11, "3");
		// this.serg1 = new GameComponent(11, "4");
		// this.serg2 = new GameComponent(11, "4");
		// this.serg3 = new GameComponent(11, "4");
		// this.serg4 = new GameComponent(11, "4");
		// this.lieut1 = new GameComponent(11, "5");
		// this.lieut2 = new GameComponent(11, "5");
		// this.lieut3 = new GameComponent(11, "5");
		// this.lieut4 = new GameComponent(11, "5");
		// this.cap1 = new GameComponent(11, "6");
		// this.cap2 = new GameComponent(11, "6");
		// this.cap3 = new GameComponent(11, "6");
		// this.cap4 = new GameComponent(11, "6");
		// this.major1 = new GameComponent(11, "7");
		// this.major2 = new GameComponent(11, "7");
		// this.major3 = new GameComponent(11, "7");
		// this.colo1 = new GameComponent(11, "8");
		// this.colo2 = new GameComponent(11, "8");
		// this.gen = new GameComponent(11, "9");
		// this.marsh = new GameComponent(11, "0");
		this.currentPiece = null;
		this.clicked = false;
	}

	/**
	 * For piece in the given tile, select it
	 * 
	 * @param tile
	 */
	public void selectPiece(int tile) {
		System.out.println(tile + " " + this.gc.getTile());
		if (this.gc.getTile() == tile) {
			currentPiece = gc;
			this.clicked = true;
			System.out.println("here");
		} else if (this.clicked) {
			this.currentPiece.setTile(tile);
			this.clicked = false;
			this.currentPiece = null;
			System.out.println("there");
		}
	}

	/**
	 * Put all the big parts together here
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BoardScreen board = new BoardScreen(g);
		PieceDisplayingScreen pieces = new PieceDisplayingScreen();
		pieces.drawOn(g);
		MessageScreen msg = new MessageScreen(g);
//		for()
		this.gc.draw(g);
	}

	/**
	 * Keep repainting
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}

}
