
package Tests;
import Text.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import Logic.*;

public class AIPlayerTest{
    /**
     * Creates a new AIPlayer with difficulty 0 then tests to make sure the constructor
     * called the getDifficulty method and checks if it was set to the correct difficulty
     **/
	@Test
	public void TestConstructorDifficulty(){
		
		AIPlayer a = new AIPlayer(0);
		
		assertEquals("Expected the difficulty to be 0", 0, a.getDifficulty());
	}
    /**
     * Creates a new AIPlayer with difficulty 0 then calls the getName method and tests it with the expectation
     * of name Computer
     **/
	@Test
	public void TestConstructorName(){
		
		AIPlayer a = new AIPlayer(0);
		
		assertEquals("Expected the name to be Computer", "Computer", a.getName());
	}
    /**
     * Copy constructor tests the difficulty
     **/
	@Test
	public void TestCopyConstructorDifficulty(){
		
		AIPlayer a = new AIPlayer(1);
		AIPlayer b = new AIPlayer(a);
		
		assertEquals("Expected the difficulty to be 1", 1, b.getDifficulty());
	}
    /**
     * Copy constructor tests the name
     **/
	@Test
	public void TestCopyConstructorName(){
		
		AIPlayer a = new AIPlayer(1);
		AIPlayer b = new AIPlayer(a);
		
		assertEquals("Expected the difficulty to be Computer", "Computer", b.getName());
	}
    /**
     * Creates a new AIPlayer with difficulty 0 then sets the difficulty using the setDifficulty method
     * then tests it by calling the getDifficulty method and expects it to be 1
     **/
	@Test
	public void TestDifficultyGetterAndSetterInBounds(){
		
		AIPlayer a = new AIPlayer(0);
		
		a.setDifficulty(1);
		assertEquals("Expected the difficulty to be 1", 1, a.getDifficulty());
		
		
	}
    /**
     * Creates a new AIPlayer with difficulty 5 then sets the difficulty using the setDifficulty method
     * then tests it by calling the getDifficulty method and expects it to be 0
     **/
	@Test
	public void TestDifficultyGetterAndSetterOutOfBounds(){
		
		AIPlayer a = new AIPlayer(0);
		
		a.setDifficulty(5);
		assertEquals("Expected the difficulty to be 0", 0, a.getDifficulty());
		
		
	}





}