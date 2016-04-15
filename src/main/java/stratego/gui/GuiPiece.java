package stratego.gui;

import static stratego.Constants.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class GUIPiece extends JComponent {
	
	
	
	public enum PieceType {
		Marshal(1, 1),
		General(1, 2),
		Colonel(2, 3),
		Major(3, 4),
		Captain(4, 5),
		Lieutenant(4, 6),
		Sergeant(4, 7),
		Miner(5, 8),
		Scout(8, 9),
		Spy(9, 10),
		Bomb(6, 11),
		Flag(1, 12);
		
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
