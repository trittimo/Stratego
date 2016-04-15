package stratego.gui;

import static stratego.Constants.Dimensions.*;

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
		
		MouseHandler mouseHandler = new MouseHandler(game);
		GUIMap map = new GUIMap(game, mouseHandler);
		GUIPieceSelector selector = new GUIPieceSelector(game, mouseHandler);
		GUIMessageDisplay display = new GUIMessageDisplay();
		
		JPanel mapDisplayContainer = new JPanel();
		
		mapDisplayContainer.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		mapDisplayContainer.add(map);
		mapDisplayContainer.add(display);
		
		
		this.setBackground(Color.GRAY);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(mapDisplayContainer);
		this.add(selector);
		
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
	}
}
