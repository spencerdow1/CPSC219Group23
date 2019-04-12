package Tests;
import Text.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import Logic.*;


/*Notes:
I cant find the old board class with whether black is upper case or white is upper case, double check

*/
public class PieceTest{
    /**
     * This tests the Piece constructor by initializing a new coordinate, then expects a pawn to return
     * from the getType method in the piece class.
     **/
	@Test
	public void testPieceTypeContructor(){
		Coord initializer = new Coord(3, 4);
		
		Piece wPawn = new Piece("pawn", "white", initializer, "P1");
		assertEquals("Expected piece type ot be pawn", "pawn", wPawn.getType());
		
		
	}
    /**
     * This tests the Piece constructor by initializing a new coordinate, then expects a pawn to return
     * from the getColor method in the piece class.
     **/
	@Test
	public void testPieceColourConstructor(){
		Coord initializer = new Coord(3, 4);
		
		Piece wPawn = new Piece("pawn", "white", initializer, "P1");
		assertEquals("Expected piece colour to be whilte", "white", wPawn.getColour());
	
	
	}

    /**
     * This tests the Piece constructor by initializing a new coordinate.
     * Compares the two objects to make sure the piece is in the correct spot.
     **/
	@Test
	public void testPieceCoordConstructor(){
		Coord initializer = new Coord(3, 4);
		
		Piece wPawn = new Piece("pawn", "white", initializer, "P1");
		
		
		assertEquals("Expected piece coord to be (3, 4)", true, initializer.equals(wPawn.getPosition()));
	
	
	}
    /**
     * This tests the Piece constructor by initializing a new coordinate. Then creates a new instance of piece
     * and tests the name by calling the getName method to make sure that the piece was initialized with the correct name
     **/
	@Test
	public void testPieceNameConstructor(){
		Coord initializer = new Coord(3, 4);
		
		Piece wPawn = new Piece("pawn", "white", initializer, "P1");
		assertEquals("Expected piece cname to be p1", "P1", wPawn.getName());
	
	
	}
    /**
     * Creates a new piece. Sets the type of piece to knight using the setType method then checks weather the
     * piece set equals knight.
     **/
	@Test
	public void testPieceGetterAndTypeSetter(){
		
		Piece wPawn = new Piece();
		wPawn.setType("knight");
		assertEquals("Expected piece type to be knight", "knight", wPawn.getType());
	
	}
    /**
     * Creates a new piece. Sets the color of the piece to black using the setter method.
     * Then calls the getter method to make sure it equals black.
     **/
	@Test
	public void testPieceColourGetterAndSetter(){
		
		Piece wPawn = new Piece();
		wPawn.setColour("black");
		
		assertEquals("Expected piece colour to be black", "black", wPawn.getColour());
	
	}
    /**
     * Creates a new piece. Sets the name of the piece to K4 using the setter method.
     * Then calls getName method to make sure it equals K4.
     **/
	@Test
	public void testPieceNameGetterAndSetter(){
		
		Piece wPawn = new Piece();
		wPawn.setName("K4");
		
		assertEquals("Expected piece name to be K4", "K4", wPawn.getName());
	
	}
    /**
     * Creates a new Cood and sets it to 3, 4. Creates a new piece. Sets the cood of the piece
     * to 3, 4 using the setPosition method. Then calls the getPosition method and tests to make sure
     * they are equal.
     **/
	@Test
	public void testPieceCoordGetterAndSetter(){
		Coord initializer = new Coord(3, 4);
		Piece wPawn = new Piece();
		wPawn.setPosition(initializer);
		//assertEquals("Expected piece position to be knight", true, wPawn.getPosition());
		assertEquals("Expected piece coord to be (3, 4)", true, initializer.equals(wPawn.getPosition()));
	}


}