package Text;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import Logic.*;

/**
 * Final class which has the static method which lanches the game
 */
public class ApocalypseTerminal{

    /**
     * Main program that takes input choices from the user and
     * instantiates the different versions of the game
     * @see GameDynamicsTerminal
     */
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);

	    System.out.println(""); System.out.println("");
        System.out.println("WELCOME TO TERMINAL BASED APOCALYPSE");
        System.out.println(""); System.out.println("");


        // Options to print the rules to the terminal
        System.out.print("Would you like to read the rules? ");
        boolean correctRuleChoice = false;
        String ruleAnswer = "";
        while(correctRuleChoice == false){
            ruleAnswer = keyboard.nextLine();
            ruleAnswer = ruleAnswer.toUpperCase();

            if (ruleAnswer.equals("Y") || ruleAnswer.equals("YES")){

                try{
                    File myFile = new File("src\\Text\\ApocalypseRulesPointForm.txt");
                    if (!myFile.exists()) {
                        throw new FileNotFoundException("");
                    }
                    FileReader fr = new FileReader("src\\Text\\ApocalypseRulesPointForm.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;

                    while ((line = br.readLine()) != null){
                        System.out.println(line);
                    }
                }
                catch(Exception e){
                    if (e instanceof IOException){
                        System.out.print("Caught generic IOException ");
                        System.out.println("while reading rules.");
                    }
                    else if (e instanceof FileNotFoundException){
                        System.out.print("File not found exception ");
                        System.out.println("while reading rules.");
                    }
                    else {
                        System.out.print("Caught generic IOException ");
                        System.out.println("while reading rules.");
                    }
                }

                correctRuleChoice = true;
                System.out.println("");
            }
            else if (ruleAnswer.equals("N") || ruleAnswer.equals("NO")){
                correctRuleChoice = true;
            }
            else {
                System.out.println("Invalid choice. Please choose: Y/N.");
            }
        }


        // Instantiate single or multi-player mode
        System.out.print("Single or Multi-Player? (S/M):  ");
        boolean correctModeChoice = false;
        String gameModeChoice = "";
        while (correctModeChoice == false){
            gameModeChoice = keyboard.nextLine();
            gameModeChoice = gameModeChoice.toUpperCase();

            if (gameModeChoice.equals("S") || gameModeChoice.equals("SINGLE")){
                correctModeChoice = true;
            }

            else if (gameModeChoice.equals("M") || gameModeChoice.equals("MULTI")){
                correctModeChoice = true;
            }

            else {
                System.out.print("Not valid choice. Choose S or SINGLE ");
                System.out.print(" for single player, M or MULTI for ");
                System.out.println("multi-player.");
            }
        }


        // create the game
        /** GAME SECTION **/
        
        // Instantiate single player
        if (gameModeChoice.equals("S")){

            // instantiate players
            System.out.print("Player 1 enter name: ");
            String player1Name = keyboard.nextLine();
            Player humanPlayer = new HumanPlayer(player1Name);
            AIPlayer computer = new AIPlayer(0);

            // choosing the difficulty
            System.out.print("Choose difficulty "+player1Name+"; (0,1): ");
            boolean validDifficulty = false;
            while (validDifficulty == false){
                String difficulty = keyboard.nextLine();
                char[] difficultyArr = difficulty.toCharArray();
                
                if (difficulty.length() != 1){
                    System.out.print("Invalid choice. Please ");
                    System.out.println("choose difficulty (0,1).");

                }

                else {
                    if (difficultyArr[0] == 48){
                        computer = new AIPlayer(0);
                        validDifficulty = true;
                    }
                    else if (difficultyArr[0] == 49){
                        computer = new AIPlayer(1);
                        validDifficulty = true;
                    }
                    else {
                        System.out.print("Invalid choice. Please ");
                        System.out.println("choose difficulty 0.");
                    }
                }
            }

            // playing the game
            boolean playAgain = true;
            while (playAgain == true){
                System.out.println("");
                GameSet gameSet = new DefaultGameSet();
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


        // Instantiate multi-player
        else if (gameModeChoice.equals("M")){

            // instantiate players
            System.out.print("Player 1 enter name: ");
            String player1Name = keyboard.nextLine();
            System.out.print("Player 2 enter name: ");
            String player2Name = keyboard.nextLine();
            System.out.println("");
            Player player1 = new HumanPlayer(player1Name);
            Player player2 = new HumanPlayer(player2Name);

            boolean playAgain = true;
            while (playAgain == true){
                GameSet gameSet = new DefaultGameSet();
                Board gameBoard = new Board(gameSet);
                GameDynamicsTerminal game = new GameDynamicsTerminal(
                        player1, player2);
                game.runMultiplayer(gameSet, gameBoard);
                
                // after the game has executed
                // print the state of the board
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
                    System.out.println(player2Name+" wins!");
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

    // end of main
    }
// end of class
}
