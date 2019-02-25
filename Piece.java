


public class Piece {
	//private List<Pieces> pieces = new ArrayList<>();
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



}

