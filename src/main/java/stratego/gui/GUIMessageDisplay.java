package stratego.gui;

import static stratego.Constants.IMAGES;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import stratego.Constants;
import stratego.logic.Game;

public class GUIMessageDisplay extends JPanel {
	
	private Game game;
	private BufferedImage pieceKey; 
	
	public GUIMessageDisplay(Game game) throws IOException {
		this.setPreferredSize(new Dimension(Constants.Dimensions.MESSAGES_WIDTH, Constants.Dimensions.MESSAGES_HEIGHT));
		this.setBackground(Color.CYAN);
		this.game = game; 
		
		JLabel playerTurn = new JLabel("Player " + this.game.whoseTurn() + " 's turn");
		playerTurn.setForeground(Color.RED);
		this.add(playerTurn);
		
		JLabel playerPieces = new JLabel("Player " + game.whoseTurn() + " 's pieces: ");
		playerPieces.setForeground(Color.RED);
		
//		BufferedImage totalPic = ImageIO.read(new File(IMAGES,"total.png"));
//		JLabel picLabel = new JLabel(new ImageIcon(totalPic));
//		this.add(picLabel);

		
	}
	
	
	public void loadImage() throws IOException{
		File path = new File (IMAGES, this.toString() + ".png");
		try{
			this.pieceKey = ImageIO.read(path);
		} catch (IOException e){
			throw new IOException ("Failed to load resource: " + path.getName());
		}
	}
	
	

}
