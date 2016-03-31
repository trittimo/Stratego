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

	Timer timer;
	GameComponent gc, currentPiece;
	boolean clicked, once;
	GameComponent[] survivalCheckList;
	ArrayList<GameComponent> pieceList;

	/**
	 * This is the Main constructor
	 */
	public MainScreen() {
		this.timer = new Timer(20, this);
		this.timer.start();
		this.currentPiece = null;
		this.clicked = false;
	}

	/**
	 * For piece in the given tile, select it
	 * 
	 * @param tile
	 */
	public void selectPiece(int tile) {
		for (int i = 0; i < pieceList.size(); i++) {
			if (this.clicked) {
				this.currentPiece.setTile(tile);
				this.clicked = false;
				this.currentPiece = null;
				break;
			} else if (this.pieceList.get(i).getTile() == tile) {
				currentPiece = pieceList.get(i);
				this.clicked = true;
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
		if (!once) {
			PieceDisplayingScreen piecesBoard = new PieceDisplayingScreen();
			this.pieceList = piecesBoard.drawOn(g);
			once = true;
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
