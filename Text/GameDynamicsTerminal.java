package Text;

import Logic.*;
import Text.ApocalypseTerminal;

import java.util.ArrayList;
import java.util.Scanner;


public class GameDynamicsTerminal extends GameDynamics {

        String playerOneName = "player 1";

        String playerTwoName = "player 2";

        Player playerOne;

        Player playerTwo;

        AIPlayer computerPlayer;


        public GameDynamicsTerminal(Player playerOne, Player playerTwo){

            this.playerOne = playerOne;

            this.playerTwo = playerTwo;

            playerOneName = playerOne.getName();

            playerTwoName = playerTwo.getName();

        }





        public GameDynamicsTerminal(Player playerOne, AIPlayer aComputerPlayer){

            this.playerOne = playerOne;

            computerPlayer = aComputerPlayer;

            playerOneName = playerOne.getName();

            playerTwoName = aComputerPlayer.getName();

        }

        public void runSinglePlayer(GameSet theGameSet, Board theBoard){



            ArrayList<Coord> whiteTurn, blackTurn;

            ArrayList<Coord> turn = new ArrayList<Coord>();

            int turnCounter = 0;



            // IF TEH GAME IS NOT IN STALEMATE CONDITION THEN EXECUTE

            while(winCondition(theGameSet, theBoard).equals("continue")) {

                turnCounter++;

                System.out.println("");

                System.out.println("turn number "+turnCounter);

                System.out.println("");



                turn = new ArrayList<Coord>();

                theBoard.printBoard();



                // get all the moves

                whiteTurn = getUserInput("white", theBoard);

                blackTurn = computerPlayer.chooseMove(theGameSet, theBoard);

                turn.addAll(whiteTurn);

                turn.addAll(blackTurn);

                // actually execute the movement

                simultaneousMovement(turn, theGameSet, theBoard);

            }



        }





        public void runMultiplayer(GameSet theGameSet, Board theBoard){



            ArrayList<Coord> whiteTurnMulti, blackTurnMulti;

            ArrayList<Coord> turnMulti = new ArrayList<Coord>();

            int turnCounter = 0;



            // IF TEH GAME IS NOT IN STALEMATE CONDITION THEN EXECUTE

            while(winCondition(theGameSet, theBoard).equals("continue")) {

                turnCounter++;

                System.out.println("");

                System.out.println("turn number "+turnCounter);

                System.out.println("");



                turnMulti = new ArrayList<Coord>();

                theBoard.printBoard();



                // get all the moves

                whiteTurnMulti = getUserInput("white", theBoard);

                blackTurnMulti = getUserInput("black", theBoard);

                turnMulti.addAll(whiteTurnMulti);

                turnMulti.addAll(blackTurnMulti);



                // TROUBLESHOOTING

                System.out.print("Move sequence in runMultiplayer: ");

                for (Coord aCoord : turnMulti){

                    System.out.print(aCoord.toString());

                }

                System.out.println("");



                // actually execute the movement

                simultaneousMovement(turnMulti, theGameSet, theBoard);

            }

        }





        public Coord getCoordFromInput(){

            Scanner keyboard = new Scanner(System.in);

            Coord returnCoord = new Coord(0,0);



            boolean validCoord = false;

            while (validCoord == false){

                String coordString = keyboard.nextLine();

                char[] inputArray = coordString.toCharArray();

                ArrayList<Integer> coordArray = new ArrayList<Integer>();



                for (char aChar : inputArray){

                    if ( aChar > 47 && aChar < 53 ){

                        int anInt = (int) aChar;

                        coordArray.add(anInt - 48);

                    }

                }



                if (coordArray.size() == 2){

                    int x = coordArray.get(0);

                    int y = coordArray.get(1);

                    returnCoord = new Coord(x, y);

                    validCoord = true;

                }



                else {

                    System.out.print("Invalid input. Enter selection in the ");

                    System.out.println("form (x,y) from 0-4.");

                }

            }



            return returnCoord;

        }





        public ArrayList<Coord> getUserInput(String color, Board aBoard){

            Scanner keyboard = new Scanner(System.in);

            ArrayList<Coord> returnList = new ArrayList<Coord>();

            Coord selection, move;

            Piece chosenPiece = new Piece("pawn", "white", new Coord(0,0), "NULL");

            boolean validPiece = false;

            boolean validMove = false;



            if (color.equals("white")){

                // GETTING TEH PIECE

                while (validPiece == false){

                    returnList = new ArrayList<Coord>();

                    validMove = false;

                    System.out.print("White player select coordinate of the PIECE (x,y): ");

                    selection = getCoordFromInput();

                    if (aBoard.getPiece(selection) == null){

                        System.out.println("Invalid Piece selection.");

                        // this is so it skips the valid move

                        validMove = true;

                    }

                    else {

                        chosenPiece = aBoard.getPiece(selection);

                        if (chosenPiece.getColour().equals("white")){

                            returnList.add(selection);

                            validPiece = true;

                            System.out.print("The piece selected is ");

                            System.out.println(chosenPiece.getName());

                        }

                        else {

                            System.out.println("Invalid piece colour.");

                            // so it will skip the next prompt

                            validMove = true;

                        }

                    }



                    // GETTING TEH MOVE

                    while (validMove == false) {

                        System.out.print("White player select coordinate of the MOVE (x,y): ");

                        move = getCoordFromInput();

                        if (legalMove(chosenPiece, aBoard, move) == true){

                            returnList.add(move);

                            validMove = true;

                        }

                        else {

                            System.out.println("Invalid move selection.");

                            // this is to replace a break statement

                            validMove = true;

                            validPiece = false;

                        }

                        //end of second while

                    }

                    //end of first while

                }

            }



            else if (color.equals("black")){

                // GETTING TEH PIECE

                while (validPiece == false){

                    returnList = new ArrayList<Coord>();

                    validMove = false;

                    System.out.print("Black player select coordinate of the PIECE (x,y): ");

                    selection = getCoordFromInput();

                    if (aBoard.getPiece(selection) == null){

                        System.out.println("Invalid Piece selection.");

                        validMove = true;

                    }

                    else {

                        chosenPiece = aBoard.getPiece(selection);

                        if (chosenPiece.getColour().equals("black")){

                            returnList.add(selection);

                            validPiece = true;

                            System.out.print("The piece selected is ");

                            System.out.println(chosenPiece.getName());

                        }

                        else {

                            System.out.println("Invalid piece colour.");

                        }

                    }



                    // GETTING TEH MOVE

                    while (validMove == false) {

                        System.out.print("Black player select coordinate of the MOVE (x,y): ");

                        move = getCoordFromInput();

                        if (legalMove(chosenPiece, aBoard, move) == true){

                            returnList.add(move);

                            validMove = true;

                        }

                        else {

                            System.out.println("Invalid move selection.");

                            validPiece = false;

                        }

                        //end of second while

                    }

                    // end of first while

                }

            }



            else {

                System.out.println("Invalid colour found in getUserInput.");

            }



            return returnList;

        }



    }