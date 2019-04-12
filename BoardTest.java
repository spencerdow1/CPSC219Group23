
package Tests;
import Text.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import Logic.*;






public class BoardTest{
    /**
     * This test creates a gameBoard and a 5 x 5 2D list then iterates through
     * the gameBoard to make sure it is empty
     **/
	@Test
	public void TestBoardConstructor(){
		
		Board gameBoard = new Board();
		
		Piece[][] testBoard = new Piece[5][5];
		
		int counter = 0;
		for(int i = 0 ; i < 5 ; i++){

			for(int j = 0 ; j < 5 ; j++){
			
				Coord x = new Coord(i,j);
				Piece k = gameBoard.getPiece(x);
				if(testBoard[i][j] == k){
				counter++;
				}
			}
		}
		assertEquals("Expected board to be empty", 25, counter);

	}
    /**
     * This test creates a gameBoard and a 5 x 5 2D list then iterates through
     * the gameBoard to make sure it is filled with the correct starting pieces
     **/
	@Test
	public void TestBoardConstructorWithDefaultGameset(){
			//making the custom gameset 3
			DefaultGameSet g = new DefaultGameSet();
			Board gameBoard = new Board(g);
			
			//creating what the board should be
			Piece[][] testBoard = new Piece[5][5];
			testBoard[0][1] = new Piece("pawn", "white", new Coord(0, 1), "WP1");
			testBoard[1][0] = new Piece("pawn", "white", new Coord(1, 0), "WP2");
			
			Piece q = new Piece("pawn", "white", new Coord(2, 0), "WP3");
			testBoard[2][0] = q;
			
			Piece e = new Piece("pawn", "white", new Coord(3, 0), "WP4");
			testBoard[3][0] = e;
			
			Piece r = new Piece("pawn", "white", new Coord(4, 1), "WP5");
			testBoard[4][1] = r;
			
			Piece t = new Piece("knight", "white", new Coord(0, 0), "WK1");
			testBoard[0][0] = t;
			
			Piece y = new Piece("knight", "white", new Coord(4, 0), "WK2"); 
			testBoard[4][0] = y;	
			
			Piece u = new Piece("pawn", "black", new Coord(0, 3), "BP1");
			testBoard[0][3] = u;
			
			Piece o = new Piece("pawn", "black", new Coord(1, 4), "BP2");
			testBoard[1][4] = o;
			
			Piece a = new Piece("pawn", "black", new Coord(2, 4), "BP3");
			testBoard[2][4] = a;
			
			Piece d = new Piece("pawn", "black", new Coord(3, 4), "BP4");
			testBoard[3][4] = d;
			
			Piece f = new Piece("pawn", "black", new Coord(4, 3), "BP5");
			testBoard[4][3] = f;
			
			Piece l = new Piece("knight", "black", new Coord(0, 4), "BK1");
			testBoard[0][4] = l;
			
			Piece h = new Piece("knight", "black", new Coord(4, 4), "BK2");
			testBoard[4][4] = h;
			
			
			
			
			
			int counter = 0;
			
			for(int i = 0 ; i < 5 ; i++){

				for(int j = 0 ; j < 5 ; j++){
			
				Coord x = new Coord(i,j);
				Piece k = gameBoard.getPiece(x);
				
				if(testBoard[i][j] == null && k == null){
					counter++;
					
				}else if(testBoard[i][j].getType() == k.getType()){
					if(testBoard[i][j].getName() == k.getName()){
						if(testBoard[i][j].getColour() == k.getColour()){
						
						counter++;
						}
					}
				}
			
				}
		
			
		}
		
		assertEquals("Testing the correct default gameboard", 25, counter);
		
	}
    /**
     * creates a customGameSet, gameboard and a 5 x 5 2D list testBoard. Adds 2 pieces
     * to the testBoard then loops through the board to make sure it is correct
     **/
	@Test
	public void TestBoardConstructorWithCustomGameset3(){
		//add in the  game set
			CustomGameSet g = new CustomGameSet(3);
			Board gameBoard = new Board(g);
			
			
			Piece[][] testBoard = new Piece[5][5];
			Piece pawn1 = new Piece("pawn", "white", new Coord(2,1), "WP1");
			Piece pawn2 = new Piece("pawn", "black", new Coord(2,4), "BP1");
			testBoard[2][1] = pawn1;
			testBoard[2][4] = pawn2;
			
			int counter = 0;
			
			for(int i = 0 ; i < 5 ; i++){

				for(int j = 0 ; j < 5 ; j++){
			
				Coord x = new Coord(i,j);
				Piece k = gameBoard.getPiece(x);
				
				if(testBoard[i][j] == null && k == null){
					counter++;
					
				}else if(testBoard[i][j].getType() == k.getType()){
					if(testBoard[i][j].getName() == k.getName()){
						if(testBoard[i][j].getColour() == k.getColour()){
						
						counter++;
						}
					}
				}
			
				}
		
			
		}

		assertEquals("Testing the correct custom gameboard 3", 25, counter);
	}

