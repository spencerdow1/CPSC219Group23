mport java.util.ArrayList

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

		Coord initializer = Coord(1, 0);
		pieces.add(new Piece ("pawn", "black", intitializer, "P2"));
		initializer = Coord(2, 0);
	    	pieces.add(new Piece ("pawn", "black", intitializer, "P3"));
		initializer = Coord(3, 0);
	     	pieces.add(new Piece ("pawn", "black", intitializer, "P4"));
		initializer = Coord(0, 0);
	     	pieces.add(new Piece ("knight", "black", intitializer, "K1"));
		initializer = Coord(0, 4);
     		pieces.add(new Piece ("knight", "black", intitializer, "K2"));
		initializer = Coord(0, 1);
     		pieces.add(new Piece ("pawn", "black", intitializer, "P1"));
		initializer = Coord(4, 1);
     		pieces.add(new Piece ("pawn", "black", intitializer, "P5"));
		initializer = Coord(0, 3);
     		pieces.add(new Piece ("pawn", "white", intitializer, "p1"));
		initializer = Coord(4, 3);
     		pieces.add(new Piece ("pawn", "white", intitializer, "p5")); 
		initializer = Coord(0, 4);
     		pieces.add(new Piece ("knight", "white", intitializer, "k1"));
		initializer = Coord(4, 4);
     		pieces.add(new Piece ("pawn", "white", intitializer, "k2"));
		initializer = Coord(1, 4);
     		pieces.add(new Piece ("pawn", "white", intitializer, "p2"));
		initializer = Coord(2, 4);
     		pieces.add(new Piece ("pawn", "white", intitializer, "p3"));
		initializer = Coord(3, 4);
     		pieces.add(new Piece ("pawn", "white", intitializer, "p4"));


	}

	public Piece changePieceLocation(Piece pieceToChange){
		Coord storeMovementCoord = pieceToChange.getMovementCoord();
		Coord resetMovementCoord = Coord(0, 0);
		
		pieceToChange.setMovementCoord(resetMovementCoord);
		pieceToChange.setCurrentCoord(storeMovementCoord);

	}


}

