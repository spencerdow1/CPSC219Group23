
import java.util.Random;
import java.util.ArrayList;

public class AIPlayerForTest extends Player{

    private Random rand = new Random();
    private int difficulty;
    private Movement aIMoves = new Movement();


    public AIPlayerForTest(int aDifficulty){
    	super("Computer");
        setDifficulty(aDifficulty);
    }


    public AIPlayerForTest(AIPlayer aComputerPlayer){
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
            System.out.print("Cannot choose, we haven't built that ");
            System.out.println("difficulty yet. Set to level 0.");
    	}
    }


    /** This function is just a control switch to call whichever function
    * will be used to generate the ArrayList<Coord> of moves 
    *
    **/
    public ArrayList<Coord> chooseMoveBlack(GameSet currentGameSet,
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
            chosenMove = levelOneBlackMovement(blackPieces, currentBoard,
                allMoves);
        }

        else {
            chosenMove = randomMovement(blackPieces, allMoves);
        }

        return chosenMove;
    }


    /** This function is a duplicate of chooseMove, but for the white
    * (usually human) team. This is to test AI versus AI. Otherwise chooseMove
    * is assumed to be black.
    * @see chooseMove(GameSet currentGameSet, Board currentBoard)
    **/
    public ArrayList<Coord> chooseMoveWhite(GameSet currentGameSet,
        Board currentBoard){
        
        ArrayList<Coord> chosenMove;
        ArrayList<Piece> whitePieces = currentGameSet.getWhitePieces();
        ArrayList<ArrayList<Coord>> allMoves = generateAllMoves(whitePieces,
            currentBoard);

        int theDifficulty = getDifficulty();

        if (theDifficulty == 0){
            chosenMove = randomMovement(whitePieces, allMoves);
        }

        else {
            chosenMove = randomMovement(whitePieces, allMoves);
        }

        return chosenMove;
    }


    /** This function will generate all the integers which represent the
    value of a move 
    *
    **/
    public ArrayList<ArrayList<Integer>> levelOneBlackChoices(ArrayList<Piece> theBlackPieces,
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
                        moveValue = valueBlackPawnMoveLevelOne(theBoard,
                            theMove, numPawns);
                    }
                    else if (thePiece.getType().equals("knight")){
                        moveValue = valueBlackKnightMoveLevelOne(theBoard,
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
    public ArrayList<Coord> levelOneBlackMovement(ArrayList<Piece> theBlackPieces,
        Board theBoard, ArrayList<ArrayList<Coord>> theMoves){

        // set the AI up to return the choices
        ArrayList<Coord> aIChoice = new ArrayList<Coord>();
        Piece pieceChoice;
        Coord pieceChoicePosition;
        Coord moveChoice;
        Coord indexCoord = new Coord(0,0);

        // variables necessary to make a choice using a CDF random 
        // technique
        ArrayList<ArrayList<Integer>> values = levelOneBlackChoices(theBlackPieces,
            theBoard, theMoves);
        ArrayList<Integer> choiceValues;
        ArrayList<Integer> tempChoices;
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
        System.out.println("The Total is: "+total);
        if (total == 0){
            aIChoice = randomMovement(theBlackPieces, theMoves);
        }
        else {
        int randomChoice = rand.nextInt(total);
        System.out.println("The random choice is: "+randomChoice);

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

        System.out.println("The available values for choices are:");
        for (int i=0; i<values.size(); i++){
            ArrayList<Integer> someValues = values.get(i);
            System.out.print("[");
            for (int j=0; j<someValues.size(); j++){
                System.out.print(someValues.get(j)+", ");
            }
            System.out.print("],  ");
        }
        System.out.println("");

        System.out.print("The choices it made are: ");
        System.out.println(indexCoord.toString()); System.out.println("");


        System.out.print("The pieces available are: ");
        for (int i=0; i<theBlackPieces.size(); i++){
            Piece somePiece = theBlackPieces.get(i);
            System.out.print(somePiece.getName()+", ");
        }
        System.out.println("");


        // pull the move coordinates from the piece array and move array
        pieceChoice = theBlackPieces.get(indexCoord.getXCoord());
        pieceChoicePosition = pieceChoice.getPosition();
        System.out.print("Getting available moves: ");
        ArrayList<Coord> availableMoves = theMoves.get(indexCoord.getXCoord());
        for (int i=0; i<availableMoves.size(); i++){
            System.out.print(availableMoves.get(i) + ", ");
        }
        System.out.println("");

        moveChoice = availableMoves.get(indexCoord.getYCoord());
        System.out.print("Black chose: ");
        System.out.println(moveChoice.toString());

        aIChoice.add(pieceChoicePosition);
        aIChoice.add(moveChoice);
        }

        return aIChoice;
    }


    public int valueBlackPawnMoveLevelOne(Board aBoard, Coord aMove, int pawns){

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


    public int valueBlackKnightMoveLevelOne(Board aBoard, Coord aMove, int pawns){
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


    /** This evaluates the value of the position of the knight **/
    // public int valueKnightPosition(Piece aReferencePiece, Coord theMove,
    //     Coord possibleMove, int pawns){
    //     // there is a piece there so compute its value
    //     if (aReferencePiece != null){
    //         if (theMove.equals(possibleMove)){
    //             // capturing a knight is worth 5
    //             if (aReferencePiece.getType().equals("knight")){
    //                 currentPoints += 5;
    //             }
    //             // capturing a pawn value depends on the number
    //             // of pawns on the board
    //             else {
    //                 if (pawns == 5 || pawns == 4){
    //                     currentPoints += 2;
    //                 }
    //                 if (pawns == 3){
    //                     currentPoints += 3;
    //                 }
    //                 if (pawns == 2){
    //                     currentPoints += 5;
    //                 }
    //                 if (pawns == 1){
    //                     currentPoints = 10;
    //                 }
    //             }
    //         }
    //         // threatening a knight is worth 3
    //         else if (referencePiece.getType().equals("knight")){
    //             currentPoints += 3;
    //         }
    //         // threatening a pawn is worth 1
    //         else {
    //             currentPoints += 1;
    //         }
    //     }
    //     return 0;
    // }


    public int getNumPawns(ArrayList<Piece> pieceList){
        int num = 0;
        for (Piece aPiece : pieceList){
            if (aPiece.getType().equals("pawn")){
                num++;
            }
        }
        return num;
    }


    // public int ValueKnightMoveLevelTwo(Piece aPiece, Board aBoard,
    //         Coord aMove, ArrayList<Coord> moves, int pawns){

    //     // coputes the value of leaving the piece where it is
    //     int currentPoints = valueKnightPosition(aPiece, aBoard, moves);
    
    //     // artificially move the piece to the location by creating a
    //     // psuedopiece which we can then pass into genMoves. the psuedo-
    //     // piece is an exact copy but with the move coordinates.
    //     Piece psuedoPiece = new Piece(aPiece.getType(), aPiece.getColour(),
    //         aMove, aPiece.getName());

    //     // generate the moves of the psuedo-move
    //     ArrayList<Coord> psuedoMoves = aIMoves.genMoves(psuedoPiece, aBoard);

    //     // compute the value of the new position of the psuedo-piece
    //     int newPoints = valueKnightPosition(psuedoPiece, aBoard, psuedoMoves);
    //     return 0;
    // }


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
