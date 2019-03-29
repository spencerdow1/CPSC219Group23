
import java.util.ArrayList;

public class TestGameDynamicsStalemate {


    public static void main(String[] args){
        GameSet gameSet = new CustomGameSet(2);
        Board gameBoard = new Board(gameSet);
        GameDynamicsTerminal game = new GameDynamicsTerminal();

        gameBoard.printBoard();
        System.out.println("");

        AIPlayer computer = new AIPlayer(0);
        ArrayList<Piece> blackPieces = gameSet.getBlackPieces();
        ArrayList<Piece> whitePieces = gameSet.getWhitePieces();

        // Display all the pices on the board
        System.out.print("The total game set is: ");
        System.out.println(gameSet.toString());
        System.out.print("The black pieces are: ");
        System.out.println(gameSet.toString(blackPieces));
        System.out.print("The white pieces are: ");
        System.out.println(gameSet.toString(whitePieces));
        System.out.println("");

        // Now look at the movement
        computer.printOptions(blackPieces, gameBoard);

        if (game.stalemate(gameSet, gameBoard) ){
        	System.out.println("stalemate reached");
        }
        else {
        	System.out.println("stalemate not reached.");
        }

        System.out.println("");
        System.out.println("");


        // NOW TRY WITH A NEW BOARD
        gameSet = new CustomGameSet(3);
        gameBoard = new Board(gameSet);
        game = new GameDynamicsTerminal();

        gameBoard.printBoard();
        System.out.println("");

        computer = new AIPlayer(0);
        blackPieces = gameSet.getBlackPieces();
        whitePieces = gameSet.getWhitePieces();

        // Display all the pices on the board
        System.out.print("The total game set is: ");
        System.out.println(gameSet.toString());
        System.out.print("The black pieces are: ");
        System.out.println(gameSet.toString(blackPieces));
        System.out.print("The white pieces are: ");
        System.out.println(gameSet.toString(whitePieces));
        System.out.println("");

        // Now look at the movement
        computer.printOptions(blackPieces, gameBoard);
        System.out.println("");

        if (game.stalemate(gameSet, gameBoard) ){
        	System.out.println("stalemate reached");
        }
        else {
        	System.out.println("stalemate not reached.");
        }

    }

}
