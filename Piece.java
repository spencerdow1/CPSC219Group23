


public class Pieces {
	//private List<Pieces> pieces = new ArrayList<>();
	private Coord currentCoord;
	private Coord movementCoord;
	private String type;
	private String colour;
	private String name;
  

	public Piece(){
		this.currentCoord = Coord(0, 0);
		this.movementCoord = Coord(0, 0);
		this.type = “pawn”;
		this.colour = “black";
		this.name = "p1";

    	}

    	public Piece(String inititalType, String intitialColour, Coord initialCoord, String inititalName){

		this.type = initialType;
		this.colour = inititalColour;
		this.currentCoord = initialCoord;
		this.movementCoord = Coord(0, 0);
		this.name = intitialName;
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
	
	public String getMovementCoord(){
		String copyCoord = this.movementCoord;
		
		return copyCoord;
	}

	public void setCurrentCoord(Coord coord){
		this.currentCoord = coord;
		
	}
	
	public String getCurrentCoord(){
		String copyCoord = this.currentCoord;
		
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

