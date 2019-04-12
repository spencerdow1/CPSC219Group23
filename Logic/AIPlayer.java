package Logic;


import java.util.Random;
import java.util.ArrayList;

import java.util.Random;

import java.util.ArrayList;



public class AIPlayer extends Player{



    private Random rand = new Random();

    private int difficulty;

    private Movement aIMoves = new Movement();


    /**
     *
     * @param aDifficulty
     */
    public AIPlayer(int aDifficulty){

        super("Computer");

        setDifficulty(aDifficulty);

    }


    /**
     *
     * @param aComputerPlayer
     */
    public AIPlayer(AIPlayer aComputerPlayer){

        super(aComputerPlayer);

        setDifficulty(aComputerPlayer.getDifficulty());

    }


    /**
     *
     * @return
     */
    public int getDifficulty(){

        int copyDifficulty = difficulty;

        return copyDifficulty;

    }


    /**
     *
     * @param someDifficulty
     */
    public void setDifficulty(int someDifficulty){

        if (someDifficulty >= 0 && someDifficulty < 2){

            difficulty = someDifficulty;

        }

        else {

            difficulty = 0;

            System.out.print("Cannot choose, we haven't built that ");

            System.out.println("difficulty yet. Set to level 0.");

        }

    }





    /** This function is just a control switch to call whichever function

     * will be used to generate the ArrayList<Coord> of moves

     *

     **/

    public ArrayList<Coord> chooseMove(GameSet currentGameSet,

                                       Board currentBoard){



        ArrayList<Coord> chosenMove;

        ArrayList<Piece> blackPieces = currentGameSet.getBlackPieces();

        ArrayList<ArrayList<Coord>> allMoves = generateAllMoves(blackPieces,

                currentBoard);



        int theDifficulty = getDifficulty();



        if (theDifficulty == 0){

            chosenMove = randomMovement(blackPieces, allMoves);

        }



        else if (theDifficulty == 1){

            chosenMove = levelOneMovement(blackPieces, currentBoard,

                    allMoves);

        }



        else {

            chosenMove = randomMovement(blackPieces, allMoves);

        }



        return chosenMove;

    }





    /** This function will generate all the integers which represent the

     value of a move

     *

     **/

    public ArrayList<ArrayList<Integer>> levelOneChoices(ArrayList<Piece> theBlackPieces,

                                                         Board theBoard, ArrayList<ArrayList<Coord>> theMoves){

        ArrayList<Integer> moveValues;

        ArrayList<Coord> possibleMoves;

        int numPawns = getNumPawns(theBlackPieces);

        int numMoves;

        int moveValue;

        Coord theMove;

        Piece thePiece;

        ArrayList<ArrayList<Integer>> choices = new ArrayList<ArrayList<Integer>>();





        for (int i = 0; i < theMoves.size(); i++){



            thePiece = theBlackPieces.get(i);

            possibleMoves = theMoves.get(i);

            moveValues = new ArrayList<Integer>();

            numMoves = possibleMoves.size();



            // if the number of moves is zero we still need to add something

            // to the list that wont affect the CDF when making choices

            // so the list sizes match up, so we choose 0

            if (numMoves == 0){

                moveValues.add(0);

            }

            // otherwise carry on as normal

            else {

                for (int j = 0; j < numMoves; j++){



                    // PLACE A VALUE ON THE MOVE

                    theMove = possibleMoves.get(j);

                    if (thePiece.getType().equals("pawn")){

                        moveValue = valuePawnMoveLevelOne(theBoard,

                                theMove, numPawns);

                    }

                    else if (thePiece.getType().equals("knight")){

                        moveValue = valueKnightMoveLevelOne(theBoard,

                                theMove, numPawns);

                    }

                    else {

                        System.out.println("Invalid piece found in ");

                        System.out.println("levelOneMovement.");

                        moveValue = 0;

                    }

                    // add the moves value to the arrayList of values

                    moveValues.add(moveValue);

                }

            }



            // before the moveValues are nullified, save add them to choices

            choices.add(moveValues);

        }



        return choices;

    }





    /** This function takes all the arguments to pass to levelOneChoices

     * and will use weighted random values to make a selection

     **/

