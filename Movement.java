import java.util.ArrayList;

public class Movement{

    // It is assumed that pieceType and pieceColor are with reference to the
    // current piece, NOT the referencePiece
    private Piece currentPiece;
    private Piece referencePiece;
    private String pieceType;
    private String pieceColor;


    /** Sets the current piece 
    **/
    private void setCurrentPiece(Piece inputPiece){
        currentPiece = inputPiece;
    }


    /** Grabs current piece
    **/
    private Piece getCurrentPiece(){
    	Piece copyCurrentPiece = currentPiece;
    	return copyCurrentPiece;
    }


    /** Sets the reference piece
    **/
    private void setReferencePiece(Piece inputPiece){
    	referencePiece = inputPiece;
    }

    
    /** Grabs current reference piece
    **/
    private Piece getReferencePiece(){
    	Piece copyReferencePiece = referencePiece;
    	return copyReferencePiece;
    }


    /** Simple boolean determining if the move is allowed for the rules
    @param <selectedPiece>: the piece to check for moves
    *	<move>: The Coord.location to move to 
    @return <isLegalMove> boolean if the move is legal
    @see Coord class
    **/
    public boolean legalMove(Piece selectedPiece, Coord move, Board aBoard){
    	boolean isLegalMove = false;
    	ArrayList<Coord> allMovesArray = allMoves(selectedPiece, aBoard);
    	ArrayList<Coord> boundedMovesArray = boundedMoves(allMovesArray);
    	ArrayList<Coord> allowedMovesArray = allowedMoves(boundedMovesArray,
    		aBoard);

        //use genmoves to populate a list, then check it to see if the move
    	// is in it;
    	if (allowedMovesArray.size() > 0)
    	    for (Coord possibleMove : allowedMovesArray)
    	        // Need to compare field variables of Coord object
    	        if (possibleMove.x == move.x && possibleMove.y == move.y){
    	        	isLegalMove = true;
    	        }
        
        return isLegalMove;
    } 


    /** Checks the board for pieces which are congruent with the locations of 
    all the generated moves. This determines if a piece can move to a position
    held by the opposite color OR if the piece cannot move as it is already held
    by a piece of the same color. 
    @param <aMoveArray>: Expects this array to not have values outside of the board
    @see boundedMoves()
    @return <legalMoves>: Final list of allowed moves for that piece
    **/
    public ArrayList<Coord> allowedMoves(ArrayList<Coord> aMoveArray,
    	Board aBoard){
        ArrayList<Coord> legalMoves = new ArrayList<Coord>();
        String refPieceColor, refPieceType;
        
        for (Coord aPosition : aMoveArray){
        	setReferencePiece(aBoard.getPiece(aPosition));

            // if there is no piece there, then a null constructor is
            // initialized
        	if (referencePiece.getPieceType() == "none"){
                legalMoves.add(aPosition);
        	}

            // if there is a piece, what color?
        	else {
        		refPieceColor = referencePiece.getPieceColor();

        		if (refPieceColor != pieceColor){
                    legalMoves.add(aPosition);
        		}
        	}
        }

        return legalMoves;
    }


