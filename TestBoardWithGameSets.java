
public class TestBoardWithGameSets{


	public static void main(String[] args){
 
        // weoooo
        System.out.println("WELCOME TO PSUEDO-APOCALYPSE!!!");
        System.out.println("");

        // test the custom setting
        Piece pawn1 = new Piece("pawn", "white", new Coord(2,0), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(2,4), "BP1");
        GameSet myCustomGameSet = new CustomGameSet(pawn1, pawn2);
        
        Board myBoard = new Board(myCustomGameSet);
        
        myBoard.printBoard();
        System.out.println("");
        System.out.println("");


        // test the default board setting
        GameSet myDefaultGameSet = new DefaultGameSet();
        Board myDefaultBoard = new Board(myDefaultGameSet);

        myDefaultBoard.printBoard();
        System.out.println("");
        System.out.println("");

        // Test updateBoard
        Piece aKnight = new Piece("knight", "black", new Coord(0, 4), "BK1");
        GameSet myNewGameSet = new CustomGameSet(aKnight);
        myBoard.updateBoard(myNewGameSet);

        myBoard.printBoard();
        System.out.println("");
        System.out.println("");
        
	}

}
