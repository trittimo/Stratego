package stratego.logic;

import stratego.logic.exceptions.InvalidAttacker;
import stratego.logic.exceptions.InvalidPieceValue;
import stratego.logic.exceptions.InvalidPlayer;

/**
 * This class contains the information about pieces that are placed on the board
 */
public class Piece {

	private static String[] pieceNames = { "Marshal", "General", "Colonel", "Major", "Captain", "Lieutenant",
			"Sergeant", "Miner", "Scout", "Spy", "Bomb", "Flag" };

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
	 * @return the rank of the piece, in the range [1, 10] rank in the range of
	 *         [1, 10] are regular pieces rank of 0 is a bomb rank of -1 is the
	 *         flag
	 */
	public int getRank() {
		return 11 - this.getValue();
	}
	
	/**
	 * Returns the winner between an exchange
	 * @param valueAttacker The piece value of the attacker
	 * @param valueDefender The piece value of the defender
	 * @return the piece value of the winner, or -1 if neither piece wins
	 */
	public static int getWinner(int valueAttacker, int valueDefender) {
		//if trying to attack with a bomb or flag
		if (valueAttacker == 11 || valueAttacker == 12){
			throw new InvalidAttacker(valueAttacker);
		}else if(valueAttacker < 1 || valueAttacker > 12){
			throw new InvalidPieceValue(valueAttacker);
		}else if(valueDefender < 1 || valueDefender > 12){
			throw new InvalidPieceValue(valueDefender);
		}
		if (valueAttacker == valueDefender) { // If the pieces are the same rank
			return -1; // Nobody wins
		} else if (valueDefender == 12) { // The flag can't win
			return valueAttacker;
		}
		
		switch(valueAttacker) {
		case 3:
			return valueDefender == 11 || valueAttacker < valueDefender ? valueAttacker : valueDefender;
		case 10:
			return valueDefender == 1 ? valueAttacker : valueDefender;
		}
		
		if (valueDefender == 11) { // Bombs win in most exchanges
			return valueDefender;
		} else if (valueAttacker < valueDefender) {
			return valueAttacker;
		} else {
			return valueDefender;
		}
	}

}
