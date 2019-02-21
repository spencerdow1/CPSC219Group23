
public class Piece{

	public String color;
	public String type;
	public int number;
	public Coord position;
	public String display;

    public Piece(){
    	this.color = " none ";
    	this.type = " none ";
    	this.display = " none ";
    	this.position = new Coord( 0, 0 );
    	this.number = 0;
    }

    public Piece(String pieceColor, String pieceType, int pieceNumber,
    	Coord somePosition){

        setPieceColor(pieceColor);
        setPieceType(pieceType);
        setPieceNumber(pieceNumber);
        setPosition(somePosition);

        // make sure these return copies for proper encapsulation
        this.color = getPieceColor();
        this.type = getPieceType();
        this.number = getPieceNumber();
        this.position = getPosition();
        // generate a console string with all the information regarding the piece
        this.display = displayString();
    }

    public void setPosition(Coord somePosition){
        position = somePosition;
    }

    public Coord getPosition(){
        Coord copyPosition = position;
        return copyPosition;
    }

    public void setPieceColor(String someColor){
        color = someColor;
    }

    public String getPieceColor(){
        String copyColor = color;
        return copyColor;
    }

    public void setPieceType(String someType){
        type = someType;
    }

    public String getPieceType(){
        String copyPieceType = type;
        return copyPieceType;
    }

    public void setPieceNumber(int someNumber){
        number = someNumber;
    }

    public int getPieceNumber(){
        int copyNumber = number;
        return copyNumber;
    }

    public String displayString(){
        String consoleString;
        String thePieceType = getPieceType();
        String thePieceColor = getPieceColor();
        String thePieceNumber = Integer.toString(getPieceNumber());

        if (thePieceType == "pawn" && thePieceColor == "white"){
            consoleString = "P";
        }

        else if (thePieceType == "pawn" && thePieceColor == "black"){
            consoleString = "p";
        }

        else if (thePieceType == "knight" && thePieceColor == "white"){
            consoleString = "K";
        }

        else if (thePieceType == "knight" && thePieceColor == "black"){
            consoleString = "k";
        }

        else {
        	consoleString = "none";
        }

        consoleString += thePieceNumber;

        return consoleString;
    }

    public String toString(){
        String printString;
        String thePieceType = getPieceType();
        String thePieceColor = getPieceColor();
        String thePieceNumber = Integer.toString(getPieceNumber());

        printString = "("+thePieceColor+" "+thePieceType+", "+thePieceNumber+")";
        
        return printString;
    }


}
