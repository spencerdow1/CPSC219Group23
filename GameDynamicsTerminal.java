
import java.util.ArrayList;
import java.util.Scanner;


public class GameDynamicsTerminal extends Movement {
    String playerOneName = "player 1";
    String playerTwoName = "player 2";
    Player playerOne;
    Player playerTwo;
    AIPlayer computerPlayer;


    public GameDynamicsTerminal(){}


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


    public boolean stalemate(GameSet aGameSet, Board theBoard){
        boolean stalemate = false;
        ArrayList<Piece> whitePieces = aGameSet.getWhitePieces();
        ArrayList<Piece> blackPieces = aGameSet.getBlackPieces();
        int numWhitePieces = whitePieces.size();
        int numBlackPieces = blackPieces.size();
        int numWhiteMoves = 0;
        int numBlackMoves = 0;
        Piece whitePiece, blackPiece;
        ArrayList<Coord> whiteMoves, blackMoves;

        for (int i = 0; i < numWhitePieces; i++){
            whitePiece = whitePieces.get(i);
            whiteMoves = genMoves(whitePiece, theBoard);
            for (int n = 0; n < whiteMoves.size(); n++){
                numWhiteMoves++;
            }
            if (numWhiteMoves > 0){
                break;
            }
        }

        for (int j = 0; j < numBlackPieces; j++){
            blackPiece = blackPieces.get(j);
            blackMoves = genMoves(blackPiece, theBoard);
            for (int m = 0; m < blackMoves.size(); m++){
                numBlackMoves++;
            }
            if (numBlackMoves > 0){
                break;
            }

        }

        if (numWhiteMoves == 0 || numBlackMoves == 0){
            stalemate = true;
        }

        return stalemate;

    }


	public String winCondition(GameSet theGameSet, Board theBoard){
        ArrayList<Piece> aPieceList = theGameSet.getGamePieces();
        int numWhitePawns = 0;
        int numBlackPawns = 0;
        String currentType, colour, winString;

        for (Piece aPiece : aPieceList){
        	currentType = aPiece.getType();

        	if (currentType.equals("pawn")){
        		colour = aPiece.getColour();

                if (colour.equals("white")){
                    numWhitePawns += 1;
                }
                else if (colour.equals("black")){
                    numBlackPawns += 1;
                }
                else {
                	System.out.print("Invalid piece colour found ");
                    System.out.println("in winCondition()");
                }
        	} 
        }

        if (numWhitePawns == 0){
            if (numBlackPawns == 0){
            	winString = "draw";
            }
            else {
            	winString = "black";
            }
        }

        else if (numBlackPawns == 0){
            winString = "white";
        }

        else if (stalemate(theGameSet, theBoard)){
            winString = "stalemate";
        }

        else {
        	winString = "continue";
        }

        return winString;
	}


	public void simultaneousMovement(ArrayList<Coord> turnMoves,
        GameSet pieces, Board currentBoard){

        // throw an error if turnMoves is not length 4
        if (turnMoves.size() != 4){
            System.out.print("Invalid moves passed to ");
            System.out.println("simultaneousMovement");
        }

        Coord whiteMove = turnMoves.get(1);
        Coord blackMove = turnMoves.get(3);
        Coord whitePieceLocation = turnMoves.get(0);
        Coord blackPieceLocation = turnMoves.get(2);
        int whiteIndex = pieces.getPieceIndexByCoord(whitePieceLocation);
        int blackIndex = pieces.getPieceIndexByCoord(blackPieceLocation);
        Piece whitePiece = pieces.getPiece(whiteIndex);
        Piece blackPiece = pieces.getPiece(blackIndex);
        String whitePieceType = whitePiece.getType();
        String blackPieceType = blackPiece.getType();

        // IF PIECES MOVE TO THE SAME SPOT
        if (whiteMove.equals(blackMove)){
            // if both pieces are the same type they annihilate
            if (whitePieceType.equals(blackPieceType)){
                pieces.removePieces(whiteIndex, blackIndex);
            }

            // if one tye is different there are two cases
            else {
                if (whitePieceType.equals("knight")){
                    pieces.removePiece(blackIndex);
                    movePiece(whitePiece, whiteMove);
                }
                else {
                    pieces.removePiece(whiteIndex);
                    movePiece(blackPiece, blackMove);
                }
            }
        }

        // OTHERWISE HANDLE MOVES AND CAPTURES
        else {
            // get the pieces which will be moved to for black and white
            Piece whitePieceReference = currentBoard.getPiece(whiteMove);
            Piece blackPieceReference = currentBoard.getPiece(blackMove);
            
            // WHITE MOVE
            if (whitePieceReference != null){
                // if white is moving to a location that black is not
                // moving away from then delete that piece
                if (whiteMove.equals(blackPieceLocation) == false){
                    int annihilateIndex = pieces.getPieceIndexByCoord(whiteMove);
                    pieces.removePiece(annihilateIndex);
                    movePiece(whitePiece, whiteMove);
                }
                // otherwise just move because black is moving
                else {
                    movePiece(whitePiece, whiteMove);
                }
            }
            else {
                movePiece(whitePiece, whiteMove);
            }

            // BLACK MOVE
            if (blackPieceReference != null){
                // if white is moving to a location that black is not
                // moving away from then delete that piece
                if (blackMove.equals(whitePieceLocation) == false){
                    int annihilateIndex = pieces.getPieceIndexByCoord(blackMove);
                    pieces.removePiece(annihilateIndex);
                    movePiece(blackPiece, blackMove);
                }
                // otherwise just move because black is moving
                else {
                    movePiece(blackPiece, blackMove);
                }
            }
            else {
                movePiece(blackPiece, blackMove);
            }
        }

        // check for possible upgrades in the game set
        ArrayList<Piece> alivePieces = pieces.getGamePieces();
        for (Piece aPiece : alivePieces){
            aPiece.upgrade();
        }

        // now that the gameset is modified just update the board
        currentBoard.updateBoard(pieces);
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
