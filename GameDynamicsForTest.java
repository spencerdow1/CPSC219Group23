
import java.util.ArrayList;


public class GameDynamicsForTest extends Movement {
    private AIPlayerForTest playerOne;
    private AIPlayerForTest playerTwo;
    private String playerOneName = "player 1";
    private String playerTwoName = "player 2";


    public GameDynamicsForTest(AIPlayerForTest playerOne,
        AIPlayerForTest playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        playerOneName = playerOne.getName();
        playerTwoName = playerTwo.getName();
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


    public void runMultiplayerAI(GameSet theGameSet, Board theBoard,
        AIPlayerForTest computer1, AIPlayerForTest computer2){

        ArrayList<Coord> whiteTurnMulti, blackTurnMulti;
        ArrayList<Coord> turnMulti = new ArrayList<Coord>();
        int turnCounter = 0;

        theBoard.printBoard();

        // IF TEH GAME IS NOT IN STALEMATE CONDITION THEN EXECUTE
        while(winCondition(theGameSet, theBoard).equals("continue")) {
            turnCounter++;

            turnMulti = new ArrayList<Coord>();
               
            // get all the moves
            whiteTurnMulti = computer1.chooseMoveWhite(theGameSet, theBoard);
            System.out.println("White chose move");
            blackTurnMulti = computer2.chooseMoveBlack(theGameSet, theBoard);
            System.out.println("Black chose move");
            turnMulti.addAll(whiteTurnMulti);
            turnMulti.addAll(blackTurnMulti);

            // TROUBLESHOOTING
            for (Coord aCoord : turnMulti){
                System.out.print(aCoord.toString());
            }
            System.out.println("");

            // actually execute the movement
            simultaneousMovement(turnMulti, theGameSet, theBoard);
            System.out.println("Turn number "+turnCounter);
            theBoard.printBoard();
            System.out.println(""); System.out.println("");
        }
    }


}
