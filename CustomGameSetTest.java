package Tests;
import Text.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import Logic.*;

public class CustomGameSetTest{
    /**
     * This test creates 3 game pieces then adds them to an array list. Then creates
     * an ArrayList from a CustomGameSet. It tests to make sure the array was added correctly
     * by counting when the pieces are the same.
     **/
	@Test
	public void TestConstructorArray(){
		
		ArrayList<Piece> test = new ArrayList<Piece>();
		test.add(new Piece("pawn", "white", new Coord(0, 1), "WP1") );
		test.add( new Piece("pawn", "white", new Coord(1, 0), "WP2") );
		test.add( new Piece("pawn", "white", new Coord(2, 0), "WP3") );
		
		CustomGameSet g = new CustomGameSet(test);
		
		ArrayList<Piece> a = g.getGamePieces();
		
		int counter = 0;
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
		assertEquals("The contructor did not add the arraylist correctly", 3, counter);
	}
    /**
     * This test creates 2 game pieces then adds them to an array list. Then creates
     * an ArrayList from a CustomGameSet. It tests to make sure the array was added correctly
     * by counting when the pieces are the same.
     **/
	@Test
	public void TestConstructorAndCustomSet1(){
		CustomGameSet g = new CustomGameSet(1);
		ArrayList<Piece> test = new ArrayList<Piece>();
        Piece whitePawn1 = new Piece("pawn", "white", new Coord(2,0), "p1");
        Piece blackPawn2 = new Piece("pawn", "black", new Coord(2,4), "P2");
		test.add(whitePawn1);
        test.add(blackPawn2);
		
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
		assertEquals("The contructor did not add the arraylist correctly", 2, counter);
		
	}
    /**
     *
     **/
	@Test
	public void TestConstructorIntOutBounds(){
		CustomGameSet g = new CustomGameSet(6);
		ArrayList<Piece> a = g.getGamePieces();
		int counter = 0;
		if(a.size() > 0){
			counter++;
			
		}
		assertEquals("The contructor did not add the arraylist correctly", 0, counter);
		
	}
    /**
     * This test creates 4 game pieces then adds them to an array list. Then creates
     * an ArrayList from a CustomGameSet. It tests to make sure the array was added correctly
     * by counting when the pieces are the same.
     **/
	@Test
	public void TestConstructorAndCustomSet2(){
		CustomGameSet g = new CustomGameSet(2);
		ArrayList<Piece> test = new ArrayList<Piece>();
        Piece pawn1 = new Piece("pawn", "white", new Coord(2,2), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(1,3), "BP1");
        Piece pawn3 = new Piece("pawn", "black", new Coord(3,3), "BP2");
        Piece knight1 = new Piece("knight", "white", new Coord(0,0), "WK1");
        test.add(pawn1);
        test.add(pawn2);
        test.add(pawn3);
        test.add(knight1);
		
		ArrayList<Piece> a = g.getGamePieces();
		
		int counter = 0;
		if(a.size() == 4){
		for(int i = 0 ; i < 4 ; i++){
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
		assertEquals("The contructor did not add the arraylist correctly", 4, counter);
		
	}
    /**
     * This test creates 2 game pieces then adds them to an array list. Then creates
     * an ArrayList from a CustomGameSet. It tests to make sure the array was added correctly
     * by counting when the pieces are the same.
     **/
	@Test
	public void TestConstructorAndCustomSet3(){
		CustomGameSet g = new CustomGameSet(3);
		ArrayList<Piece> test = new ArrayList<Piece>();
		Piece pawn1 = new Piece("pawn", "white", new Coord(2,1), "WP1");
    	Piece pawn2 = new Piece("pawn", "black", new Coord(2,4), "BP1");
    	test.add(pawn1);
    	test.add(pawn2);
		
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
		assertEquals("The contructor did not add the arraylist correctly", 2, counter);
		
	}
    /**
     * This test creates 4 game pieces then adds them to an array list. Then creates
     * an ArrayList from a CustomGameSet. It tests to make sure the array was added correctly
     * by counting when the pieces are the same.
     **/
	@Test
	public void TestConstructorAndCustomSet4(){
		CustomGameSet g = new CustomGameSet(4);
		ArrayList<Piece> test = new ArrayList<Piece>();
		Piece pawn1 = new Piece("pawn", "white", new Coord(4,0), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(4,1), "BP1");
        Piece knight3 = new Piece("knight", "white", new Coord(2,2), "WK2");
        Piece knight4 = new Piece("knight", "black", new Coord(0,4), "BK2");
        test.add(pawn1);
        test.add(pawn2);
        test.add(knight3);
        test.add(knight4);
		
		ArrayList<Piece> a = g.getGamePieces();
		
		int counter = 0;
		if(a.size() == 4){
		for(int i = 0 ; i < 4 ; i++){
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
		assertEquals("The contructor did not add the arraylist correctly", 4, counter);
		
	}
    /**
     * This test creates 4 game pieces then adds them to an array list. Then creates
     * an ArrayList from a CustomGameSet. It tests to make sure the array was added correctly
     * by counting when the pieces are the same.
     **/
	@Test
	public void TestConstructorAndCustomSet5(){
		CustomGameSet g = new CustomGameSet(5);
		ArrayList<Piece> test = new ArrayList<Piece>();
		Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
        Piece knight3 = new Piece("knight", "white", new Coord(1,3), "WK2");
        Piece pawn4 = new Piece("pawn", "black", new Coord(1,4), "BP2");
        test.add(pawn1);
        test.add(pawn2);
        test.add(knight3);
        test.add(pawn4);
		
		ArrayList<Piece> a = g.getGamePieces();
		
		int counter = 0;
		if(a.size() == 4){
		for(int i = 0 ; i < 4 ; i++){
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
		assertEquals("The contructor did not add the arraylist correctly", 4, counter);
		
	}
    /**
     * This test creates 1 game pieces then adds them to an array list. Then creates
     * an ArrayList from a CustomGameSet. It tests to make sure the array was added correctly
     * by counting when the pieces are the same.
     **/
	@Test
	public void TestConstructorOnePiece(){
		Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
		
		CustomGameSet g = new CustomGameSet(pawn1);
		ArrayList<Piece> test = new ArrayList<Piece>();
        test.add(pawn1);
		
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
		assertEquals("The contructor did not add the piece correctly", 1, counter);
		
	}
    /**
     * This test creates 2 game pieces then adds them to an array list. Then creates
     * an ArrayList from a CustomGameSet. It tests to make sure the array was added correctly
     * by counting when the pieces are the same.
     **/
	@Test
	public void TestConstructorTwoPiece(){
		Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
		Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
		CustomGameSet g = new CustomGameSet(pawn1, pawn2);
		ArrayList<Piece> test = new ArrayList<Piece>();
        test.add(pawn1);
		test.add(pawn2);
		
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
		assertEquals("The contructor did not add the piece correctly", 2, counter);
		
	}
    /**
     * This test creates 3 game pieces then adds them to an array list. Then creates
     * an ArrayList from a CustomGameSet. It tests to make sure the array was added correctly
     * by counting when the pieces are the same.
     **/
	@Test
	public void TestConstructorThreePiece(){
		Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
		Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
		Piece knight3 = new Piece("knight", "white", new Coord(1,3), "WK2");
		CustomGameSet g = new CustomGameSet(pawn1, pawn2, knight3);
		ArrayList<Piece> test = new ArrayList<Piece>();
        test.add(pawn1);
		test.add(pawn2);
		test.add(knight3);
		
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
		assertEquals("The contructor did not add the piece correctly", 3, counter);
		
	}
    /**
     * This test creates 4 game pieces then adds them to an array list. Then creates
     * an ArrayList from a CustomGameSet. It tests to make sure the array was added correctly
     * by counting when the pieces are the same.
     **/
	@Test
	public void TestConstructorFourPiece(){
		Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
		Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
		Piece knight3 = new Piece("knight", "white", new Coord(1,3), "WK2");
		Piece pawn4 = new Piece("pawn", "black", new Coord(1,4), "BP2");
		CustomGameSet g = new CustomGameSet(pawn1, pawn2, knight3, pawn4);
		ArrayList<Piece> test = new ArrayList<Piece>();
        test.add(pawn1);
		test.add(pawn2);
		test.add(knight3);
		test.add(pawn4);
		
		ArrayList<Piece> a = g.getGamePieces();
		
		int counter = 0;
		if(a.size() == 4){
		for(int i = 0 ; i < 4 ; i++){
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
		assertEquals("The contructor did not add the piece correctly", 4, counter);
		
	}

	

}


