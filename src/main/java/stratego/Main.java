package stratego;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import stratego.gui.GUIPiece;
import stratego.gui.GUIPiece.PieceType;
import stratego.gui.StrategoPanel;
import stratego.logic.Board;
import stratego.logic.Game;
import stratego.logic.Piece;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Stratego!");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				StrategoPanel gui = null;
				try {
					gui = new StrategoPanel(new Game(new Board(new Piece[10][10])));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					return;
				}
				frame.getContentPane().add(gui);

				frame.pack();
				frame.setResizable(false);
				frame.setVisible(true);
			}
		});

	}
}
