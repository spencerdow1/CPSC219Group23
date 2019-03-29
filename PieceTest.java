import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;


/*Notes:
I cant find the old board class with whether black is upper case or white is upper case, double check

*/
public class PieceTest{

		
	@Test
	public void testPieceTypeContructor(){
		Coord initializer = new Coord(3, 4);
		
		Piece wPawn = new Piece("pawn", "white", initializer, "P1");
		assertEquals("Expected piece type ot be pawn", "pawn", wPawn.getType());
		
		
	}
	
	@Test
	public void testPieceColourConstructor(){
		Coord initializer = new Coord(3, 4);
		
		Piece wPawn = new Piece("pawn", "white", initializer, "P1");
		assertEquals("Expected piece colour to be whilte", "white", wPawn.getColour());
	
	
	}
	//How do I test that the cord is right?
	@Test
	public void testPieceCoordConstructor(){
		Coord initializer = new Coord(3, 4);
		
		Piece wPawn = new Piece("pawn", "white", initializer, "P1");
		
		
		assertEquals("Expected piece coord to be (3, 4)", true, initializer.equals(wPawn.getPosition()));
	
	
	}
	
	@Test
	public void testPieceNameConstructor(){
		Coord initializer = new Coord(3, 4);
		
		Piece wPawn = new Piece("pawn", "white", initializer, "P1");
		assertEquals("Expected piece cname to be p1", "P1", wPawn.getName());
	
	
	}
	
	@Test
	public void testPieceGetterAndTypeSetter(){
		
		Piece wPawn = new Piece();
		wPawn.setType("knight");
		assertEquals("Expected piece type to be knight", "knight", wPawn.getType());
	
	}
	
	@Test
	public void testPieceColourGetterAndSetter(){
		
		Piece wPawn = new Piece();
		wPawn.setColour("black");
		
		assertEquals("Expected piece colour to be black", "black", wPawn.getColour());
	
	}

	@Test
	public void testPieceNameGetterAndSetter(){
		
		Piece wPawn = new Piece();
		wPawn.setName("K4");
		
		assertEquals("Expected piece name to be K4", "K4", wPawn.getName());
	
	}
	
	@Test
	public void testPieceCoordGetterAndSetter(){
		Coord initializer = new Coord(3, 4);
		Piece wPawn = new Piece();
		wPawn.setPosition(initializer);
		//assertEquals("Expected piece position to be knight", true, wPawn.getPosition());
		assertEquals("Expected piece coord to be (3, 4)", true, initializer.equals(wPawn.getPosition()));
	}


}