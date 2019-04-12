package Tests;
import Logic.*;
import java.util.ArrayList;

public class TestPieceMovement {


    public static GameSet thisGameSet = new CustomGameSet(2);
    public static Board myTestBoard = new Board(thisGameSet);
    public static Movement thisGame = new Movement();


    public static void printToConsole(ArrayList<ArrayList<Coord>> someMoves){
        int numPieces = someMoves.size();
        int numMoves;
        String thePieceName;
        ArrayList<Coord> moveArray;
        Coord aMove;

        for (int i=0; i<numPieces; i++){
            Piece thePiece = thisGameSet.getPieceCopyFromSet(i);
            thePieceName = thePiece.getName();
            System.out.print(thePieceName+" moves are:  ");

            // go into the sub-array
            moveArray = someMoves.get(i);
            numMoves = moveArray.size();
            for (int j=0; j<numMoves; j++){
                aMove = moveArray.get(j);
                System.out.print(aMove.toString()+", ");

                if (j == numMoves - 1){
                	System.out.println("");
                }

            }
        }
    }


	public static void main(String[] args){
        ArrayList<Coord> possibleMoves;
        ArrayList<ArrayList<Coord>> allPossible = new ArrayList<ArrayList<Coord>>();

        int numPieces = thisGameSet.getSize();
        Piece selectedPiece;

        for (int i = 0; i<numPieces; i++){
        	selectedPiece = thisGameSet.getPieceCopyFromSet(i);
            possibleMoves = thisGame.genMoves(selectedPiece,
        	myTestBoard);
        	allPossible.add(possibleMoves);
        }

        // This is where the 'BIDNESS happens
        System.out.println("WELCOME TO PSUEDO-APOCALYPSE!!!");
        System.out.println("");
        myTestBoard.printBoard();

        // print the possible moves
        printToConsole(allPossible);
	}

}
