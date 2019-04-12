package Tests;
import Text.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import Logic.*;


public class DefaultGameSetTest{
	/**
	 * This test creates 14 game pieces for the defaultGameSet then adds them to an array list. Then creates
	 * another ArrayList and checks to see when the pieces match up. And tests this by expecting a number
	 **/
	@Test
	public void TestSettingBoardAsDefault(){
		
		ArrayList<Piece> test = new ArrayList<Piece>();
		test.add( new Piece("pawn", "white", new Coord(0, 1), "WP1") );
		test.add( new Piece("pawn", "white", new Coord(1, 0), "WP2") );
		test.add( new Piece("pawn", "white", new Coord(2, 0), "WP3") );
		test.add( new Piece("pawn", "white", new Coord(3, 0), "WP4") );
		test.add( new Piece("pawn", "white", new Coord(4, 1), "WP5") );
		test.add( new Piece("knight", "white", new Coord(0, 0), "WK1") );
		test.add( new Piece("knight", "white", new Coord(4, 0), "WK2") );   
		test.add( new Piece("pawn", "black", new Coord(0, 3), "BP1") );
		test.add( new Piece("pawn", "black", new Coord(1, 4), "BP2") );
		test.add( new Piece("pawn", "black", new Coord(2, 4), "BP3") );
		test.add( new Piece("pawn", "black", new Coord(3, 4), "BP4") );
		test.add( new Piece("pawn", "black", new Coord(4, 3), "BP5") );
		test.add( new Piece("knight", "black", new Coord(0, 4), "BK1") );
		test.add( new Piece("knight", "black", new Coord(4, 4), "BK2") );
		DefaultGameSet g = new DefaultGameSet();
		ArrayList<Piece> a = g.getGamePieces();
		
		int counter = 0;
		if(a.size() == 14){
		for(int i = 0 ; i < 14 ; i++){
			Piece j = new Piece();
			j = test.get(i);
			Piece k = new Piece();
			k = a.get(i);
			if(j == null && k == null){
					counter++;
					
				}else if(j.getType() == k.getType()){
					if(j.getName() == k.getName()){
						if(j.getColour() == k.getColour()){
						
						counter++;
						}
					}
				}
		}
		}
		assertEquals("The contructor did not add the arraylist correctly", 14, counter);
		
	}




}