    /** Populates a list of tuples representing the allowed moves
    @param <pieceColor>: Needs the color to determine movement
    <pieceType>: Needs the piece type (knight, pawn) to determine movement
    @return <moveList>: The populated list
    **/
	private ArrayList<Coord> allMoves(Piece somePiece, Board aBoard){
		String pieceType = somePiece.getPieceType();
		String pieceColor = somePiece.getPieceColor();
		Coord piecePosition = somePiece.getPosition();
		Piece refPiece;
		String refPieceColor;
        ArrayList<Coord> moveList = new ArrayList<Coord>();
        Coord forwardIndex;
        Coord leftIndex;
        Coord rightIndex;
        Piece forwardPiece;
        Piece leftPiece;
        Piece rightPiece;

		// logical fuckery of populating list of tuples

        // TWO CASES FOR PIECES

        // KNIGHT
		if (pieceType == "knight"){
			// Generate moves for knights
            if (pieceColor == "white" || pieceColor == "black"){
                // Only 8 permutations -- manually enter them
                moveList.add(new Coord(-2,1));
                moveList.add(new Coord(-1,2));
                moveList.add(new Coord(1,2));
                moveList.add(new Coord(2,1));
                moveList.add(new Coord(2,-1));
                moveList.add(new Coord(1,-2));
                moveList.add(new Coord(-1,-2));
                moveList.add(new Coord(-2,-1));

                for (int i = 0; i<moveList.size(); i++){
                    Coord aMove = moveList.get(i);
                    aMove.add(piecePosition);
                    moveList.set(i, aMove);
                }
            }

            else{
            	System.out.print("Invalid piece color found in type <knight>.");
            }
		}

        // PAWN
        else if (pieceType == "pawn"){
        	// FURTHER BROKEN UP INTO TWO CASES FOR PAWN
        	// WHITE PAWN
        	if (pieceColor == "white"){
        		forwardIndex = piecePosition.add(0,1);
        		leftIndex = piecePosition.add(-1,1);
        		rightIndex = piecePosition.add(1,1);
        		forwardPiece = aBoard.getPiece(forwardIndex);
        		leftPiece = aBoard.getPiece(leftIndex);
        		rightPiece = aBoard.getPiece(rightIndex);
        	}

        	// BLACK PAWN
        	else if (pieceColor == "black"){
                forwardIndex = piecePosition.add(0,-1);
        		leftIndex = piecePosition.add(-1,-1);
        		rightIndex = piecePosition.add(1,-1);
        		forwardPiece = aBoard.getPiece(forwardIndex);
        		leftPiece = aBoard.getPiece(leftIndex);
        		rightPiece = aBoard.getPiece(rightIndex);
        	}

        	else {
        		System.out.println("Invalid piece color found in type <pawn>");
        	}

            // now add the list of moves for the pawn
    	    if (forwardPiece.getPieceColor() == "none"){
       			moveList.add(forwardIndex);
       		}

       		if (leftPiece.getPieceColor() != pieceColor){
       			moveList.add(leftIndex);
       		}

        	if (rightPiece.getPieceColor() != pieceColor){
        		moveList.add(rightIndex);
            }

        }

        else {
        	System.out.println("Invalid piece type found in allMoves.");
        }

		return moveList;
	}


    /** This method checks the board for a piece and returns that piece given
    * coordinates. This is used to set the reference piece.
    @param <location>: the coordinate location to check the board for an
    	object
    @return <refPiece>: The piece object at the given location. Will return
    	null if it is not within the board.
    @see withinBoard()
    **/
	public Piece checkBoard(Coord location, Board aBoard){
        Piece refPiece;

        if (withinBoard(location) == true){
            refPiece = aBoard.getPiece(location);
        }

        else {
        	refPiece = null;
        }
        return refPiece;
	}


    /** Method which simply checks to see if the coordinates are within the board.
    * Here, board size of 0 to 4 is assumed for Apocalypse.
    @param <location>: the input coordinate location
    @return boolean <inBounds>: true false for if the location is in the board.
    **/
    public boolean withinBoard(Coord location){
        boolean inBounds;

        if (location.x >= 0 || location.x <=4){

        	if (location.y >= 0 || location.y <=4){
        		inBounds = true;
        	}
        	else {
                inBounds = false;
        	}
        }

        else {
        	inBounds = false;
        }

        return inBounds;
    }


    /** Take in the list of coordinates and eliminate the ones which move
    the piece off the board
    @param <allMoves>: the list of tuples of possible moves
    @return <boundedMovesArray>: the list with values of movement off
    of the board deleted
    @see genMoves()
    **/
    public ArrayList<Coord> boundedMoves(ArrayList<Coord> allMoves){
        ArrayList<Coord> boundedMovesArray = new ArrayList<Coord>();

        for (Coord aMove : allMoves){
        	if (withinBoard(aMove) == true){
                boundedMovesArray.add(aMove);
        	}
        }

        return boundedMovesArray;
    }
    
    /** This is the "final word" mutator method which ultimately moves
    the current piece. Must have legalMove = true for movement to take place
    @param none.
    @see setPosition() in Piece class
    **/
	public void movePiece(Piece givenPiece, Coord moveTo){
        givenPiece.setPosition(moveTo);
	}


    // /** Checks if the pawn has reached the end of the board such that 
    // the test is to see if the pawn will upgrade
    // @param <currentPiece>: the piece in question, will pull coordinates
    // from the piece
    // @return none
    // **/
    // public void upgrade(){
    // 	// Conditional test to see if pawn needs to be upgraded
    // }
}
