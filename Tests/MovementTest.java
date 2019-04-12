package Tests;
import Text.*;
import org.junit.Test;
import Logic.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MovementTest {

    /**
     * This test creates two coordinates and a piece pawn and moves the piece to test that the move is legal.
     * This test returns true because the move was legal
     **/
    @Test
    public void TestLegalMoveTruePawnEmptySpot() {
        GameDynamics game = new GameDynamics();
        Board gameBoard = new Board();
        Piece whitePawn1 = new Piece("pawn", "white", new Coord(2, 0), "p1");
        Piece blackPawn2 = new Piece("pawn", "black", new Coord(2, 4), "P2");
        Coord c = new Coord(2, 0);
        gameBoard.setPiece(whitePawn1, c);
        c = new Coord(2, 4);
        gameBoard.setPiece(blackPawn2, c);
        boolean d = false;
        c = new Coord(2, 3);
        d = game.legalMove(blackPawn2, gameBoard, c);
        assertEquals("Expected move to be legal", true, d);
    }
    /**
     * This test creates two coordinates and a piece pawn and moves the piece to test that the move is legal.
     * This test returns false because the move was illegal
     **/
    @Test
    public void TestLegalMoveFalsePawn() {
        GameDynamics game = new GameDynamics();
        Board gameBoard = new Board();
        Piece whitePawn1 = new Piece("pawn", "white", new Coord(2, 0), "p1");
        Piece blackPawn2 = new Piece("pawn", "black", new Coord(2, 1), "P2");
        Coord c = new Coord(2, 0);
        gameBoard.setPiece(whitePawn1, c);
        c = new Coord(2, 1);
        gameBoard.setPiece(blackPawn2, c);
        boolean d = false;
        c = new Coord(2, 0);
        d = game.legalMove(blackPawn2, gameBoard, c);
        assertEquals("Expected move to be illegal", false, d);
    }
    /**
     * This test creates two coordinates and a piece pawn and moves the piece to test that the move is legal.
     * This test returns false because the move was illegal
     **/
    @Test
    public void TestLegalMoveFalsePawnEmptySpot() {
        GameDynamics game = new GameDynamics();
        Board gameBoard = new Board();
        Piece whitePawn1 = new Piece("pawn", "white", new Coord(2, 0), "p1");
        Piece blackPawn2 = new Piece("pawn", "black", new Coord(2, 4), "P2");
        Coord c = new Coord(2, 0);
        gameBoard.setPiece(whitePawn1, c);
        c = new Coord(2, 4);
        gameBoard.setPiece(blackPawn2, c);
        boolean d = false;
        c = new Coord(1, 0);
        d = game.legalMove(blackPawn2, gameBoard, c);
        assertEquals("Expected move to be illegal", false, d);
    }
    /**
     * This test creates two coordinates and a piece knight and moves the piece to test that the move is legal.
     * This test returns false because the move was illegal
     **/
    @Test
    public void TestLegalMoveFalseKnightEmptySpot() {
        GameDynamics game = new GameDynamics();
        Board gameBoard = new Board();
        Piece whiteKnight1 = new Piece("knight", "white", new Coord(2, 0), "p1");
        Piece blackKnight2 = new Piece("knight", "black", new Coord(2, 4), "P2");
        Coord c = new Coord(2, 0);
        gameBoard.setPiece(whiteKnight1, c);
        c = new Coord(2, 4);
        gameBoard.setPiece(blackKnight2, c);
        boolean d = false;
        c = new Coord(1, 0);
        d = game.legalMove(blackKnight2, gameBoard, c);
        assertEquals("Expected move to be legal", false, d);
    }
    /**
     * This test creates two coordinates and a piece knight and moves the piece to test that the move is legal.
     * This test returns true because the move was legal
     **/
    @Test
    public void TestLegalMoveTrueKnightEmptySpot() {
        GameDynamics game = new GameDynamics();
        Board gameBoard = new Board();
        Piece whiteKnight1 = new Piece("knight", "white", new Coord(2, 0), "p1");
        Piece blackKnight2 = new Piece("knight", "black", new Coord(2, 4), "P2");
        Coord c = new Coord(2, 0);
        gameBoard.setPiece(whiteKnight1, c);
        c = new Coord(2, 4);
        gameBoard.setPiece(blackKnight2, c);
        boolean d = false;
        c = new Coord(3, 2);
        d = game.legalMove(blackKnight2, gameBoard, c);
        assertEquals("Expected move to be legal", true, d);
    }
    /**
     * This test creates three coordinates two of which are legal and one illegal and puts them in an array.
     * This then compares the array with a new array with only legal moves. Creates a counter that counts if
     * the two arrays are the same. And tests that the counter equals 2.
     *
     **/
    @Test
    public void pawnAllowedMovesTest1() {
        Coord c = new Coord(0, 2);
        Coord c1 = new Coord(1,2);
        Coord c2 = new Coord(2,2);
        ArrayList<Coord> fake = new ArrayList<Coord>();
        ArrayList<Coord> tester = new ArrayList<Coord>();
        tester.add(c);
        tester.add(c1);

        fake.add(c);
        fake.add(c1);
        fake.add(c2);
        Piece pawn1 = new Piece("pawn", "white", new Coord(1,1), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(0,2), "BP1");
        Piece pawn3 = new Piece("pawn", "white", new Coord(2,2), "BP2");
        Movement m = new Movement();
        CustomGameSet game = new CustomGameSet(pawn1, pawn2, pawn3);
        Board board = new Board(game);
        ArrayList<Coord> array = m.allowedMoves(pawn1, board, fake );

        System.out.println(array);
        int counter = 0;
        if(array.size() == 2){
            for(int i = 0 ; i < 2 ; i++){
                Coord j = new Coord();
                j = tester.get(i);
                Coord k = new Coord();
                k = array.get(i);
                if(j == null && k == null){
                    counter++;

                }else if(j.equals(k)){
                            counter++;
                }
            }
        }
        assertEquals("Incorrect allowed moves", 2, counter);
    }
    /**
     * This test creates three coordinates 6 of which are legal and two illegal and puts them in an array.
     * This then compares the array with a new array with only legal moves. Creates a counter that counts if
     * the two arrays are the same. And tests that the counter equals 4.
     *
     **/
    @Test
    public void knightAllowedMovesTest2() {
        Coord c = new Coord(0, 0);
        Coord c1 = new Coord(0,2);
        Coord c2 = new Coord(1,3);
        Coord c3 = new Coord(3, 3);
        Coord c4 = new Coord(4,2);
        Coord c5 = new Coord(4,0);
        ArrayList<Coord> fake = new ArrayList<Coord>();
        ArrayList<Coord> tester = new ArrayList<Coord>();
        tester.add(c1);
        tester.add(c3);
        tester.add(c4);
        tester.add(c5);

        fake.add(c);
        fake.add(c1);
        fake.add(c2);
        fake.add(c3);
        fake.add(c4);
        fake.add(c5);

        Piece pawn2 = new Piece("pawn", "black", new Coord(3,3), "BP1");
        Piece pawn1 = new Piece("Knight", "white", new Coord(2,1), "WK1");
        Piece pawn3 = new Piece("pawn", "white", new Coord(1,3), "WP2");
        Piece pawn4 = new Piece("pawn", "white", new Coord(0,0), "WP2");
        Movement m = new Movement();
        CustomGameSet game = new CustomGameSet(pawn1, pawn2, pawn3, pawn4);
        Board board = new Board(game);
        ArrayList<Coord> array = m.allowedMoves(pawn1, board, fake );

        System.out.println(array);
        int counter = 0;
        if(array.size() == 4){
            for(int i = 0 ; i < 4 ; i++){
                Coord j = new Coord();
                j = tester.get(i);
                Coord k = new Coord();
                k = array.get(i);
                if(j == null && k == null){
                    counter++;

                }else if(j.equals(k)){
                    counter++;
                }
            }
        }
        assertEquals("Incorrect allowed moves", 4, counter);
    }
    /**
     * Tests illegal coord and make checks to make sure that it is false.
     **/
    @Test
    public void notWithinBoardTest(){
        Coord c = new Coord(-1, -1);
        Movement move = new Movement();
        boolean b = move.withinBoard(c);
        assertEquals("not within board", false, b);
    }
    /**
     * Tests legal coord and make checks to make sure that it is true.
     **/
    @Test
    public void withinBoardTest(){
        Coord c = new Coord(4, 4);
        Movement move = new Movement();
        boolean b = move.withinBoard(c);
        assertEquals("within board", true, b);
    }
    /**
     * This test creates a bunch of coordinates and tests to see if the boundedMoves method removes the
     * coordinates that are not within bounds.
     **/
    @Test
    public void testBoundedMoves1(){
        Coord c = new Coord(0, 0);
        Coord c1 = new Coord(0,2);
        Coord c2 = new Coord(1,3);
        Coord c3 = new Coord(3, 3);
        Coord c4 = new Coord(4,2);
        Coord c5 = new Coord(4,0);
        Coord c6 = new Coord(1, -1);
        Coord c7 = new Coord(3, -1);
        ArrayList<Coord> fake = new ArrayList<Coord>();
        ArrayList<Coord> tester = new ArrayList<Coord>();
        tester.add(c);
        tester.add(c1);
        tester.add(c2);
        tester.add(c3);
        tester.add(c4);
        tester.add(c5);

        fake.add(c);
        fake.add(c1);
        fake.add(c2);
        fake.add(c3);
        fake.add(c4);
        fake.add(c5);
        fake.add(c6);
        fake.add(c7);
        Movement m = new Movement();
        ArrayList<Coord> array = m.boundedMoves(fake);

        System.out.println(array);
        int counter = 0;
        if(array.size() == 6){
            for(int i = 0 ; i < 6 ; i++){
                Coord j = new Coord();
                j = tester.get(i);
                Coord k = new Coord();
                k = array.get(i);
                if(j == null && k == null){
                    counter++;

                }else if(j.equals(k)){
                    counter++;
                }
            }
        }
        assertEquals("6 moves", 6, counter);
    }
    /**
     * This test creates a bunch of coordinates and tests to see if the boundedMoves method removes the
     * coordinates that are not within bounds.
     **/
    @Test
    public void boundedMovesTest2(){
        Coord c = new Coord(0, 2);
        Coord c1 = new Coord(1,2);
        Coord c2 = new Coord(2,2);
        Coord c3 = new Coord(1,5);
        ArrayList<Coord> fake = new ArrayList<Coord>();
        ArrayList<Coord> tester = new ArrayList<Coord>();
        fake.add(c);
        fake.add(c1);
        fake.add(c2);
        fake.add(c3);

        Movement m = new Movement();
        ArrayList<Coord> array = m.boundedMoves(fake);

        System.out.println(array);
        int counter = 0;
        if(array.size() == 3){
            for(int i = 0 ; i < 0 ; i++){
                Coord j = new Coord();
                j = tester.get(i);
                Coord k = new Coord();
                k = array.get(i);
                if(j == null && k == null){
                    counter++;

                }else if(j.equals(k)){
                    counter++;
                }
            }
        }
        assertEquals("no moves", 0, counter);
    }
    /**
     * This test creates two coordinates and a piece and moves the piece to test that the move is legal.
     * This test returns true because the move was legal
     **/
    @Test
    public void movePieceTest(){
        Coord c = new Coord(0, 2);
        Coord c1 = new Coord(1,2);
        Coord c2 = new Coord(2,2);
        ArrayList<Coord> fake = new ArrayList<Coord>();
        ArrayList<Coord> tester = new ArrayList<Coord>();
        tester.add(c);
        tester.add(c1);

        fake.add(c);
        fake.add(c1);
        fake.add(c2);
        Piece pawn1 = new Piece("pawn", "white", new Coord(1,1), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(0,2), "BP1");
        Piece pawn3 = new Piece("pawn", "white", new Coord(2,2), "BP2");
        Movement m = new Movement();
        CustomGameSet game = new CustomGameSet(pawn1, pawn2, pawn3);
        Board board = new Board(game);
        ArrayList<Coord> array = m.allowedMoves(pawn1, board, fake );
        m.movePiece(pawn1, c);
        System.out.println(array);
        int counter = 0;
        if(array.size() == 2){
            for(int i = 0 ; i < 2 ; i++){
                Coord j = new Coord();
                j = tester.get(i);
                Coord k = new Coord();
                k = array.get(i);
                if(j == null && k == null){
                    counter++;

                }else if(j.equals(k)){
                    counter++;
                }
            }
        }
        assertEquals("Incorrect allowed moves", 2, counter);
    }
    /**
     * Tests the genMoves method by giving it three coords and 2 legal one illegal
     * then gives a pawn then it calls the gen moves method and compares it to an arraylist
     * of legal moves and tests to see if they are equal. This test should return true.
     **/

    @Test
    public void genMovesTest(){
        Coord c = new Coord(0, 2);
        Coord c1 = new Coord(1,2);
        Coord c2 = new Coord(2,2);

        ArrayList<Coord> trueArray = new ArrayList<Coord>();

        trueArray.add(c1);
        trueArray.add(c);

        Piece pawn1 = new Piece("pawn", "white", new Coord(1,1), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(0,2), "BP1");
        Piece pawn3 = new Piece("pawn", "white", new Coord(2,2), "BP2");
        Movement m = new Movement();
        CustomGameSet game = new CustomGameSet(pawn1, pawn2, pawn3);
        Board board = new Board(game);
        ArrayList<Coord> generatedMoves = m.genMoves(pawn1, board);;
        boolean b = false;
        for(int i = 0 ; i < 2 ; i++){
            Coord j;
            j = trueArray.get(i);
            Coord k;
            k = generatedMoves.get(i);

            if(j == null && k == null){
                b= true;

            }else if(j.equals(k)){
                b = true;
            }else{
                b = false;
            }
        }
        assertEquals("Incorrect allowed moves", true, b);
    }   
    

}