package stratego.gui;

import static stratego.Constants.MAP_FILE;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import stratego.Constants.Dimensions;
import stratego.logic.Game;

public class GUIMap extends JPanel {
	private Game game;
	private BufferedImage map;

	private JPanel[][] grid = new JPanel[10][10];

	public GUIMap(Game game) throws IOException {
		this.game = game;
		this.map = ImageIO.read(MAP_FILE);

//		this.addMouseListener(handler);
//		handler.setMap(this);

		this.setLayout(new GridLayout(10, 10));
		this.setPreferredSize(new Dimension(Dimensions.BOARD_WIDTH, Dimensions.BOARD_HEIGHT));

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				JPanel panel = new JPanel();
				panel.setOpaque(false);
				panel.setPreferredSize(new Dimension(Dimensions.BOARD_WIDTH / 10, Dimensions.BOARD_WIDTH / 10));
				grid[j][i] = panel;
				this.add(grid[j][i]);
			}
		}
	}
	
	public Point getLocation(Container container){
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[j][i] == container){
					return new Point (j, i);
				} 
			}
		}
		
		return null; 
	}

	public void addPiece(GUIPiece piece, int x, int y) {
		grid[x][y].setOpaque(false);
		grid[x][y].setBackground(new Color(0, 0, 0));
		grid[x][y].add(piece);
		piece.setOnBoard(true);
		piece.setPreferredSize(new Dimension(piece.getPieceSize(), piece.getPieceSize()));
		piece.revalidate();
		piece.repaint();
		grid[x][y].revalidate();
		grid[x][y].repaint();
	}

	public void movePiece(GUIPiece piece, int x1, int y1, int x2, int y2) {
		System.out.println(grid[x1][y1].getComponentCount());
		grid[x1][y1].remove(piece);
		System.out.println(grid[x1][y1].getComponentCount());
		
		grid[x1][y1].revalidate();
		grid[x1][y1].repaint();
		
		//grid[x1][y1].setOpaque(true);
		addPiece(piece, x2, y2);
		grid[x1][y1].revalidate();
		grid[x1][y1].repaint();
		
		this.revalidate();
		this.repaint();

	}

	public GUIPiece getPiece(int x, int y) {
		if (grid[x][y].getComponentCount() != 0) {
			return (GUIPiece) grid[x][y].getComponent(0);
		}
		return null;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(map, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
