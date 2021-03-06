package Tests;
import Logic.*;
import Text.*;
import java.util.ArrayList;

public class TestGameDynamicsMovement{


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
        ArrayList<Coord> compMove = computer.chooseMove(gameSet, gameBoard);
        System.out.println("");
        System.out.print("The computer chose: ");
        System.out.print(compMove.get(0).toString()+", ");
        System.out.println(compMove.get(1).toString());
        System.out.println("");

        // hard-code person movement
        Coord whitePieceChoice = new Coord(0,0);
        Coord whitePieceMove = new Coord(1,2);

        ArrayList<Coord> turnMoves = new ArrayList<Coord>();
        turnMoves.add(whitePieceChoice);
        turnMoves.add(whitePieceMove);
        turnMoves.add(compMove.get(0));
        turnMoves.add(compMove.get(1));

        game.simultaneousMovement(turnMoves, gameSet, gameBoard);

        gameBoard.printBoard();
	}

}

