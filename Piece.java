public class Piece {
	// private ArrayList<Piece> alivePieces = new ArrayList<>();
	private Coord currentCoord;
	private Coord movementCoord;
	private String type;
	private String colour;
	private String name;

	public Piece() {
		this.currentCoord = new Coord(0, 0);
		this.movementCoord = new Coord(0, 0);
		this.type = "pawn";
		this.colour = "black";
		this.name = "p1";

	}

	public Piece(String initialType, String initialColour, Coord initialCoord,
		String initialName) {

		this.type = initialType;
		this.colour = initialColour;
		this.currentCoord = initialCoord;
		this.movementCoord = new Coord(0, 0);
		this.name = initialName;
	}


	public Piece(Piece aPiece){
        setType(aPiece.getType());
        setColour(aPiece.getColour());
        setPosition(aPiece.getPosition());
        setName(aPiece.getName());
	}


	public void setType(String type) {
		this.type = type;

	}

	public String getType() {
		String copyType = this.type;

		return copyType;
	}

	public void setColour(String colour) {
		this.colour = colour;

	}

	public String getColour() {
		String copyColour = this.colour;

		return copyColour;
	}

	public void setMovementCoord(Coord coord) {
		this.movementCoord = coord;

	}

	public Coord getMovementCoord() {
		Coord copyCoord = new Coord();
		copyCoord = this.currentCoord;

		return copyCoord;
	}

	public void setPosition(Coord coord) {
		this.currentCoord = coord;

	}

	public Coord getPosition() {
		Coord copyCoord = new Coord();
		copyCoord = this.currentCoord;

		return copyCoord;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getName() {
		String copyName = this.name;

		return copyName;
	}

	public void upgrade(Piece piece) {

		Coord piecePosition = new Coord(piece.getPosition());
		String pieceColour = piece.getColour();
		int pieceY = piecePosition.getYCoord();
		String pieceName = piece.getName();
		String pieceType = piece.getType();
		// check for black pawn upgrade
		if (pieceColour == "black" && pieceType == "pawn") {
			if (pieceY == 4) {
				setType("knight");
				setName(pieceName.replace("p", "k"));
			}
			// check for white pawn upgrade
		} else {
			if (pieceY == 0 && pieceType == "pawn") {
				setType("knight");
				setName(pieceName.replace("P", "K"));
			}
		}

	}

}
