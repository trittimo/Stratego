package stratego.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import stratego.Constants;
import stratego.logic.Game;

public class MouseHandler implements MouseListener {

	private Game game;
	private GUIPiece selectedPiece;
	private GUIPiece mapSelectedPiece;
	private int mapSelectedX;
	private int mapSelectedY;
	private GUIPieceSelector selector;
	private GUIMap map;

	public MouseHandler(Game game) {
		this.game = game;
	}

	public void setSelector(GUIPieceSelector guiPieceSelector) {
		this.selector = guiPieceSelector;
	}

	public void setMap(GUIMap map) {
		this.map = map;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent() instanceof GUIPiece) {
			if (selectedPiece != null) {
				selectedPiece.setSelected(false);
			}
			selectedPiece = (GUIPiece) e.getComponent();
			selectedPiece.setSelected(true);
		} else if (e.getComponent() instanceof GUIMap) {
			int x = (int) (((double) e.getX()) / ((double) Constants.Dimensions.BOARD_WIDTH) * 10);
			int y = (int) (((double) e.getY()) / ((double) Constants.Dimensions.BOARD_WIDTH) * 10);
			if (selectedPiece != null) {
				selectedPiece.setSelected(false);
				if (!game.getBoard().isOccupied(x, y)) {
					game.getBoard().placePiece(x, y, selectedPiece.getPiece());
					map.addPiece(selectedPiece, x, y);
					selector.removePiece(selectedPiece);
				}
				selectedPiece = null;
			} else if (mapSelectedPiece != null) {
				mapSelectedPiece.setSelected(false);

				try {
					game.getBoard().movePiece(mapSelectedX, mapSelectedY, x, y);
					map.movePiece(mapSelectedPiece, mapSelectedX, mapSelectedY, x, y);
				} catch (Exception exception) {
					// TODO do something with these exceptions
					System.err.println("Unable to move: " + exception.getMessage());
				}

				mapSelectedPiece = null;
			} else if (game.getBoard().isOccupied(x, y)) {
				mapSelectedPiece = map.getPiece(x, y);
				if (mapSelectedPiece != null) {
					mapSelectedPiece.setSelected(true);
					mapSelectedX = x;
					mapSelectedY = y;
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
