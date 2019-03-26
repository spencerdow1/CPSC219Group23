
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

	// public void removePiece(String pieceName){
 //        // remove piece by name
 //        // make sure that the white or black piece list is updated
 //        // when a piece is removed
 //        setWhiteAndBlackPieces(gamePieces);
	// }

	// public void removePiece(int index){
	// 	// remove piece by index in arrayList
	// 	setWhiteAndBlackPieces(gamePieces);
	// }

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

}
