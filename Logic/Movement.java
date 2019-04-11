package Logic;

import java.util.ArrayList;

public class Movement {


	/**
	 * Simple boolean determining if the move is allowed given the rules
	 * @param <selectedPiece>: the piece to check for moves <move>: The
	 *        Coord.location to move to
	 * @return <isLegalMove> boolean if the move is legal
	 * @see Coord class
	 **/
	public boolean legalMove(Piece selectedPiece, Board aBoard, Coord move){
		boolean isLegalMove = false;
		ArrayList<Coord> allowedMovesArray = genMoves(selectedPiece, aBoard);

		// use genmoves to populate a list, then check it to see if the move
		// is in it;
		if (allowedMovesArray.size() > 0)
			for (Coord possibleMove : allowedMovesArray)
				// Need to compare field variables of Coord object
				if (possibleMove.x == move.x && possibleMove.y == move.y) {
					isLegalMove = true;
				}

		return isLegalMove;
	}


	/**
	 * Checks the board for pieces which are congruent with the locations of all the
	 * generated moves. This determines if a piece can move to a position held by
	 * the opposite color OR if the piece cannot move as it is already held by a
	 * piece of the same color.
	 * 
	 * @param <aMoveArray>: Expects this array to not have values outside of the
	 *        board
	 * @see boundedMoves()
	 * @return <legalMoves>: Final list of allowed moves for that piece
	 **/
	public ArrayList<Coord> allowedMoves(Piece aPiece, Board aBoard,
		ArrayList<Coord> aMoveArray){

		ArrayList<Coord> legalMoves = new ArrayList<Coord>();
		String currentPieceColour = aPiece.getColour();
		Piece referencePiece;		
		String referencePieceColour;

		for (Coord aPosition : aMoveArray) {
			referencePiece = aBoard.getPiece(aPosition);

			if (referencePiece == null) {
				legalMoves.add(aPosition);
			}

			// if there is a piece, what color?
			else {
				referencePieceColour = referencePiece.getColour();

				if (referencePieceColour != currentPieceColour) {
					legalMoves.add(aPosition);
				}
			}
		}

		return legalMoves;
	}


	/** Populates a list of tuples representing the allowed moves
	 * @param <pieceColor>: Needs the color to determine movement <pieceType>: Needs
	 *        the piece type (knight, pawn) to determine movement
	 * @return <moveList>: The populated list
	**/
	private ArrayList<Coord> allMoves(Piece somePiece, Board aBoard) {
		String pieceType = somePiece.getType();
		String pieceColor = somePiece.getColour();
		Coord piecePosition = somePiece.getPosition();
		ArrayList<Coord> moveList = new ArrayList<Coord>();
		Coord forwardIndex, leftIndex, rightIndex;
		Piece forwardPiece, leftPiece, rightPiece;

		// logical fuckery of populating list of tuples
		// TWO CASES FOR PIECES

		// KNIGHT
		if (pieceType == "knight") {
			// Generate moves for knights
			if (pieceColor == "white" || pieceColor == "black") {
				// Only 8 permutations -- manually enter them
				moveList.add(new Coord(-2, 1));
				moveList.add(new Coord(-1, 2));
				moveList.add(new Coord(1, 2));
				moveList.add(new Coord(2, 1));
				moveList.add(new Coord(2, -1));
				moveList.add(new Coord(1, -2));
				moveList.add(new Coord(-1, -2));
				moveList.add(new Coord(-2, -1));

				for (int i = 0; i < moveList.size(); i++) {
					Coord aMove = moveList.get(i);
					aMove.add(piecePosition);
					moveList.set(i, aMove);
				}
			}

			else {
				System.out.print("Invalid piece color found in type <knight>.");
			}
		}

		// PAWN
		else if (pieceType == "pawn") {
			// FURTHER BROKEN UP INTO TWO CASES FOR PAWN
			// WHITE PAWN

			if (pieceColor == "white") {
				forwardIndex = new Coord(piecePosition);
				forwardIndex.add(0, 1);
				leftIndex = new Coord(piecePosition);
				leftIndex.add(-1, 1);
				rightIndex = new Coord(piecePosition);
				rightIndex.add(1, 1);
			}

			// BLACK PAWN
			else if (pieceColor == "black") {
				forwardIndex = new Coord(piecePosition);
				forwardIndex.add(0, -1);
				leftIndex = new Coord(piecePosition);
				leftIndex.add(-1, -1);
				rightIndex = new Coord(piecePosition);
				rightIndex.add(1, -1);
			}

			else {
				System.out.println("Invalid piece color found in type <pawn>.");
				// sets indices to where the piece is if there is an error
				forwardIndex = somePiece.getPosition();
				leftIndex = forwardIndex;
				rightIndex = forwardIndex;
			}

            // get the pieces adjacent to the pawn
            if (withinBoard(forwardIndex)){
                forwardPiece = aBoard.getPiece(forwardIndex);
             	if (forwardPiece == null) {
				    moveList.add(forwardIndex);
			    }
            }

            if (withinBoard(leftIndex)){
                leftPiece = aBoard.getPiece(leftIndex);
                if (leftPiece != null){
                	moveList.add(leftIndex);
                }
            }

            if (withinBoard(rightIndex)){
                rightPiece = aBoard.getPiece(rightIndex);
                if (rightPiece != null){
                	moveList.add(rightIndex);
                }
            }
			
		}

		else {
			System.out.println("Invalid piece type found in allMoves.");
		}

		return moveList;
	}


	/**
	 * Method which simply checks to see if the coordinates are within the board.
	 * Here, board size of 0 to 4 is assumed for Apocalypse.
	 * @param <location>: the input coordinate location
	 * @return boolean <inBounds>: true false for if the location is in the board.
	**/
	public boolean withinBoard(Coord location) {
		boolean inBounds;

		if (location.x >= 0 && location.x <= 4) {
			if (location.y >= 0 && location.y <= 4) {
				inBounds = true;
			} else {
				inBounds = false;
			}
		} else {
			inBounds = false;
		}
		return inBounds;
	}

	/**
	 * Take in the list of coordinates and eliminate the ones which move the piece
	 * off the board
	 * 
	 * @param <allMoves>: the list of tuples of possible moves
	 * @return <boundedMovesArray>: the list with values of movement off of the
	 *         board deleted
	 * @see genMoves()
	**/
	public ArrayList<Coord> boundedMoves(ArrayList<Coord> allMoves) {
		ArrayList<Coord> boundedMovesArray = new ArrayList<Coord>();

		for (Coord aMove : allMoves) {
			if (withinBoard(aMove) == true) {
				boundedMovesArray.add(aMove);
			}
		}

		return boundedMovesArray;
	}


	/**
	 * This is the "final word" mutator method which ultimately moves the current
	 * piece. Must have legalMove = true for movement to take place
	 * @param none.
	 * @see setPosition() in Piece class
	**/
	public void movePiece(Piece givenPiece, Coord moveTo) {
		givenPiece.setPosition(moveTo);
	}


    /** This class generates a list of possible moves given the state of the
    board and the chosen piece **/
    public ArrayList<Coord> genMoves(Piece givenPiece, Board currentBoard){
        ArrayList<Coord> allMovesArray = allMoves(givenPiece, currentBoard);
		ArrayList<Coord> boundedMovesArray = boundedMoves(allMovesArray);
		ArrayList<Coord> allowedMovesArray = allowedMoves(givenPiece,
			currentBoard, boundedMovesArray);
		return allowedMovesArray;
    }    

}