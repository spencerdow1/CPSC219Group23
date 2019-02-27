import java.util.ArrayList;

public class Piece {
	private static ArrayList<Piece> alivePieces = new ArrayList<>();
	private Coord currentCoord;
	private Coord movementCoord;
	private String type;
	private String colour;
	private String name;
	
	
	public Piece(){
		this.currentCoord = new Coord(0, 0);
		this.movementCoord = new Coord(0, 0);
		this.type = "pawn";
		this.colour = "black";
		this.name = "p1";

    	}

    	public Piece(String initialType, String initialColour, Coord initialCoord, String initialName){

		this.type = initialType;
		this.colour = initialColour;
		this.currentCoord = initialCoord;
		this.movementCoord = new Coord(0, 0);
		this.name = initialName;
    	}

	public void setType(String type){
		this.type = type;
		
	}
	
	public String getType(){
		String copyType = this.type;
		
		return copyType;
	}

	public void setColour(String colour){
		this.type = type;
		
	}
	
	public String getColour(){
		String copyColour = this.colour;
		
		return copyColour;
	}

	public void setMovementCoord(Coord coord){
		this.movementCoord = coord;
		
	}
	
	public Coord getMovementCoord(){
		Coord copyCoord = new Coord();
        copyCoord = this.currentCoord;
		
		return copyCoord;
	}

	public void setPosition(Coord coord){
		this.currentCoord = coord;
		
	}
	
	public Coord getPosition(){
		Coord copyCoord = new Coord();
        copyCoord = this.currentCoord;
		
		return copyCoord;
	}

	public void setName(String name){
		this.name = name;
		
	}
	
	public String getName(){
		String copyName = this.name;
		
		return copyName;

	}
	public void initializePieces(){
	    // change black to lower case and white to upper
			Coord initializer = new Coord(1, 0);
			alivePieces.add(new Piece ("pawn", "black", initializer, "P2"));
			initializer = new Coord(2, 0);
		    alivePieces.add(new Piece ("pawn", "black", initializer, "P3"));
			initializer = new Coord(3, 0);
		    alivePieces.add(new Piece ("pawn", "black", initializer, "P4"));
			initializer = new Coord(0, 0);
		    alivePieces.add(new Piece ("knight", "black", initializer, "K1"));
			initializer = new Coord(0, 4);
	     	alivePieces.add(new Piece ("knight", "black", initializer, "K2"));
			initializer = new Coord(0, 1);
	     	alivePieces.add(new Piece ("pawn", "black", initializer, "P1"));
			initializer = new Coord(4, 1);
	     	alivePieces.add(new Piece ("pawn", "black", initializer, "P5"));
			initializer = new Coord(0, 3);
	     	alivePieces.add(new Piece ("pawn", "white", initializer, "p1"));
			initializer = new Coord(4, 3);
	     	alivePieces.add(new Piece ("pawn", "white", initializer, "p5")); 
			initializer = new Coord(0, 4);
	     	alivePieces.add(new Piece ("knight", "white", initializer, "k1"));
			initializer = new Coord(4, 4);
	     	alivePieces.add(new Piece ("pawn", "white", initializer, "k2"));
			initializer = new Coord(1, 4);
	     	alivePieces.add(new Piece ("pawn", "white", initializer, "p2"));
			initializer = new Coord(2, 4);
	     	alivePieces.add(new Piece ("pawn", "white", initializer, "p3"));
			initializer = new Coord(3, 4);
	     	alivePieces.add(new Piece ("pawn", "white", initializer, "p4"));


	}
	
	public static Piece getPiece(String selectedPieceName) {
        Piece selectedPiece = null ;
       
        for(int i = 0;i< alivePieces.size(); i++ ) {
            if(selectedPieceName == alivePieces.get(i).getName() {
                selectedPiece = alivePieces.get(i);
            }
           
            else {
                selectedPiece = null;
        }}
        return selectedPiece;
        }
	public static ArrayList<Piece> getCurrentListOfPieces(){
		return alivePieces;
	}

    public void upgrade(Piece piece){

        Coord piecePosition = new Coord(piece.getPosition());
        String pieceColour = piece.getColour();
        int pieceX = piecePosition.getX();
        String pieceName = piece.getName();
        String pieceType = piece.getType();
        //check for black pawn upgrade
        if(pieceColour == "black" && pieceType == "pawn"){
            if(pieceX == 4){
                setType("knight");
                setName(pieceName.replace("p", "k"));
            }
        //check for white pawn upgrade
        }else{
            if(pieceX == 0 && pieceType == "pawn"){
                setType("knight");
                setName(pieceName.replace("P", "K"));
            }
        }
        

    }



}

