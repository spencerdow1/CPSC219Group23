package Tests;
import Logic.*;
import Text.*;
public class TestGameWithStalemate {

    public static void main(String[] args){
        System.out.println("");
        AIPlayer computer = new AIPlayer(0);
        Player humanPlayer = new HumanPlayer("NORMAL HUMAN");
        String player1Name = humanPlayer.getName();
        GameSet gameSet = new CustomGameSet(6);
        Board gameBoard = new Board(gameSet);
        GameDynamicsTerminal game = new GameDynamicsTerminal(
                humanPlayer, computer);        
        game.runSinglePlayer(gameSet, gameBoard);
        
        // after the game has executed, print the state of the board
        System.out.println("");
        gameBoard.printBoard();
        System.out.println("");

        // print who won or if it was a stalemate
        String winString = game.winCondition(gameSet, gameBoard);
                           
        if (winString.equals("draw")){
            System.out.println("It's a draw!");
            System.out.println("");
        }
        else if (winString.equals("black")){
            System.out.println("Computer wins.");
            System.out.println("");
        }
        else if (winString.equals("white")){
            System.out.println(player1Name+" wins!");
            System.out.println("");
        }
        else if (winString.equals("stalemate")){
            System.out.println("Stalemate reached.");
            System.out.println("");    
        }
        else {
            System.out.println("Error in who won. ");
        }
    }
}
