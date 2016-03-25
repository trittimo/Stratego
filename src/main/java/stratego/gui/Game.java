package stratego.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Game {
	final static String PATH = "/Users/wuy5/Documents/GitHub/CodeCoverageExample/map_1";
	
	public void loadMap() throws IOException, FileNotFoundException {
		Scanner scanner;
		GameComponent gc = new GameComponent();
		try{
			scanner = new Scanner(new File(PATH));
			while(scanner.hasNext()){
				gc.pickPiece(null);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
