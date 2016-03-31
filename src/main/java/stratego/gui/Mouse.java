package stratego.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {

	MainScreen main;

	public Mouse(MainScreen main) {
		this.main = main;
	}

	/**
	 * Move the piece when click the new place on board
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 10; j++) {
				if (e.getX() > i * 60 + 20 && e.getX() < 60 * (i + 1) + 20 && e.getY() > j * 60 + 30
						&& e.getY() < 60 * (j + 1) + 30) {
					this.main.selectPiece(j + 10 * i);
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// do nothing
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// do nothing
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// do nothing
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// do nothing
	}

}
