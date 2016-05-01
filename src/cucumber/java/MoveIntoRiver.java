import org.junit.Assert;

import stratego.logic.Board;
import stratego.logic.Game;
import stratego.logic.Piece;
import stratego.logic.exceptions.InvalidMovement;
import stratego.logic.exceptions.InvalidPiece;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MoveIntoRiver{
	
	public MoveIntoRiver(){
		
	}
	Board b = null;
	Game g = null;
	@Given("^I have an empty Board$")
	public void i_have_an_empty_Board() {
	    // Write code here that turns the phrase above into concrete actions
	    Piece[][] pieces = new Piece[10][10];
	    b = new Board(pieces);
	    g = new Game(b);
	}
	
	@Given("^I have a piece next to a river$")
	public void i_have_a_piece_next_to_a_river() {
	    // Write code here that turns the phrase above into concrete actions
		Piece p = new Piece(3, 1);
		System.out.println(p);
	    b.placePiece(2, 3, p);
	}
	
	@When("^I try to move into the river$")
	public void i_try_to_move_into_the_river() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(b.getPiece(2, 3));
		try {
			b.movePiece(2, 3, 2, 4);
			Assert.fail("Movement into the river is not allowed");
		}catch (InvalidMovement e){
			
		}
	    
	}
	
	@Then("^I should not be allowed to$")
	public void i_should_not_be_allowed_to() {
	    // Write code here that turns the phrase above into concrete actions
		try{
			b.getPiece(2, 3);
		}catch (InvalidPiece e){
			Assert.fail("the piece should not have moved");
		}
		Assert.assertNotNull(b.getPiece(2, 3));
	    
	}
}
