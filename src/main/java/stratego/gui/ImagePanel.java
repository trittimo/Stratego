package stratego.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private BufferedImage image;
	
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	public ImagePanel(File file, int width, int height, int x, int y) throws Exception {
		try {
			this.image = ImageIO.read(file);
		} catch (IOException e) {
			throw new Exception("Unable to load file: " + file.getName());
		}
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		
		this.setPreferredSize(new Dimension(width, height));
		this.setLocation(x, y);
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, width, height, null);
	}
}
