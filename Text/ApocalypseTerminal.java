package Text;

import Logic.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ApocalypseTerminal{

    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        FileIO file = new FileIO();

	System.out.println(""); System.out.println("");
        System.out.println("WELCOME TO TERMINAL BASED APOCALYPSE");
        System.out.println(""); System.out.println("");

        // FILL IN // option to print rules to the terminal

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
            System.out.print("Choose difficulty "+player1Name+"; (0): ");
            boolean validDifficulty = false;
            while (validDifficulty == false){
                String difficulty = keyboard.nextLine();
                char[] difficultyArr = difficulty.toCharArray();
                
                if (difficulty.length() != 1){
                    System.out.print("Invalid choice. Please ");
                    System.out.println("choose difficulty 0.");

                }

                else {
                    if (difficultyArr[0] == 48){
                        computer = new AIPlayer(0);
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
                    file.Write(player1Name);
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
                GameSet gameSet = new CustomGameSet(4);
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
                    file.Write(player2Name);
                    System.out.println("");
                }
                else if (winString.equals("white")){
                    System.out.println(player1Name+" wins!");
                    file.Write(player1Name);
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

    public static class AIPlayer extends Player {

        private Random rand = new Random();
        private int difficulty;
        private Movement aIMoves = new Movement();


        public AIPlayer(int aDifficulty){
            super("Computer");
            setDifficulty(aDifficulty);
        }


        public AIPlayer(AIPlayer aComputerPlayer){
            super(aComputerPlayer);
            setDifficulty(aComputerPlayer.getDifficulty());
        }


        public int getDifficulty(){
            int copyDifficulty = difficulty;
            return copyDifficulty;
        }


        public void setDifficulty(int someDifficulty){
            if (someDifficulty >= 0 && someDifficulty < 2){
                difficulty = someDifficulty;
            }
            else {
                difficulty = 0;
            }
        }


        public ArrayList<Coord> chooseMove(GameSet currentGameSet, Board currentBoard){

            ArrayList<Coord> chosenMove = new ArrayList<Coord>();
            ArrayList<Piece> blackPieces = currentGameSet.getBlackPieces();
            ArrayList<ArrayList<Coord>> allMoves = generateAllMoves(blackPieces,
                currentBoard);

            int theDifficulty = getDifficulty();

            if (theDifficulty == 0){
                chosenMove = randomMovement(blackPieces, allMoves);
            }

            else {
                chosenMove.add(new Coord(0,0));
                chosenMove.add(new Coord(0,0));
                System.out.print("Cannot choose, we haven't built that ");
                System.out.println("difficulty yet. Set to (0,0).");
            }

            return chosenMove;
        }


        public ArrayList<ArrayList<Coord>> generateAllMoves(
                ArrayList<Piece> pieces, Board aBoard){

            ArrayList<Coord> pieceMoves;
            ArrayList<ArrayList<Coord>> allMoves = new ArrayList<ArrayList<Coord>>();

            for (Piece aPiece : pieces){
                pieceMoves = aIMoves.genMoves(aPiece, aBoard);
                allMoves.add(pieceMoves);
            }

            return allMoves;
        }


        public ArrayList<Coord> randomMovement(ArrayList<Piece> pieces,
                                               ArrayList<ArrayList<Coord>> givenMoves){

            int numPieces = givenMoves.size();
            ArrayList<Coord> movesForPiece;
            boolean selectedValidMove = false;
            int n,m,numMovesForPiece;
            int tryCounter = 0;
            Piece chosenPiece;
            Coord pieceLocation = new Coord(0,0);
            Coord randomMove = new Coord(0,0);
            ArrayList<Coord> returnMoves = new ArrayList<Coord>();

            if (numPieces == 0){
                System.out.print("No moves for givenMoves in randomMovement.");
                System.out.println(" Set to (0,0).");
            }

            else {
                // this is just so the compiler stops complaining

                while (selectedValidMove == false){
                    tryCounter++;
                    n = rand.nextInt(numPieces);
                    chosenPiece = pieces.get(n);
                    pieceLocation = chosenPiece.getPosition();
                    movesForPiece = givenMoves.get(n);
                    numMovesForPiece = movesForPiece.size();

                    if (numMovesForPiece != 0){
                        m = rand.nextInt(numMovesForPiece);
                        randomMove = movesForPiece.get(m);
                        selectedValidMove = true;
                    }

                    else if (tryCounter == 1000){
                        selectedValidMove = true;
                        System.out.print("Encountered 1000 tries in random ");
                        System.out.println("movement. Set move to (0,0).");
                    }
                }

            }

            returnMoves.add(pieceLocation);
            returnMoves.add(randomMove);

        return returnMoves;
        }


        public void printOptions(ArrayList<Piece> pieces, Board aBoard){

            int numPieces = pieces.size();
            int numMoves;
            String thePieceName;
            ArrayList<Coord> moveArray;
            Coord aMove;

            for (int i = 0; i < numPieces; i++){
                Piece thePiece = pieces.get(i);
                thePieceName = thePiece.getName();
                System.out.print(thePieceName+" moves are:  ");

                moveArray = aIMoves.genMoves(thePiece, aBoard);
                numMoves = moveArray.size();
                for (int j=0; j < numMoves; j++){
                    aMove = moveArray.get(j);
                    if (j == numMoves - 1){
                        System.out.println(aMove.toString());
                    }
                    else {
                        System.out.print(aMove.toString()+", ");
                    }

                }
            }
        }


    }
}
