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

	public MouseHandler(Game game, GUIPieceSelector selector, GUIMap map) {
		this.game = game;
		
		this.selector = selector;
		this.selector.addMouseListener(this);
		this.selector.loadPieces(this);
		
		this.map = map;
		this.map.addMouseListener(this);
	}

	@SuppressWarnings("unqualified-field-access")
	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println("selectedPiece: " + selectedPiece);
		System.out.println("mapSelectedPiece: " + mapSelectedPiece);
		System.out.println("mapX: " + mapSelectedX + ", mapY: " + mapSelectedY);
		
		//if you clicked on a piece
		System.out.println("clicked on GUIPiece");
		if (e.getComponent() instanceof GUIPiece){
			
			//if this piece is in the GUIPieceSelector
			if (e.getComponent().getParent() instanceof GUIPieceSelector) {
				System.out.println("clicked piece on selector");
				//de-select previously selected piece
				if (selectedPiece != null) {
					selectedPiece.setSelected(false);
				}
				//select this new piece you just clicked on
				selectedPiece = (GUIPiece) e.getComponent();
				selectedPiece.setSelected(true); 
			}
			//if this piece is on the map
			else{
			System.out.println("clicked piece on map");
			//get location on the map
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
		//this puts pieces on the map/moves them around map
		} else if (e.getComponent() instanceof GUIMap) {
			System.out.println("clicked on GUIMap");
			int x = (int) (((double) e.getX()) / ((double) Constants.Dimensions.BOARD_WIDTH) * 10);
			int y = (int) (((double) e.getY()) / ((double) Constants.Dimensions.BOARD_WIDTH) * 10);
			
			//if trying to put selected piece from selector onto the board
			if (selectedPiece != null) {
				selectedPiece.setSelected(false);
				//if the space is not occupied and it is a valid location on the board, then place piece
				System.out.println("checking if piece can be placed there. Occupied?: " + game.getBoard().isOccupied(x, y) +
						" Valid place?: " + game.getBoard().isValidToPlacePiece(x, y, game.whoseTurn()));
				if (!game.getBoard().isOccupied(x, y) && game.getBoard().isValidToPlacePiece(x, y, game.whoseTurn())) {//************add more check to 
					System.out.println("placed new piece: " + selectedPiece.getPiece().getPieceName());
					game.getBoard().placePiece(x, y, selectedPiece.getPiece());
					map.addPiece(selectedPiece, x, y);
					System.out.println("Number of pieces placed: " + game.getBoard().pieceCount());
					selector.removePiece(selectedPiece);
				}
				selectedPiece = null;
				
				//if 40 or 80 pieces have been placed and the game is in the beginning setup phase switch selectors
				if(game.getBoard().pieceCount() != 0 && game.getBoard().pieceCount() % game.totalPiecesPerPlayer == 0 && game.isBeginning()){
					System.out.println("switching turns");
					game.switchTurns();
					selector.switchTurns();
					mapSelectedPiece = null;
				}
			} else if (mapSelectedPiece != null) {
				mapSelectedPiece.setSelected(false);

				try {
					System.out.println("moving piece on board");
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
