package stratego.gui;

import java.awt.Point;
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

	@SuppressWarnings("unqualified-field-access")
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//if you clicked on a piece
		System.out.println("clicked on GUIPiece");
		if (e.getComponent() instanceof GUIPiece){
			
			if (e.getComponent().getParent() instanceof GUIPieceSelector) {
				if (selectedPiece != null) {
					selectedPiece.setSelected(false);
				}
				selectedPiece = (GUIPiece) e.getComponent();
				selectedPiece.setSelected(true); 
			}
			else{
			Point p = map.getLocation(e.getComponent().getParent()); 
			int x = (int) p.getX(); 
			int y = (int) p.getY();
				//checks if the location on the board that is clicked is occupied by a piece
				if (game.getBoard().isOccupied(x, y)) {
					//checks if piece previously selected on map is a piece - starts an attack if so
					if (mapSelectedPiece != null) {
						// TODO attack
						mapSelectedPiece.setSelected(false);
					}
					//set currently selected piece as mapSelectedPiece
					mapSelectedPiece = map.getPiece(x, y);
					//if where selected is an actual piece
					if (mapSelectedPiece != null) {
						mapSelectedPiece.setSelected(true);
						mapSelectedX = x;
						mapSelectedY = y;
					}
				}
			}
		
		//if click on the map, called after click on GUIPiece
		} else if (e.getComponent() instanceof GUIMap) {
			System.out.println("clicked on GUIMap");
			int x = (int) (((double) e.getX()) / ((double) Constants.Dimensions.BOARD_WIDTH) * 10);
			int y = (int) (((double) e.getY()) / ((double) Constants.Dimensions.BOARD_WIDTH) * 10);
			
			if (selectedPiece != null) {
				selectedPiece.setSelected(false);
				//if the space is not occupied and it is a valid location on the board, then place piece
				System.out.println("checking if piece can be placed there. Occupied?: " + game.getBoard().isOccupied(x, y) +
						" Valid place?: " + game.getBoard().isValidToPlacePiece(x, y, game.whoseTurn()));
				if (!game.getBoard().isOccupied(x, y) && game.getBoard().isValidToPlacePiece(x, y, game.whoseTurn())) {
					System.out.println("placed new piece: " + selectedPiece.getPiece().getPieceName());
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
