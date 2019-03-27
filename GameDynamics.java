
import java.util.ArrayList;
import java.util.Scanner;

public class GameDynamics extends Movement {
    GameSet gameSet = new DefaultGameSet();
    Board board = new Board(gameSet);
    Piece[][] currentBoard = new Piece[5][5];
    ArrayList<Piece> gamePieces = gameSet.getGamePieces();


    public boolean staleMate(GameSet aGameSet, Board theBoard){
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


	public String winCondition(ArrayList<Piece> aPieceList){
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

        else {
        	winString = "continue";
        }

        return winString;
	}

    public void checkUpgrade(){

        for (Piece checkPiece : gamePieces) {
            checkPiece.upgrade(checkPiece);
        }
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

        // cases for if two pieces try to move to the same spot
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

        else {
            movePiece(whitePiece, whiteMove);
            movePiece(blackPiece, blackMove);
        }

        // now that the gameset is modified just update the board
        currentBoard.updateBoard(pieces);
	}

    public String moveCorrectColorPiece(Coord currentPosition){
        String colorOfPiece = null;
        if (board.getPiece(currentPosition) != null){
            if (board.getPiece(currentPosition).getColour() == "white"){
                colorOfPiece = "white";
            }
            else if (board.getPiece(currentPosition).getColour() == "black"){
                colorOfPiece = "black";
            }
        }
        return colorOfPiece;
    }

    public void moveWithUserInput(Board currentBoard){
        Coord currentPositionWhite = new Coord();
        Coord desiredPositionWhite = new Coord();
        Piece selectedPieceWhite = null;
        Coord currentPositionBlack = new Coord();
        Coord desiredPositionBlack = new Coord();
        Piece selectedPieceBlack = null;


        Scanner keyboard = new Scanner(System.in);

        while(winCondition(gamePieces) == "continue") {
            //gets input from white player and checks to see if its valid
            boolean possibleMove = false;
            boolean rightColor = false;
            int currentPositionWhiteX;
            int currentPositionWhiteY;
            int currentPositionBlackX;
            int currentPositionBlackY;
            int desiredPositionWhiteX;
            int desiredPositionWhiteY;
            int desiredPositionBlackX;
            int desiredPositionBlackY;


            while (!possibleMove && !rightColor ) {
                // This takes in a string from the user, and takes all the integers
                // it finds. The first two integers found are added to the array
                // and then the x and y coordinates are set from there. Otherwise
                // this works exactly as before.
                ArrayList<Integer> coordArray = new ArrayList<Integer>();
                while(coordArray.size() != 2){
                    System.out.print("White player select coordinate of the PIECE (x,y): ");
                    String whitePosStr = keyboard.nextLine();
                    char[] inputArray = whitePosStr.toCharArray();

                    coordArray = new ArrayList<Integer>();
                    for (char aChar : inputArray){
                        if ( aChar > 47 && aChar < 53 ) {
                            int anInt = (int) aChar;
                            // FYI -48 is because of position of integers 0-9 on
                            // on ASCII table
                            coordArray.add(anInt - 48);
                        }
                    }
                }

                currentPositionWhiteX = coordArray.get(0);
                currentPositionWhiteY = coordArray.get(1);
                currentPositionWhite = new Coord(currentPositionWhiteX,currentPositionWhiteY);
                selectedPieceWhite = gameSet.getPieceByCoord(currentPositionWhite);

                coordArray = new ArrayList<Integer>();
                while(coordArray.size() != 2){
                    System.out.print("White player select coordinate of the MOVE (x,y): ");
                    String whiteMoveStr = keyboard.nextLine();
                    char[] inputArray = whiteMoveStr.toCharArray();

                    coordArray = new ArrayList<Integer>();
                    for (char aChar : inputArray){
                        if ( aChar > 47 && aChar < 53 ) {
                            int anInt = (int) aChar;
                            coordArray.add(anInt - 48);
                        }
                    }
                }

                desiredPositionWhiteX = coordArray.get(0);
                desiredPositionWhiteY = coordArray.get(1);
                desiredPositionWhite = new Coord(desiredPositionWhiteX , desiredPositionWhiteY);


                if (selectedPieceWhite!=null){
                    if (legalMove(selectedPieceWhite, board, desiredPositionWhite)
                            && moveCorrectColorPiece(currentPositionWhite) == "white"){
                        possibleMove = true;
                    }
                    else System.out.println("The move you have entered is not valid please try again");
                }
                else {
                    System.out.println("Invalid piece selection.");
                }

            }


            possibleMove = false;
            rightColor = false;
            while (!possibleMove && !rightColor ) {
                //Take input from player two and checks if its valid
                ArrayList<Integer>coordArray = new ArrayList<Integer>();
                while(coordArray.size() != 2){
                    System.out.print("Black player select coordinate of the PIECE (x,y): ");
                    String blackPosStr = keyboard.nextLine();
                    char[] inputArray = blackPosStr.toCharArray();

                    coordArray = new ArrayList<Integer>();
                    for (char aChar : inputArray){
                        if ( aChar > 47 && aChar < 53 ) {
                            int anInt = (int) aChar;
                            coordArray.add(anInt - 48);
                        }
                    }
                }

                currentPositionBlackX = coordArray.get(0);
                currentPositionBlackY = coordArray.get(1);
                currentPositionBlack = new Coord(currentPositionBlackX,currentPositionBlackY);
                selectedPieceBlack = gameSet.getPieceByCoord(currentPositionBlack);

                coordArray = new ArrayList<Integer>();
                while(coordArray.size() != 2){

                    System.out.print("Black player select coordinate of the MOVE (x,y): ");
                    String blackMoveStr = keyboard.nextLine();
                    char [] inputArray = blackMoveStr.toCharArray();

                    coordArray = new ArrayList<Integer>();
                    for (char aChar : inputArray){
                        if ( aChar > 47 && aChar < 53 ) {
                            int anInt = (int) aChar;
                            coordArray.add(anInt - 48);
                        }
                    }
                }

                desiredPositionBlackX = coordArray.get(0);
                desiredPositionBlackY = coordArray.get(1);
                desiredPositionBlack = new Coord(desiredPositionBlackX,desiredPositionBlackY);

                if (selectedPieceBlack!=null){
                    if (legalMove(selectedPieceBlack, board, desiredPositionBlack ) &&
                            moveCorrectColorPiece(currentPositionBlack) == "black"){
                        possibleMove = true;
                    }
                    else System.out.println("The move you have entered is not valid please try again");
                }
                else {
                    System.out.println("Invalid piece Selection.");
                }
            }
            ArrayList<Coord> moves = new ArrayList<>();
            moves.add(currentPositionWhite);
            moves.add(desiredPositionWhite);
            moves.add(currentPositionBlack);
            moves.add(desiredPositionBlack);



            // execute moves


            simultaneousMovement(moves, gameSet, board);
            checkUpgrade();
            board.printBoard();

        }

    }


}
