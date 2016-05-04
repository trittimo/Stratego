import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import stratego.logic.*;

public class GameErrorHandling {

	public Game game;
	public Board board;
	public ArrayList<Piece> pieces = new ArrayList<Piece>();
	public ArrayList<Exception> errors = new ArrayList<Exception>();

	@Given("^we have an empty board$")
	public void we_have_an_empty_board() throws Throwable {
		this.board = new Board(new Piece[10][10]);
		this.game = new Game(this.board);
	}

	@Given("^it is the beginning of the game$")
	public void it_is_the_beginning_of_the_game() throws Throwable {
		// Nothing to do here
	}

	@Given("^it is player (\\d+) turn$")
	public void it_is_player_turn(int player) throws Throwable {
		if (this.game.whoseTurn() != player) {
			this.game.switchTurns();
		}
	}

	@Given("^we place a player (\\d+) piece (\\d+) called (\\d+) at \\((\\d+), (\\d+)\\)$")
	public void we_place_a_player_piece_called_at(int player, int pieceValue, int pieceName, int x, int y)
			throws Throwable {
		Piece piece = new Piece(pieceValue, player);
		try {
			this.board.placePiece(x, y, piece);
		} catch (Exception e) {
			this.errors.add(e);
		}
		this.pieces.add(piece);
	}

	@Given("^it is not the beginning of the game$")
	public void it_is_not_the_beginning_of_the_game() throws Throwable {
		this.board.setBeginning(false);
	}

	@Given("^we move a piece from \\((\\d+), (\\d+)\\) to \\((\\d+), (\\d+)\\)$")
	public void we_move_a_piece_from_to(int x1, int y1, int x2, int y2) throws Throwable {
		try {
			this.game.makeMove(x1, y1, x2, y2);
		} catch (Exception e) {
			this.errors.add(e);
		}
	}
	
	@Test
	@Then("^we should receive an error message that says \"(.*?)\"$")
	public void we_should_receive_an_error_message_that_says(String message) throws Throwable {
		boolean found = false;
		for (Exception e : errors) {
			if (e.getMessage().equals(message)) {
				found = true;
			}
		}
		Assert.assertTrue(found);
	}

	@Test
	@Then("^there should be no piece at \\((\\d+), (\\d+)\\)$")
	public void there_should_be_no_piece_at(int x, int y) throws Throwable {
		Assert.assertEquals(null, this.board.getPieces()[x][y]);
	}
	
	@Test
	@Then("^piece (\\d+) should be at \\((\\d+), (\\d+)\\)$")
	public void piece_should_be_at(int pieceName, int x, int y) throws Throwable {
		Piece piece = this.pieces.get(pieceName);
		Assert.assertEquals(piece, this.board.getPieces()[x][y]);
	}
}
