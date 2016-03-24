package stratego.logic;

import stratego.logic.exceptions.InvalidPieceValue;

/**
 * This class contains the information about pieces that are placed on the board
 */
public class Piece {

	private String[] pieceNames = { "Marshal", "General", "Colonel", "Major", "Captain", "Lieutenant", "Sergeant",
			"Miner", "Scout", "Spy", "Bomb", "Flag" };

	private int pieceValue;
	private int player;

	public Piece(int value, int player) throws InvalidPieceValue {
		if (value < 1 || value > pieceNames.length) {
			throw new InvalidPieceValue(value);
		}
		this.pieceValue = value;
		this.player = player;
	}

	/**
	 * @return the integer value corresponding to a certain piece
	 */
	public int getValue() {
		return this.pieceValue;
	}

	/**
	 * @return the player who 'owns' this particular piece
	 */
	public int getPlayer() {
		return this.player;
	}

	/**
	 * @return the string representation of this particular piece
	 */
	public String getPieceName() {
		return pieceNames[this.getValue() - 1];
	}

}
