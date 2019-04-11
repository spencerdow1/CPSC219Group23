package GUI;

public class Piece {


	private Coord currentCoord;
	private String type;
	private String colour;
	private String name;
	private boolean isHighlighted;

	public boolean isHighlighted() {
		return isHighlighted;
	}


	public void setHighlighted(boolean isHighlighted) {
		this.isHighlighted = isHighlighted;
	}


	public Piece() {
		setPosition(new Coord());
		setType("NULL");
		setColour("NULL");
		setName("NULL");
		setHighlighted(!isHighlighted);
	}


	public Piece(String initialType, String initialColour, Coord initialCoord,
		String initialName) {

		setType(initialType);
		setColour(initialColour);
		setPosition(initialCoord);
		setName(initialName);
		setHighlighted(!isHighlighted);
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
		String copyType = type;
		return copyType;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public String getColour() {
		String copyColour = colour;
		return copyColour;
	}


	public void setPosition(Coord coord) {
		currentCoord = coord;
	}


	public Coord getPosition() {
		Coord copyCoord = new Coord(currentCoord);
		return copyCoord;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		String copyName = name;
		return copyName;
	}


	public void upgrade() {
		
		if (type.equals("pawn")){
    		int pieceY = currentCoord.getYCoord();

            if (pieceY == 0){
                if (colour.equals("black")){
                	setType("knight");
                	setName(name.replace("P", "K"));
                }
            }

            else if (pieceY == 4){
            	if (colour.equals("white")){
            		setType("knight");
            		setName(name.replace("P", "K"));
            	}
            }
		}
	}


}