	/**
	 * creates a customGameSet, gameboard and a 5 x 5 2D list testBoard. Adds 2 pieces
	 * to the testBoard then loops through the board to make sure it is correct
	 **/
	@Test
	public void TestBoardConstructorWithCustomGameset1(){
		//add in the  game set
			CustomGameSet g = new CustomGameSet(1);
			Board gameBoard = new Board(g);
			
			
			Piece[][] testBoard = new Piece[5][5];
			Piece whitePawn1 = new Piece("pawn", "white", new Coord(2,0), "p1");
			Piece blackPawn2 = new Piece("pawn", "black", new Coord(2,4), "P2");
			testBoard[2][0] = whitePawn1;
			testBoard[2][4] = blackPawn2;
			
			int counter = 0;
			
			for(int i = 0 ; i < 5 ; i++){

				for(int j = 0 ; j < 5 ; j++){
			
				Coord x = new Coord(i,j);
				Piece k = gameBoard.getPiece(x);
				
				if(testBoard[i][j] == null && k == null){
					counter++;
					
				}else if(testBoard[i][j].getType() == k.getType()){
					if(testBoard[i][j].getName() == k.getName()){
						if(testBoard[i][j].getColour() == k.getColour()){
						
						counter++;
						}
					}
				}
			
				}
		
			
		}

		assertEquals("Testing the correct custom gameboard 1", 25, counter);
	}
	/**
	 * creates a customGameSet, gameboard and a 5 x 5 2D list testBoard. Adds 2 pieces
	 * to the testBoard then loops through the board to make sure it is correct
	 **/
	@Test
	public void TestBoardConstructorWithCustomGameset2(){
		//add in the  game set
			CustomGameSet g = new CustomGameSet(2);
			Board gameBoard = new Board(g);
			
			
			Piece[][] testBoard = new Piece[5][5];
			Piece pawn1 = new Piece("pawn", "white", new Coord(2,2), "WP1");
			Piece pawn2 = new Piece("pawn", "black", new Coord(1,3), "BP1");
			Piece pawn3 = new Piece("pawn", "black", new Coord(3,3), "BP2");
			Piece knight1 = new Piece("knight", "white", new Coord(0,0), "WK1");
			
			testBoard[2][2] = pawn1;
			testBoard[1][3] = pawn2;
			testBoard[3][3] = pawn3;
			testBoard[0][0] = knight1;	
		
			int counter = 0;
			
			for(int i = 0 ; i < 5 ; i++){

				for(int j = 0 ; j < 5 ; j++){
			
				Coord x = new Coord(i,j);
				Piece k = gameBoard.getPiece(x);
				
				if(testBoard[i][j] == null && k == null){
					counter++;
					
				}else if(testBoard[i][j].getType() == k.getType()){
					if(testBoard[i][j].getName() == k.getName()){
						if(testBoard[i][j].getColour() == k.getColour()){
						
						counter++;
						}
					}
				}
			
				}
		
			
		}

		assertEquals("Testing the correct custom gameboard 2", 25, counter);
	}

