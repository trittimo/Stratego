package stratego;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.JFrame;

import stratego.gui.StrategoPanel;

public class Main {

	private static final String[] PIECES = { "Marshal", "General", "Colonel", "Major", "Captain", "Lieutenant",
			"Sergeant", "Miner", "Scout", "Spy", "Bomb", "Flag" };

	private static HashMap<String, File> imageFiles = new HashMap<String, File>();

	public static void main(String[] args) {
		try {
			loadImageFiles();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			return;
		}

		JFrame frame = new JFrame("Stratego!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		StrategoPanel gui = new StrategoPanel();
		frame.getContentPane().add(gui);

		frame.pack();
		frame.setVisible(true);
	}

	public static void loadImageFiles() throws FileNotFoundException {
		for (int i = 0; i < PIECES.length; i++) {
			imageFiles.put(PIECES[i], new File("images" + File.separator + PIECES[i] + ".png"));

		}
	}
}
