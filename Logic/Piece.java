package Logic;


public class Piece {


	private Coord currentCoord;
	private String type;
	private String colour;
	private String name;
	private boolean isHighlighted = false;

	/**
	 *returns that the piece is highlighted
	 * @return
	 */
	public boolean isHighlighted() {
		return isHighlighted;
	}

	/**
	 *sets a piece to be highlighted
	 * @param isHighlighted
	 */
	public void setHighlighted(boolean isHighlighted) {
		this.isHighlighted = isHighlighted;
	}

	/**
	 *default piece conductor
	 */
	public Piece() {
		setPosition(new Coord());
		setType("NULL");
		setColour("NULL");
		setName("NULL");
	}

	/**
	 *constructer that creates a new piece with the following parameters
	 * @param initialType
	 * @param initialColour
	 * @param initialCoord
	 * @param initialName
	 */
	public Piece(String initialType, String initialColour, Coord initialCoord,
		String initialName) {

		setType(initialType);
		setColour(initialColour);
		setPosition(initialCoord);
		setName(initialName);
	}

	/**
	 *Copy constructor
	 * @param aPiece
	 */
	public Piece(Piece aPiece){
        setType(aPiece.getType());
        setColour(aPiece.getColour());
        setPosition(aPiece.getPosition());
        setName(aPiece.getName());
	}

	/**
	 *sets the piece type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 *gets the piece type
	 * @return
	 */
	public String getType() {
		String copyType = type;
		return copyType;
	}

	/**
	 *sets the piece colour
	 * @param colour
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**gets the piece colour
	 *
	 * @return
	 */
	public String getColour() {
		String copyColour = colour;
		return copyColour;
	}

	/**
	 *sets the piece position
	 * @param coord
	 */
	public void setPosition(Coord coord) {
		currentCoord = coord;
	}

	/**
	 *gets the piece position
	 * @return
	 */
	public Coord getPosition() {
		Coord copyCoord = new Coord(currentCoord);
		return copyCoord;
	}

	/**
	 *sets the piece name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets the piece name
	 * @return
	 */
	public String getName() {
		String copyName = name;
		return copyName;
	}

	/**
	 * changes piece from pawn to knight if it reaches the opposite end of the board
	 */
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
