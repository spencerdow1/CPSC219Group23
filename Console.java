
public class Console {
    
    private Piece currentPiece;
    private String displayName;
    /** This is the default which is an empty board 
    **/
    public static void displayEmpty(){

        // This is the i'th row
        for (int i=1; i<12; i++){

            // this is the j'th column
            for (int j=1; j<12; j++){
                
                // This handles the rows of vertical thingies
                if (i%2 != 0){
                	if (j%2 != 0){
                		if (j != 11){
                			System.out.print("-");
                		}
                		else {
                            System.out.println("-");
                		}
                	}
                	else {
                		System.out.print("---");
                	}
                }
                
                // this handles the rows where we need to put pieces in
                else {
                	if (j%2 != 0){
                		if (j != 11){
                			System.out.print("|");
                		}
                		else {
                			System.out.println("|");
                		}
                	}

                	else {
                		System.out.print("   ");
                	}

                }

            }
        }
    }


    public void displayBoard(Board aBoard){
        // This is the i'th row
        for (int i=1; i<12; i++){

            // this is the j'th column
            for (int j=1; j<12; j++){
                
                // This handles the rows of vertical thingies
                // this gets left alone for a board with pieces
                if (i%2 != 0){
                	if (j%2 != 0){
                		if (j != 11){
                			System.out.print("-");
                		}
                		else {
                            System.out.println("-");
                		}
                	}
                	else {
                		System.out.print("---");
                	}
                }
                
                // This handles the rows where we need to put pieces in
                else {
                	// this gets left alone when board has pieces
                	if (j%2 != 0){
                		if (j != 11){
                			System.out.print("|");
                		}
                		else {
                			System.out.println("|");
                		}
                	}

                    // This needs to get pieces from the board
                	else {
                		// Both these numbers are guaranteed to be EVEN from the
                		// boolean statements so we can be safe to divide by two
                		// subtract 1 to use 0 - 4 indexing for a 5x5 board
                		int xLoc = (int) (j/2 - 1);
                		int yLoc = (int) (i/2 - 1);
                		Coord boardPosition = new Coord(xLoc, yLoc);
                		// returns the piece from the board location and retrieves
                		// the display string of that piece
                        currentPiece = aBoard.getPiece(boardPosition);
                        displayName = currentPiece.getName();
                        // prints the display string in the appropriate location
                		System.out.print(displayName);
                	}

                }

            }
        }

    }

    public static void main(String args[]){
    	displayEmpty();
    }

    // public void display(Piece[][] Board){

    // }

}