    public ArrayList<Coord> levelOneMovement(ArrayList<Piece> theBlackPieces,

                                             Board theBoard, ArrayList<ArrayList<Coord>> theMoves){



        // set the AI up to return the choices

        ArrayList<Coord> aIChoice = new ArrayList<Coord>();

        Piece pieceChoice;

        Coord pieceChoicePosition;

        Coord moveChoice;

        Coord indexCoord = new Coord(0,0);



        // variables necessary to make a choice using a CDF random

        // technique

        ArrayList<ArrayList<Integer>> values;

        ArrayList<Integer> choiceValues;

        ArrayList<Integer> tempChoices;

        values = levelOneChoices(theBlackPieces, theBoard, theMoves);

        int numPieceChoices = values.size();

        int numChoices;

        int total = 0;

        int runningTotal = 0;

        int num;



        // go through and square the values to exaggerate differences

        for (int i = 0; i < numPieceChoices; i++){

            choiceValues = values.get(i);

            numChoices = choiceValues.size();

            tempChoices = new ArrayList<Integer>();

            for (int j = 0; j < numChoices; j++){

                num = choiceValues.get(j);

                num = num * num;

                tempChoices.add(j,num);

                total += num;

            }

            values.set(i, tempChoices);

        }



        // choose a value in the CDF between 0 and total

        if (total == 0){

            aIChoice = randomMovement(theBlackPieces, theMoves);

        }

        else {

            int randomChoice = rand.nextInt(total);



            // loop through to find that choice based on the CDF and random

            // integer chosen

            for (int i = 0; i < numPieceChoices; i++){

                choiceValues = values.get(i);

                numChoices = choiceValues.size();

                for (int j = 0; j < numChoices; j++){

                    // add the new value for the probability

                    runningTotal += choiceValues.get(j);

                    // if less than, as this is an iterative approach

                    // this means it hit the probability "region"

                    if (randomChoice < runningTotal){

                        // save the indices of where it chose as a Coord

                        indexCoord = new Coord(i,j);

                        // cheater way of breaking the loop

                        j = numChoices;

                        i = numPieceChoices;

                    }

                }

            }





            // pull the move coordinates from the piece array and move array

            pieceChoice = theBlackPieces.get(indexCoord.getXCoord());

            pieceChoicePosition = pieceChoice.getPosition();

            ArrayList<Coord> availableMoves = theMoves.get(indexCoord.getXCoord());



            moveChoice = availableMoves.get(indexCoord.getYCoord());



            aIChoice.add(pieceChoicePosition);

            aIChoice.add(moveChoice);

        }



        return aIChoice;

    }





    public int valuePawnMoveLevelOne(Board aBoard, Coord aMove, int pawns){



        Piece referencePiece = aBoard.getPiece(aMove);

        int points = 0;



        // if there is a piece there place a value on the piece

        if (referencePiece != null){

            if (referencePiece.getType().equals("knight")){

                points += 5;

            }

            else {

                points += 2;

            }

        }



        // now adjust the points based on position

        int y = aMove.getYCoord();



        // if last pawn do not incentivize movement at all

        if (pawns == 1){

            if (y != 4){

                points += 1;

            }

            // only exception of zero points in the game is surrendering

            // via upgrade only remaining pawn

        }

        // if only two pawns, do not incentivize movement over anything

        // unless there is a chance for upgrade, then sort of

        else if (pawns == 2){

            if (y == 4){

                points += 2;

            }

            else {

                points += 1;

            }

        }

        // if a few pawns, favor advanced movement only in circumstance

        // where pawn is close to the end of the board

        else if (pawns == 3){

            if (y == 4){

                points += 3;

            }

            else if (y == 3){

                points += 2;

            }

            else {

                points += 1;

            }

        }

        // if there is lots of pawns, incentivize to advance

        else {

            points += 4 - y;

        }



        return points;

    }


    /**
     * enumerates the knights possible moves
     * @param aBoard
     * @param aMove
     * @param pawns
     * @return
     */
    public int valueKnightMoveLevelOne(Board aBoard, Coord aMove, int pawns){

        int points = 0;

        int x = aMove.getXCoord();

        int y = aMove.getYCoord();



        // now compute the points of capture

        Piece referencePiece = aBoard.getPiece(aMove);

        if (referencePiece!= null){

            if (referencePiece.getType().equals("knight")){

                points += 5;

            }

            // for pawns it depends on how many pawns are on the board

            else {

                if (pawns == 1){

                    points = 10;

                }

                else if (pawns == 2){

                    points += 5;

                }

                else if (pawns == 3){

                    points += 3;

                }

                else {

                    points += 2;

                }

            }

        }



        // compute the points of board location

        else {

            // if in the middle of the board

            if (x < 4 && x > 0 && y < 4 && y > 0){

                points += 2;

            }

            else {

                points += 1;

            }

        }



        return points;

    }


    /**
     * gets the number of pawns
     * @param pieceList
     * @return
     */
    public int getNumPawns(ArrayList<Piece> pieceList){

        int num = 0;

        for (Piece aPiece : pieceList){

            if (aPiece.getType().equals("pawn")){

                num++;

            }

        }

        return num;

    }


    /**
     * generates all moves
     * @param pieces
     * @param aBoard
     * @return
     */
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


    /**
     * produces a random move
     * @param pieces
     * @param givenMoves
     * @return
     */
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