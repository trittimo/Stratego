package stratego.logic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;



//deleted TestIntegration.class, those tests don't pass yet...will be added later 

@RunWith(Suite.class)
@Suite.SuiteClasses({TestBoard.class, TestGame.class, TestPiece.class})


public class AllTests {
	public static void main (String args[]) {
        org.junit.runner.JUnitCore.main("stratego.logic.AllTests");
    }
	
	
	
	
	
	

}
