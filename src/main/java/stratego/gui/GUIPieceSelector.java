package stratego.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import stratego.Constants;
import stratego.gui.GUIPiece.PieceType;
import stratego.logic.Game;
import stratego.logic.Piece;

public class GUIPieceSelector extends JPanel {
	private ArrayList<GUIPiece> piecesInSelectorP1 = new ArrayList<GUIPiece>();
	private ArrayList<GUIPiece> piecesInSelectorP2 = new ArrayList<GUIPiece>();

	private Game game;

	public GUIPieceSelector(Game game) throws IOException {
		this.game = game;

		this.setBackground(Color.BLUE);
		this.setPreferredSize(new Dimension(Constants.Dimensions.SELECTOR_WIDTH, Constants.Dimensions.SELECTOR_HEIGHT));
		this.setLayout(new GridLayout(3, 14));

		GUIPiece.loadPieceImages();
	}

	public void switchTurns() {
		System.out.println("switching turns");
		ArrayList<GUIPiece> pieces = this.game.whoseTurn() == 1 ? this.piecesInSelectorP1 : this.piecesInSelectorP2;
		this.removeAll();
		if(this.getBackground() == Color.BLUE){
			this.setBackground(Color.RED);
		}else {
			this.setBackground(Color.BLUE);
		}
		this.setBackground(Color.RED);
		for (GUIPiece piece : pieces) {
			this.add(piece);
		}
	}

	public void removePiece(GUIPiece piece) {
		if (!piecesInSelectorP1.remove(piece)) {
			piecesInSelectorP2.remove(piece);
		}
		this.remove(piece);
		this.repaint();
	}

	public void loadPieces(MouseHandler mouseHandler) {
		//for each piece type create correct number of pieces
		for (PieceType piece : GUIPiece.PieceType.values()) {
			for (int i = 0; i < piece.initialCount; i++) {
				GUIPiece p1 = new GUIPiece(this.game, new Piece(piece.value, 1), piece);
				p1.addMouseListener(mouseHandler);
				GUIPiece p2 = new GUIPiece(this.game, new Piece(piece.value, 1), piece);
				p2.addMouseListener(mouseHandler);

				piecesInSelectorP1.add(p1);
				piecesInSelectorP2.add(p2);
			}
		}
		
		for (GUIPiece piece : piecesInSelectorP1) {
			this.add(piece);
		}
	}
}
