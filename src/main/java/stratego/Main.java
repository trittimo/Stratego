package stratego;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.JFrame;

import stratego.gui.StrategoPanel;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Stratego!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		StrategoPanel gui = new StrategoPanel();
		frame.getContentPane().add(gui);

		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
