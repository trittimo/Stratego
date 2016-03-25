package stratego.gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener {

	final static int WINDOW_WIDTH = 800;
	final static int WINDOW_HEIGHT = 800;
	Timer timer;
	GameComponent gc, currentPiece;
	boolean clicked;

	public static void main(String[] args) {
		JFrame f = new JFrame("Statego!");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		f.setVisible(true);

		Main main = new Main();
		MouseListener mouse = new Mouse(main);
		f.add(main);
		f.addMouseListener(mouse);
		main.timer.start();

	}

	public Main() {
		this.timer = new Timer(20, this);
		this.gc = new GameComponent(10, "1");
		this.currentPiece = null;
		this.clicked = false;
	}

	public void selectPiece(int tile){
		System.out.println(tile+" "+this.gc.getTile());
		if(this.gc.getTile()==tile){
			currentPiece=gc;
			this.clicked=true;
			System.out.println("here");
		}else if(this.clicked){
			this.currentPiece.setTile(tile);
			this.clicked=false;
			this.currentPiece=null;
			System.out.println("there");
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BoardScreen board = new BoardScreen(g);
		PieceDisplayingScreen pieces = new PieceDisplayingScreen(g);
		MessageScreen msg = new MessageScreen(g);
		this.gc.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}

}