	/**
	 * creates a customGameSet, gameboard and a 5 x 5 2D list testBoard. Adds 4 pieces
	 * to the testBoard then loops through the board to make sure it is correct
	 **/
	@Test
	public void TestBoardConstructorWithCustomGameset4(){
		//add in the  game set
			CustomGameSet g = new CustomGameSet(4);
			Board gameBoard = new Board(g);
			
			
			Piece[][] testBoard = new Piece[5][5];
			Piece pawn1 = new Piece("pawn", "white", new Coord(4,0), "WP1");
			Piece pawn2 = new Piece("pawn", "black", new Coord(4,1), "BP1");
			Piece knight3 = new Piece("knight", "white", new Coord(2,2), "WK2");
			Piece knight4 = new Piece("knight", "black", new Coord(0,4), "BK2");
			
			testBoard[4][0] = pawn1;
			testBoard[4][1] = pawn2;
			testBoard[2][2] = knight3;
			testBoard[0][4] = knight4;	
			
			
			int counter = 0;
			
			for(int i = 0 ; i < 5 ; i++){

				for(int j = 0 ; j < 5 ; j++){
			
				Coord x = new Coord(i,j);
				Piece k = gameBoard.getPiece(x);
				
				if(testBoard[i][j] == null && k == null){
					counter++;
					
				}else if(testBoard[i][j].getType() == k.getType()){
					if(testBoard[i][j].getName() == k.getName()){
						if(testBoard[i][j].getColour() == k.getColour()){
						
						counter++;
						}
					}
				}
			
				}
		
			
		}

		assertEquals("Testing the correct custom gameboard 4", 25, counter);
	}
	/**
	 * creates a customGameSet, gameboard and a 5 x 5 2D list testBoard. Adds 4 pieces
	 * to the testBoard then loops through the board to make sure it is correct
	 **/
	@Test
	public void TestBoardConstructorWithCustomGameset5(){
		//add in the  game set
			CustomGameSet g = new CustomGameSet(5);
			Board gameBoard = new Board(g);
			
			
			Piece[][] testBoard = new Piece[5][5];
			Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
			Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
			Piece knight3 = new Piece("knight", "white", new Coord(1,3), "WK2");
			Piece pawn4 = new Piece("pawn", "black", new Coord(1,4), "BP2");
			
			testBoard[0][3] = pawn1;
			testBoard[0][4] = pawn2;
			testBoard[1][3] = knight3;
			testBoard[1][4] = pawn4;

			
			int counter = 0;
			
			for(int i = 0 ; i < 5 ; i++){

				for(int j = 0 ; j < 5 ; j++){
			
				Coord x = new Coord(i,j);
				Piece k = gameBoard.getPiece(x);
				
				if(testBoard[i][j] == null && k == null){
					counter++;
					
				}else if(testBoard[i][j].getType() == k.getType()){
					if(testBoard[i][j].getName() == k.getName()){
						if(testBoard[i][j].getColour() == k.getColour()){
						
						counter++;
						}
					}
				}
			
				}
		
			
		}

		assertEquals("Testing the correct custom gameboard 4", 25, counter);
	}

	/**
	 * creates a customGameSet, gameboard and a 5 x 5 2D list testBoard. Creates a piece and sets it to position
	 * 0, 3 to make sure the setPiece function operates correctly
	 **/
	@Test
	public void TestBoardSetPiece1(){
		//add in the  game set
			
			Board gameBoard = new Board();
			Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
			Coord c = new Coord(0, 3);
			gameBoard.setPiece(pawn1, c);
			
			Piece[][] testBoard = new Piece[5][5];
			
			testBoard[0][3] = pawn1;
			
			int counter = 0;
			
			for(int i = 0 ; i < 5 ; i++){

				for(int j = 0 ; j < 5 ; j++){
			
				Coord x = new Coord(i,j);
				Piece k = gameBoard.getPiece(x);
				if(testBoard[i][j] == k){
				
				counter++;
				
					}
			
				}
		
	
		}

		assertEquals("Testing the set piece with 1 piece", 25, counter);
	}

	/**
	 * creates a customGameSet, gameboard and a 5 x 5 2D list testBoard. Creates 5 pieces and sets
	 * them on the board then checks to see if they were set properly
	 **/
	@Test
	public void TestBoardSetPiece5(){
		//add in the  game set
			
			Board gameBoard = new Board();
			//adding pawn1
			Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
			Coord c = new Coord(0, 3);
			gameBoard.setPiece(pawn1, c);
			//adding knight4
			Piece knight4 = new Piece("knight", "black", new Coord(0,4), "BK2");
			c = new Coord(0, 4);
			gameBoard.setPiece(knight4, c);
			//adding pawn2
			Piece pawn2 = new Piece("pawn", "black", new Coord(0,2), "BP1");
			c = new Coord(0, 2);
			gameBoard.setPiece(pawn2, c);
			//adding knight3
			Piece knight3 = new Piece("knight", "white", new Coord(1,3), "WK2");
			c = new Coord(1, 3);
			gameBoard.setPiece(knight3, c);
			//adding pawn4
			Piece pawn4 = new Piece("pawn", "black", new Coord(1,4), "BP2");
			c = new Coord(1, 4);
			gameBoard.setPiece(pawn4, c);
			
			Piece[][] testBoard = new Piece[5][5];
			
			testBoard[0][3] = pawn1;
			testBoard[0][4] = knight4;
			testBoard[0][2] = pawn2;
			testBoard[1][3] = knight3;
			testBoard[1][4] = pawn4;
			
			int counter = 0;
			
			for(int i = 0 ; i < 5 ; i++){

				for(int j = 0 ; j < 5 ; j++){
			
				Coord x = new Coord(i,j);
				Piece k = gameBoard.getPiece(x);
				if(testBoard[i][j] == k){
				
				counter++;
				
					}
			
				}
		
	
		}

		assertEquals("Testing the set piece with 5 pieces", 25, counter);
	}

