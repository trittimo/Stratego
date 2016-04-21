package stratego.gui;

import static stratego.Constants.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import stratego.Constants.Dimensions;
import stratego.logic.Game;
import stratego.logic.Piece;

public class GUIPiece extends JComponent {
	private Game game;
	private Piece piece;
	private PieceType type;
	private boolean onBoard = false;
	private boolean isVisible = true;
	private boolean selected;
	private static BufferedImage invisibleImage;

	public GUIPiece(Game game, Piece piece, PieceType type) {
		this.game = game;
		this.piece = piece;
		this.type = type;
	}

	public void setPieceVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void setOnBoard(boolean onBoard) {
		this.onBoard = onBoard;
	}

	public int getPieceSize() {
		if (this.onBoard) {
			return Dimensions.BOARD_WIDTH / 10;
		} else {
			return Dimensions.SELECTOR_WIDTH * 3 / 40;
		}
	}

	public BufferedImage getImage() {
		if (this.isVisible) {
			return this.type.image;
		} else {
			return invisibleImage;
		}
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		this.repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		// super.paintComponent(g);
		g.drawImage(this.getImage(), 0, 0, this.getPieceSize(), this.getPieceSize(), null);
		if (this.selected) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.WHITE);
			g2.setStroke(new BasicStroke(3));
			g2.drawRect(0, 0, this.getPieceSize() - 3, this.getPieceSize());
		}
	}

	public static void loadPieceImages() throws IOException {
		for (PieceType piece : PieceType.values()) {
			piece.loadImage();
		}
		invisibleImage = ImageIO.read(INVISIBLE_FILE);
	}

	public enum PieceType {
		Marshal(1, 1), General(1, 2), Colonel(2, 3), Major(3, 4), Captain(4, 5), Lieutenant(4, 6), Sergeant(4,
				7), Miner(5, 8), Scout(8, 9), Spy(1, 10), Bomb(6, 11), Flag(1, 12);

		public final int initialCount;
		public final int value;
		public BufferedImage image;

		PieceType(int initialCount, int value) {
			this.initialCount = initialCount;
			this.value = value;
		}

		public void loadImage() throws IOException {
			File path = new File(IMAGES, this.toString() + ".png");
			try {
				this.image = ImageIO.read(path);
			} catch (IOException e) {
				throw new IOException("Failed to load resource: " + path.getName());
			}
		}

	}
}
