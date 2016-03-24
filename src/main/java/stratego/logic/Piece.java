package stratego.logic;

import stratego.logic.exceptions.InvalidPieceValue;
import stratego.logic.exceptions.InvalidPlayer;

/**
 * This class contains the information about pieces that are placed on the board
 */
public class Piece {

	private static String[] pieceNames = { "Marshal", "General", "Colonel", "Major", "Captain",
			"Lieutenant", "Sergeant", "Miner", "Scout", "Spy", "Bomb", "Flag" };

	private int pieceValue;
	private int player;

	public Piece(int value, int player) {
		if (value < 1 || value > pieceNames.length) {
			throw new InvalidPieceValue(value);
		}
		if (player < 1 || player > 2) {
			throw new InvalidPlayer(player);
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

	/**
	 * @return the rank of the piece, in the range [1, 10]
	 */
	public int getRank() {
		return 11 - this.getValue();
	}

}
