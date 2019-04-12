package Logic;


public class Piece {


	private Coord currentCoord;
	private String type;
	private String colour;
	private String name;
	private boolean isHighlighted = false;

	/**
	 *
	 * @return
	 */
	public boolean isHighlighted() {
		return isHighlighted;
	}

	/**
	 *
	 * @param isHighlighted
	 */
	public void setHighlighted(boolean isHighlighted) {
		this.isHighlighted = isHighlighted;
	}

	/**
	 *
	 */
	public Piece() {
		setPosition(new Coord());
		setType("NULL");
		setColour("NULL");
		setName("NULL");
	}

	/**
	 *
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
	 *
	 * @param aPiece
	 */
	public Piece(Piece aPiece){
        setType(aPiece.getType());
        setColour(aPiece.getColour());
        setPosition(aPiece.getPosition());
        setName(aPiece.getName());
	}

	/**
	 *
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 *
	 * @return
	 */
	public String getType() {
		String copyType = type;
		return copyType;
	}

	/**
	 *
	 * @param colour
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 *
	 * @return
	 */
	public String getColour() {
		String copyColour = colour;
		return copyColour;
	}

	/**
	 *
	 * @param coord
	 */
	public void setPosition(Coord coord) {
		currentCoord = coord;
	}

	/**
	 *
	 * @return
	 */
	public Coord getPosition() {
		Coord copyCoord = new Coord(currentCoord);
		return copyCoord;
	}

	/**
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		String copyName = name;
		return copyName;
	}

	/**
	 *
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
