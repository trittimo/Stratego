package stratego.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainScreen extends JPanel implements ActionListener {

	private GameComponent currentPiece;
	private boolean clicked, once;
	private ArrayList<GameComponent> pieceList;

	/**
	 * This is the Main constructor
	 */
	public MainScreen() {
		this.currentPiece = null;
		this.once = false;
		this.clicked = false;
		this.pieceList = null;
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
