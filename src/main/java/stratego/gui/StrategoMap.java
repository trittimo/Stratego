package stratego.gui;

import java.io.File;

import javax.swing.JPanel;

public class StrategoMap extends JPanel {
	
	private ImagePanel map;
	
	public StrategoMap(ImagePanel map) {
		this.map = map;
		this.add(map);
	}
	
	public ImagePanel addPiece(int x, int y, File pieceLocation) {
		// TODO
		return null;
	}
	
	public void removePiece(ImagePanel piece) {
		this.remove(piece);
	}
	
	
}
