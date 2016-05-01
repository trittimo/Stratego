Feature: MoveInToRiver
	
@mytag
Scenario: Add two numbers
	Given I have an empty Board
	And I have a piece next to a river
	When I try to move into the river
	Then I should not be allowed to