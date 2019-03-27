
import java.util.ArrayList;

public class GameDynamics extends Movement {


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


}
