package stratego.gui;

import static stratego.Constants.Dimensions.WINDOW_HEIGHT;
import static stratego.Constants.Dimensions.WINDOW_WIDTH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import stratego.logic.Game;

public class StrategoPanel extends JPanel {

	private Game game;

	public StrategoPanel(Game game) throws IOException {
		this.game = game;

		
		//GUIMap map = new GUIMap(game, mouseHandler);
		GUIMap map = new GUIMap(game);
		//GUIPieceSelector selector = new GUIPieceSelector(game, mouseHandler);
		GUIPieceSelector selector = new GUIPieceSelector(game);
		
		GUIMessageDisplay display = new GUIMessageDisplay(game);
		
		MouseHandler mouseHandler = new MouseHandler(game, selector, map); //maybe doesn't need to know of game

		//displays the JPanel that holds the map 
		JPanel mapDisplayContainer = new JPanel();
		mapDisplayContainer.setLayout(new FlowLayout(FlowLayout.LEADING));
		mapDisplayContainer.add(map);
		mapDisplayContainer.add(display);
		

		

		this.setBackground(Color.GRAY);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//this.add(playerTurn);
		this.add(mapDisplayContainer);
		this.add(selector);

		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
	}
}
