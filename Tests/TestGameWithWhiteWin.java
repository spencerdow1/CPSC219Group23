package Tests;
import Logic.*;
import Text.*;
import java.util.Scanner;

public class TestGameWithWhiteWin {

	public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Player humanPlayer = new HumanPlayer("NORMAL HUMAN");
        String player1Name = humanPlayer.getName();
        AIPlayer computer = new AIPlayer(0);

        System.out.println("");
        System.out.println("WELCOME TO TERMINAL BASED APOCALYPSE!!!");

        // playing the game
        boolean playAgain = true;
        while (playAgain == true){
            System.out.println("");
            GameSet gameSet = new CustomGameSet(4);
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


            // prompt for a play again
            boolean promptAgain = true;
            while (promptAgain == true){
                System.out.print("Would you like to play again? (y/n): ");
                String playAgainChoice = keyboard.nextLine();
                playAgainChoice = playAgainChoice.toUpperCase();

                if (playAgainChoice.equals("Y") || playAgainChoice.equals("YES")){
                    playAgain = true;
                    promptAgain = false;
                }
                else if (playAgainChoice.equals("N") || playAgainChoice.equals("NO")){
                    playAgain = false;
                    promptAgain = false;
                }
                else {
                    System.out.println("Invalid input.");
                }
            }
        
        }

	}
}