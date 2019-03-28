package GUI;

import GUI.Piece;

import java.util.ArrayList;

public abstract class GameSet{

	private ArrayList<Piece> whitePieces;
	private ArrayList<Piece> blackPieces;
	private ArrayList<Piece> gamePieces;

	public GameSet(){
		// default everything to zero
		whitePieces = new ArrayList<Piece>();
        blackPieces = new ArrayList<Piece>();
        gamePieces = new ArrayList<Piece>();
	}


    /** These are add and remove functions. We do not need them for now but
    we will use them later for sure
    **/
	public void addPiece(Piece aPiece){
        gamePieces.add(aPiece);
        setWhiteAndBlackPieces(gamePieces);
	}


	public int getSize(){
		int theSize = gamePieces.size();
		return theSize;
	}

	public void removePiece(int index){
        ArrayList<Piece> copyList = new ArrayList<Piece>();
        for (int i=0; i<gamePieces.size(); i++){
            if (i != index){
                copyList.add(gamePieces.get(i));
            }
        }
        gamePieces = copyList;
        setWhiteAndBlackPieces(gamePieces);
	}

	public void removePieces(int n, int m){
        ArrayList<Piece> copyList = new ArrayList<Piece>();
        for (int i=0; i<gamePieces.size(); i++){
            if (i != n && i != m){
                copyList.add(gamePieces.get(i));
            }
        }
        gamePieces = copyList;
        setWhiteAndBlackPieces(gamePieces);
	}

	public ArrayList<Piece> getWhitePieces(){
        ArrayList<Piece> copyList = new ArrayList<Piece>(whitePieces);
        return copyList;
	}

	public ArrayList<Piece> getBlackPieces(){
        ArrayList<Piece> copyList = new ArrayList<Piece>(blackPieces);
        return copyList;
	}


    protected void setWhiteAndBlackPieces(ArrayList<Piece> aPieceList){
        String theColour;
        whitePieces = new ArrayList<Piece>();
        blackPieces = new ArrayList<Piece>();

        for (Piece aPiece : aPieceList){
            theColour = aPiece.getColour();

            if (theColour == "white"){
                whitePieces.add(aPiece);
            }
            else if (theColour == "black"){
                blackPieces.add(aPiece);
            }
            else {
            	System.out.println("Invalid Colour found in GameSet.");
            }
        }
    }


	public ArrayList<Piece> getGamePieces(){
        ArrayList<Piece> copyList = new ArrayList<Piece>(gamePieces);
        return copyList;
	}


    public Piece getPiece(int i){
        return gamePieces.get(i);
    }


    public Piece getPieceCopyFromSet(int i){
    	Piece copyPiece;

    	if (i >= 0 && i < gamePieces.size()){
    	    copyPiece = new Piece(gamePieces.get(i));
    	}
    	else {
    		copyPiece = null;
    		System.out.print("Index out of bounds for getPieceCopyFromSet()");
    		System.out.println(", returned null.");
    	}
        return copyPiece;	
    }


	protected void setGamePieces(ArrayList<Piece> aPieceList){
        gamePieces = new ArrayList<Piece>(aPieceList);
        setWhiteAndBlackPieces(aPieceList);
	}


    public String toString(){
        int numPieces = gamePieces.size();
        String pieceName;
        int i = 0;
        String gameString = "";

        for (Piece aPiece : gamePieces){
            i ++;
            pieceName = aPiece.getName();

            if (i == numPieces){
                gameString = gameString + pieceName;
            }
            else {
                gameString = gameString + pieceName+", ";
            }
        }

        return gameString;
    }


    public String toString(ArrayList<Piece> aList){
        int numPieces = aList.size();
        String pieceName;
        int i = 0;
        String gameString = "";

        for (Piece aPiece : aList){
            i ++;
            pieceName = aPiece.getName();

            if (i == numPieces){
                gameString = gameString + pieceName;
            }
            else {
                gameString = gameString + pieceName+", ";
            }
        }

        return gameString;
    }


    public Piece getPieceByCoord(Coord location){
        int counter = -1;
        int length = gamePieces.size();
        // initialize to the first piece so it returns something
        Piece thePiece;
        Coord pieceCoord;
        boolean foundPiece = false;

        if (length > 0){
            // initialize the piece so the compiler doesnt complain
            thePiece = gamePieces.get(0);

            for (Piece aPiece : gamePieces){
                counter ++;
                pieceCoord = aPiece.getPosition();

                if (pieceCoord.equals(location)){
                    thePiece = gamePieces.get(counter);
                    foundPiece = true;
                }

                else if (counter == length && foundPiece == false){
                    // this means end of the list was reached but 
                    // no piece was found
                    System.out.print("No piece found in getPieceByCoord.");
                    System.out.println(" Returned first piece.");
                }
            }
        }

        else {
            thePiece = new Piece("pawn", "white", new Coord(0,0), "NULL");
            System.out.println("Searched for piece in size 0 GameSet.");
        }

        return thePiece;
    }


    public int getPieceIndexByCoord(Coord location){
        int counter = -1;
        int length = gamePieces.size();
        int theIndex = 0;
        Coord pieceCoord;
        boolean foundPiece = false;

        if (length > 0){

            for (Piece aPiece : gamePieces){
                counter ++;
                pieceCoord = aPiece.getPosition();

                if (pieceCoord.equals(location)){
                    theIndex = counter;
                    foundPiece = true;
                }

                else if (counter == length - 1 && foundPiece == false){
                    // this means end of the list was reached but 
                    // no piece was found
                    System.out.print("No piece found in getPieceByCoord.");
                    System.out.println(" Returned first piece.");
                }
            }
        }

        else {
            System.out.println("Searched for piece in size 0 GameSet.");
        }

        return theIndex;
    }

}
