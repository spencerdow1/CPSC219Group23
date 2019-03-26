
import java.util.ArrayList;

public class GameDynamics extends Movement {


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
                	System.out.println("Invalid piece colour found in winCondition()");
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


	public void simultaneousMovement(ArrayList<Piece> aPieceList){
        Coord aCoord;
        ArrayList<Coord> coordList = new ArrayList<Coord>();

        for (Piece aPiece : aPieceList){
            aCoord = aPiece.getPosition();
            coordList.add(aCoord);
        }
        
	}


}
