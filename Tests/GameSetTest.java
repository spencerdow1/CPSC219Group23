
package Tests;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import Logic.*;

public class GameSetTest{

	@Test
	/**
	 * Tests the addPiece and adds one pawn. Tests by counting they are in the proper spots.
	 */
	public void TestAddPiece1(){
		CustomGameSet g = new CustomGameSet(3);
		ArrayList<Piece> test = new ArrayList<Piece>();
		Piece pawn1 = new Piece("pawn", "white", new Coord(2,1), "WP1");
    	Piece pawn2 = new Piece("pawn", "black", new Coord(2,4), "BP1");
    	test.add(pawn1);
    	test.add(pawn2);
		Piece pawn3 = new Piece("pawn", "black", new Coord(3, 1), "BP3");
		g.addPiece(pawn3);
		test.add(pawn3);
		ArrayList<Piece> a = g.getGamePieces();
		
		int counter = 0;
		if(a.size() == 3){
		for(int i = 0 ; i < 3 ; i++){
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
		assertEquals("Should have added a piece", 3, counter);
	
	}
	
	
	@Test
	/**
	 * Tests the addPiece and adds three pawns. Tests by counting they are in the proper spots.
	 */
	public void TestAddPiece3(){
		CustomGameSet g = new CustomGameSet(3);
		ArrayList<Piece> test = new ArrayList<Piece>();
		Piece pawn1 = new Piece("pawn", "white", new Coord(2,1), "WP1");
    	Piece pawn2 = new Piece("pawn", "black", new Coord(2,4), "BP1");
    	test.add(pawn1);
    	test.add(pawn2);
		Piece pawn3 = new Piece("pawn", "white", new Coord(3, 1), "BP3");
		Piece pawn4 = new Piece("pawn", "black", new Coord(4, 0), "BP3");
		Piece pawn5 = new Piece("pawn", "black", new Coord(2, 2), "BP3");
		g.addPiece(pawn3);
		g.addPiece(pawn4);
		g.addPiece(pawn5);
		test.add(pawn3);
		test.add(pawn4);
		test.add(pawn5);
		ArrayList<Piece> a = g.getGamePieces();
		
		int counter = 0;
		if(a.size() == 5){
		for(int i = 0 ; i < 5 ; i++){
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
		assertEquals("Should have added a piece", 5, counter);
		
	
	}
	
	@Test
	/**
	 * Tests the getSize method
	 */
	public void TestGetSizeNothingInIt(){
		ArrayList<Piece> test = new ArrayList<Piece>();
		CustomGameSet g = new CustomGameSet(test);
		
		assertEquals("The size was incorrect", 0, g.getSize());
	
	}
	/**
	 * Tests the getSize method
	 */
	@Test
	public void TestGetSize(){
		CustomGameSet g = new CustomGameSet(3);
		
		
		
		assertEquals("The size was Incorrecrt", 2, g.getSize());
	
	}
	/**
	 * Tests the removePiece method
	 */
	@Test
	public void TestRemovePiece(){
		CustomGameSet g = new CustomGameSet(3);
		ArrayList<Piece> test = new ArrayList<Piece>();
		Piece pawn1 = new Piece("pawn", "white", new Coord(2,1), "WP1");
    	Piece pawn2 = new Piece("pawn", "black", new Coord(2,4), "BP1");
    	test.add(pawn1);
		g.removePiece(1);
		ArrayList<Piece> a = g.getGamePieces();
		
		int counter = 0;
		if(a.size() == 1){
		for(int i = 0 ; i < 1 ; i++){
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
		assertEquals("Did not remove Piece correctly", 1, counter);
		
	
	}
	/**
	 * Tests the removePiece method with multiple pieces
	 */
	@Test
	public void TestRemovePieces(){
		CustomGameSet g = new CustomGameSet(5);
		ArrayList<Piece> test = new ArrayList<Piece>();
		Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
        Piece knight3 = new Piece("knight", "white", new Coord(1,3), "WK2");
        Piece pawn4 = new Piece("pawn", "black", new Coord(1,4), "BP2");
        test.add(pawn1);
        test.add(pawn4);
		g.removePieces(1, 2);
		ArrayList<Piece> a = g.getGamePieces();
		
		int counter = 0;
		if(a.size() == 2){
		for(int i = 0 ; i < 2 ; i++){
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
		assertEquals("Did not remove the pieces correctly", 2, counter);
		
	
	}
	/**
	 * Tests the getWhite piece method
	 */
	@Test
	public void TestGetWhitePieces(){
		CustomGameSet g = new CustomGameSet(5);
		ArrayList<Piece> test = new ArrayList<Piece>();
		Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
        Piece knight3 = new Piece("knight", "white", new Coord(1,3), "WK2");
        Piece pawn4 = new Piece("pawn", "black", new Coord(1,4), "BP2");
        test.add(pawn1);
        test.add(knight3);
		//g.getWhitePieces();
		ArrayList<Piece> a = g.getWhitePieces();
		
		int counter = 0;
		if(a.size() == 2){
		for(int i = 0 ; i < 2 ; i++){
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
		assertEquals("Incorrect list of white pieces", 2, counter);
		
	
	}
	//debug this
	/**
	 * Tests the getBlackPiece method
	 */
	@Test
	public void TestGetBlackPieces(){
		CustomGameSet g = new CustomGameSet(5);
		ArrayList<Piece> test = new ArrayList<Piece>();
		Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
        Piece knight3 = new Piece("knight", "white", new Coord(1,3), "WK2");
        Piece pawn4 = new Piece("pawn", "black", new Coord(1,4), "BP2");
        test.add(pawn2);
		test.add(pawn4);
		//g.getWhitePieces();
		ArrayList<Piece> a = g.getBlackPieces();
		
		int counter = 0;
		if(a.size() == 2){
		for(int i = 0 ; i < 2 ; i++){
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
		assertEquals("Incorrect list of black pieces", 2, counter);
	}
	/**
	 * Tests the setWhiteBlackPieces method
	 */
	@Test
	public void TestSetWhiteBlackPieces(){
		CustomGameSet g = new CustomGameSet(5);
		ArrayList<Piece> testb = new ArrayList<Piece>();
		ArrayList<Piece> testw = new ArrayList<Piece>();
		ArrayList<Piece> p = new ArrayList<Piece>();
		Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
        Piece knight3 = new Piece("knight", "white", new Coord(1,3), "WK2");
        Piece pawn4 = new Piece("pawn", "black", new Coord(1,4), "BP2");
		Piece p1 = new Piece("pawn", "white", new Coord(2,1), "WP1");
    	Piece p2 = new Piece("pawn", "black", new Coord(2,4), "BP1");
    	testw.add(pawn1);
        testb.add(pawn2);
		testb.add(pawn4);
		testw.add(knight3);
		testw.add(p1);
		testb.add(p2);
		p.add(p1);
		p.add(p2);
		g.setWhiteAndBlackPieces(p);
		//g.getWhitePieces();
		ArrayList<Piece> b = g.getBlackPieces();
		ArrayList<Piece> w = g.getWhitePieces();
		
		int counter = 0;
		if(b.size() == 3){
		for(int i = 0 ; i < 3 ; i++){
			Piece j = new Piece();
			j = testb.get(i);
			Piece k = new Piece();
			k = b.get(i);
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

		if(w.size() == 3){
		for(int i = 0 ; i < 3 ; i++){
			Piece j = new Piece();
			j = testw.get(i);
			Piece k = new Piece();
			k = w.get(i);
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
		assertEquals("Incorrect list of white and black pieces", 6, counter);
		}
		
	}
	/**
	 * Tests the default to string method
	 */
	@Test
	public void TestDefaultToString(){
		CustomGameSet g = new CustomGameSet(5);
		ArrayList<Piece> test = new ArrayList<Piece>();
		String s = g.toString();
		String i = "WP1, BP1, WK2, BP2";
		
		assertEquals("Expected the String to be the same", i, s);
		
	}

	/**
	 * Tests the arraytostring method
	 */
	@Test
	public void TestArrayToString(){
		CustomGameSet g = new CustomGameSet(5);
		ArrayList<Piece> test = new ArrayList<Piece>();
		Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
        Piece knight3 = new Piece("knight", "white", new Coord(1,3), "WK2");
        Piece pawn4 = new Piece("pawn", "black", new Coord(1,4), "BP2");
		Piece p1 = new Piece("pawn", "white", new Coord(2,1), "WP1");
    	Piece p2 = new Piece("pawn", "black", new Coord(2,4), "BP1");
    	test.add(pawn1);
        test.add(pawn2);
		test.add(knight3);
		test.add(pawn4);
		test.add(p1);
		test.add(p2);
		String s = g.toString(test);
		String i = "WP1, BP1, WK2, BP2, WP1, BP1";
		
		assertEquals("Expected the String to be the same", i, s);
		
	}
	/**
	 * Tests the getPieceByCoord method
	 */
	@Test
	public void TestGetPieceByCoord(){
		CustomGameSet g = new CustomGameSet(5);
		Coord c = new Coord(0, 4);
		Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
		Piece j = new Piece();
		j = g.getPieceByCoord(c);
		boolean b = false;
		if(j == null && pawn2 == null){
					b = true;
					
				}else if(j.getType() == pawn2.getType()){
					if(j.getName() == pawn2.getName()){
						if(j.getColour() == pawn2.getColour()){
						
						b = true;
						}
					}
				}
		
		assertEquals("Obtained the incorrected piece", true, b);
	}

	/**
	 * tests the getPieceIndexByCoord method
	 */
	@Test
	public void TestGetPieceIndexByCoord(){
		CustomGameSet g = new CustomGameSet(5);
		Coord c = new Coord(0, 4);
		Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
		int j = g.getPieceIndexByCoord(c);

		
		assertEquals("Obtained the incorrected piece", 1, j);
	}



}