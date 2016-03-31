package stratego.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LoadImage {

	/**
	 * Load image from desired file and draw it on frame
	 * 
	 * @param g
	 * @param name
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void draw(Graphics g, ImageData data) {
		BufferedImage bImg = null;
		try {
			bImg = ImageIO.read(new File("images" + File.separator + data.name + ".png"));
			g.drawImage(bImg, data.x, data.y, data.width, data.height, null);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error");
		}
	}

}
