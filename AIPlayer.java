
import java.util.Random;
import java.util.ArrayList;

public class AIPlayer extends Player{

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
