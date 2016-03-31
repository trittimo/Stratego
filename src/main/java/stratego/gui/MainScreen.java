package stratego.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainScreen extends JPanel implements ActionListener {

	final static int WINDOW_WIDTH = 900;
	final static int WINDOW_HEIGHT = 900;
	Timer timer;
	GameComponent gc, currentPiece;
	boolean clicked, once;
	GameComponent[] survivalCheckList;
	GameComponent flag, bomb1, bomb2, bomb3, bomb4, bomb5, bomb6, spy, scout1, scout2, scout3, scout4, scout5, scout6,
			scout7, scout8, minor1, minor2, minor3, minor4, minor5, serg1, serg2, serg3, serg4, lieut1, lieut2, lieut3,
			lieut4, cap1, cap2, cap3, cap4, major1, major2, major3, colo1, colo2, gen, marsh;
	ArrayList<GameComponent> pieceList;

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
		// this.gc = new GameComponent(10, "1");
		this.currentPiece = null;
		this.clicked = false;
	}

	/**
	 * For piece in the given tile, select it
	 * 
	 * @param tile
	 */
	public void selectPiece(int tile) {
		// System.out.println(tile + " " + this.gc.getTile());
		for (int i = 0; i < pieceList.size(); i++) {

			if (this.clicked) {
				System.out.println("curTile: " + this.currentPiece.getTile());
				this.currentPiece.setTile(tile);
				this.clicked = false;
				this.currentPiece = null;
				System.out.println("there");
				break;
			} else if (this.pieceList.get(i).getTile() == tile) {
				currentPiece = pieceList.get(i);
				this.clicked = true;
				System.out.println(this.currentPiece.getTile() + " cur tile");
				break;
			}
		}
	}

	/**
	 * Put all the big parts together here
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BoardScreen board = new BoardScreen(g);
		g.setColor(Color.blue);
		g.fillRect(600, 0, 300, 900);
		if(!once){
			PieceDisplayingScreen piecesBoard = new PieceDisplayingScreen();
			this.pieceList = piecesBoard.drawOn(g);
			once=true;
		}

		MessageScreen msg = new MessageScreen(g);
		for (int i = 0; i < this.pieceList.size(); i++) {
			this.pieceList.get(i).draw(g);
		}
	}

	/**
	 * Keep repainting
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}

}
