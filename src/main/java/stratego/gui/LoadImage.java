<<<<<<< HEAD
package stratego.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LoadImage {
	
	private Image image;
	private JPanel panel;
	private Graphics graphics;
	
	/**
	 * Constructor
	 */
	public LoadImage() {
		//nothing
	}
	
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
	public void draw(Graphics g, String name, int x, int y, int width, int height) {
		BufferedImage bImg = null;
		try{
			bImg = ImageIO.read(new File("images" +File.separator+ name + ".png"));
		    g.drawImage(bImg, x, y, width, height, null);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("error");
		}
	}
	
}
=======
package stratego.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LoadImage {

	private Image image;
	private JPanel panel;
	private Graphics graphics;

	public LoadImage() {
		// nothing
	}

	public void draw(Graphics g, String name, int x, int y, int width, int height) {
		BufferedImage bImg = null;
		try {
			bImg = ImageIO.read(new File("images" + File.separator + name + ".png"));
			g.drawImage(bImg, x, y, width, height, null);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error");
		}
	}

}
>>>>>>> origin/master
