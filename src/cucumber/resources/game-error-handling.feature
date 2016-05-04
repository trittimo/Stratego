Feature: GameErrorHandling
	As a User,
	When I do perform an invalid action
	I should receive a helpful error message

@GameErrorHandling
Scenario: Place Piece Outside Valid Range At Beginning Player 1
	Given we have an empty board
	And it is the beginning of the game
	And it is player 1 turn
	And we place a player 1 piece 1 called 0 at (1, 6)
	Then we should receive an error message that says "You cannot place a piece at (1, 6) - it is the beginning of the game"
	And there should be no piece at (1, 6)

Scenario: Place Piece On Another Piece
	Given we have an empty board
	And it is the beginning of the game
	And it is player 1 turn
	And we place a player 1 piece 1 called 0 at (1, 3)
	And we place a player 1 piece 1 called 1 at (1, 3)
	Then piece 0 should be at (1, 3)
	And we should receive an error message that says "You cannot place a piece at (1, 3) - this location is already occupied"

Scenario: Place Piece Outside Valid Range At Beginning Player 2
	Given we have an empty board
	And it is the beginning of the game
	And it is player 2 turn
	And we place a player 2 piece 1 called 0 at (1, 3)
	Then we should receive an error message that says "You cannot place a piece at (1, 3) - it is the beginning of the game"
	And there should be no piece at (1, 3)

Scenario: Move Piece On Another Piece
	Given we have an empty board
	And it is not the beginning of the game
	And it is player 1 turn
	And we place a player 1 piece 1 called 0 at (1, 2)
	And we place a player 1 piece 1 called 1 at (1, 3)
	And we move a piece from (1, 2) to (1, 3)
	Then piece 0 should be at (1, 2)
	And piece 1 should be at (1, 3)
	And we should receive an error message that says "You cannot move a piece from (1, 2) to (1, 3) since it is already occupied"

Scenario: Move Piece Too Far
	Given we have an empty board
	And it is not the beginning of the game
	And it is player 1 turn
	And we place a player 1 piece 1 called 0 at (1, 3)
	And we move a piece from (1, 3) to (1, 5)
	Then piece 0 should be at (1, 3)
	And we should receive an error message that says "You cannot move a piece from (1, 3) to (1, 5) since it is too far for that piece to move"