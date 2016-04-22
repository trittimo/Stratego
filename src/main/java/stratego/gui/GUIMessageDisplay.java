package stratego.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import stratego.Constants;
import stratego.logic.Game;

public class GUIMessageDisplay extends JPanel {
	
	private Game game; 
	
	public GUIMessageDisplay(Game game) {
		this.setPreferredSize(new Dimension(Constants.Dimensions.MESSAGES_WIDTH, Constants.Dimensions.MESSAGES_HEIGHT));
		this.setBackground(Color.CYAN);
		this.game = game; 
		
		JLabel playerTurn = new JLabel("Player " + game.whoseTurn() + " 's turn");
//		playerTurn.setSize(new Dimension 
//				(stratego.Constants.Dimensions.MESSAGES_HEIGHT, 100));
//		playerTurn.setLocation(0, 0);
		playerTurn.setForeground(Color.RED);
		this.add(playerTurn);
		
		JLabel playerPieces = new JLabel("Player " + game.whoseTurn() + " 's pieces: ");
		playerPieces.setForeground(Color.RED);
		
		//JLabel playerPieces = new JLabel()
		
		
		

	}
	
	

}
