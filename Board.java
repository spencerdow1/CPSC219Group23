import java.util.ArrayList;

public class Board {

	private Piece piece;
	private ArrayList<Piece> pieces = new ArrayList<Piece>();

	public Board() {
		Piece tempPiece = new Piece();
		this.piece = tempPiece;
	}

	public Board(Piece piece) {
		this.piece = piece;

	}
	// inititalizing the pieces
	public void initializePieces(){
    // change black to lower case and white to upper
		Coord initializer = new Coord(1, 0);
		pieces.add(new Piece ("pawn", "black", initializer, "P2"));
		initializer = new Coord(2, 0);
	    pieces.add(new Piece ("pawn", "black", initializer, "P3"));
		initializer = new Coord(3, 0);
	    pieces.add(new Piece ("pawn", "black", initializer, "P4"));
		initializer = new Coord(0, 0);
	    pieces.add(new Piece ("knight", "black", initializer, "K1"));
		initializer = new Coord(0, 4);
     	pieces.add(new Piece ("knight", "black", initializer, "K2"));
		initializer = new Coord(0, 1);
     	pieces.add(new Piece ("pawn", "black", initializer, "P1"));
		initializer = new Coord(4, 1);
     	pieces.add(new Piece ("pawn", "black", initializer, "P5"));
		initializer = new Coord(0, 3);
     	pieces.add(new Piece ("pawn", "white", initializer, "p1"));
		initializer = new Coord(4, 3);
     	pieces.add(new Piece ("pawn", "white", initializer, "p5")); 
		initializer = new Coord(0, 4);
     	pieces.add(new Piece ("knight", "white", initializer, "k1"));
		initializer = new Coord(4, 4);
     	pieces.add(new Piece ("pawn", "white", initializer, "k2"));
		initializer = new Coord(1, 4);
     	pieces.add(new Piece ("pawn", "white", initializer, "p2"));
		initializer = new Coord(2, 4);
     	pieces.add(new Piece ("pawn", "white", initializer, "p3"));
		initializer = new Coord(3, 4);
     	pieces.add(new Piece ("pawn", "white", initializer, "p4"));


	}

//make methods that can test different pieces on the board ex. two knights going to the same spot
//

	public void changePieceLocation(Piece pieceToChange){
		Coord storeMovementCoord = pieceToChange.getMovementCoord();
		Coord resetMovementCoord = new Coord(0, 0);
		
		pieceToChange.setMovementCoord(resetMovementCoord);
		pieceToChange.setPosition(storeMovementCoord);

	}


}

