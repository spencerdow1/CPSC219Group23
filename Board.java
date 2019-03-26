import java.util.ArrayList;

public class Board {

	private Piece[][] currentBoard;

	// creates new board
	public Board() {
		currentBoard = new Piece[5][5];
	}

	public Board(GameSet aGameSet) {
        
		currentBoard = new Piece[5][5];
		ArrayList<Piece> gamePieces = aGameSet.getGamePieces();

		for (Piece aPiece : gamePieces) {
			Coord aLocation = aPiece.getPosition();
			setPiece(aPiece, aLocation);
		}
	}


	public void updateBoard(GameSet aGameSet){
        Coord location;
        currentBoard = new Piece[5][5];
        
		ArrayList<Piece> gamePieces = aGameSet.getGamePieces();

		for (Piece aPiece : gamePieces) {
			location = aPiece.getPosition();
			setPiece(aPiece, location);
		}
	}


    /** Note that this follows the matrix row column = i,j convention. NOTE 
    that the indices for i and j are different. This is so that the squares
    which hold the pieces will both land on multiples of 2 and include the 
    numbering system. **/
	public void printBoard() {
        Coord here;

		// This is the i'th row, and goes from 1-12 (inclusive)
		for (int i = 1; i <= 12; i++) {

			// this is the j'th column and goes from 0-11 (inclusive)
			for (int j = 0; j < 12; j++) {


				// This splits the problem into EVEN or ODD rows


                // LAST row
				if (i == 12){
					// if first entry
                    if (j == 0){
                    	// if at the BOTTOM
                        System.out.print("   ");
                    }
                    // if last entry print new line
                    else if (j == 11){
                       	System.out.println("x");
                    }
                    // if even column
                    else if (j % 2 != 0){
                       	System.out.print(" ");
                    }
                    // even columns
                    else {
                    	String col = Integer.toString(j/2 - 1);
                       	System.out.print(" "+col+" ");
                    }
				}


                // ODD rows 
				else if (i % 2 != 0){
					
					// if first entry
                    if (j == 0){
                    	// if at the top
                    	if (i == 1){
                    		System.out.print(" y ");
                    	}
                    	else {
                            System.out.print("   ");
                    	}
                    }
                    // if last entry print new line
                    else if (j == 11){
                       	System.out.println("-");
                    }
                    // if even column
                    else if (j % 2 != 0){
                       	System.out.print("-");
                    }
                    // even columns
                    else {
                       	System.out.print("---");
                    }
				}

                // EVEN rows (excluding last)
				else {
					// if first entry
                    if (j == 0){
                    	// if at the left hand side
                    	String row = Integer.toString( 5 - i/2 );
                        System.out.print(" "+row+" ");
                    }
                    // if last entry print new line
                    else if (j == 11){
                       	System.out.println("|");
                    }
                    // EVEN COLUMN and EVEN ROW (piece locations)
                    else if (j % 2 == 0){
                    	int hereX = j/2 - 1;
                    	int hereY = 5 - i/2;
                    	here = new Coord(hereX, hereY);
                    	Piece pieceHere = getPiece(here);
                    	if (pieceHere != null){
                    		System.out.print(pieceHere.getName());
                    	}
                    	else {
                    		System.out.print("   ");
                    	}
                    }
                    // ODD COLUMNS
                    else {
                    	System.out.print("|");
                    }
				}

			// column for loop	
			}
		// row for loop
		}
    // end of print board
	}


	public Piece getPiece(Coord aCoord) {
		int someX = aCoord.getXCoord();
		int someY = aCoord.getYCoord();
		Piece retrievedPiece;

		if (currentBoard[someX][someY] != null) {
			retrievedPiece = currentBoard[someX][someY];
		}
        else {
			retrievedPiece = null;
		}

		return retrievedPiece;
	}


	public void setPiece(Piece aPiece, Coord aCoord) {
		currentBoard[aCoord.getXCoord()][aCoord.getYCoord()] = aPiece;
	}

}