	/**
	 * creates a customGameSet, gameboard and a 5 x 5 2D list testBoard. Creates a piece set to null and adds it
	 * to the board and checks that nothing happend
	 **/
	@Test
	public void TestBoardSetPiece(){
		//add in the  game set
			
			Board gameBoard = new Board();
			Piece pawn1;
			pawn1 = null;
			Coord c = new Coord(0, 3);
			gameBoard.setPiece(pawn1, c);
			
			Piece[][] testBoard = new Piece[5][5];
			
			testBoard[0][3] = pawn1;
			
			int counter = 0;
			
			for(int i = 0 ; i < 5 ; i++){

				for(int j = 0 ; j < 5 ; j++){
			
				Coord x = new Coord(i,j);
				Piece k = gameBoard.getPiece(x);
				if(testBoard[i][j] == k){
				
				counter++;
				
					}
			
				}
		
	
		}

		assertEquals("Testing the set piece with a null piece", 25, counter);
	}
	/**
	 * Tests the getter.
	 **/
	@Test
	public void TestBoardGetPiece(){
		//add in the  game set
			
			Board gameBoard = new Board();
			Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
			Coord c = new Coord(0, 3);
			gameBoard.setPiece(pawn1, c);
			Piece k = new Piece();
			k = gameBoard.getPiece(c);
			boolean w = false;
			
			if(k.getType() == "pawn"){
				if(k.getColour() == "white"){
					if(k.getName() == "WP1"){
						
						w = true;
					}
					
				}
				
			}
	

		assertEquals("Testing the set piece with a null piece", true, w);
	}

	/**
	 * Sets a piece on the board set to null the tests the board if it actually equals null
	 **/
	@Test
	public void TestBoardGetPieceWithNull(){
		//add in the  game set
			
			Board gameBoard = new Board();
			Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
			Coord c = new Coord(0, 3);
			pawn1 = null;
			gameBoard.setPiece(pawn1, c);
			Piece k = new Piece();
			k = gameBoard.getPiece(c);
	

		assertEquals("Testing the set piece with a null piece", null, k);
	}
	/**
	 * Tests to make sure the board is updating correctly by counting the correct placement
	 **/
	@Test
	public void TestUpdateBoard(){
			CustomGameSet g = new CustomGameSet(4);
			Board gameBoard = new Board(g);
			
			
			Piece[][] testBoard = new Piece[5][5];
			Piece pawn1 = new Piece("pawn", "white", new Coord(2,1), "WP1");
			Piece pawn2 = new Piece("pawn", "black", new Coord(2,4), "BP1");
			testBoard[2][1] = pawn1;
			testBoard[2][4] = pawn2;
			
			
			CustomGameSet z = new CustomGameSet(3);
			gameBoard.updateBoard(z);
			int counter = 0;
		
				for(int i = 0 ; i < 5 ; i++){

				for(int j = 0 ; j < 5 ; j++){
			
				Coord x = new Coord(i,j);
				Piece k = gameBoard.getPiece(x);
				
				if(testBoard[i][j] == null && k == null){
					counter++;
					
				}else if(testBoard[i][j].getType() == k.getType()){
					if(testBoard[i][j].getName() == k.getName()){
						if(testBoard[i][j].getColour() == k.getColour()){
						
						counter++;
						}
					}
				}
			
				}
		
			
		}

		assertEquals("Testing the correct custom gameboard 3", 25, counter);
		
		
	
	}

		
		
}
	
	
	
