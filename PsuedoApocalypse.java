
import java.util.ArrayList;


public class PsuedoApocalypse{

    private String teamTurn;
    private Coord whitePieceSelection;
    private Coord whitePieceMove;
    private Coord blackPieceSelection;
    private Coord blackPieceMove;
    private ArrayList<Coord> allMoves;


	public PsuedoApocalypse(){
        // this is where we will generate a new game, for now just fill
        // this space with some IO jargon.
        System.out.println("WELCOME TO PSUEDO-APOCALYPSE!!!");
        System.out.println("");
	}

    public void setAllMoves(){
    	allMoves = new ArrayList<Coord>();
        
        allMoves.add(getWhitePieceSelection());
        allMoves.add(getWhitePieceMove());
        allMoves.add(getBlackPieceSelection());
        allMoves.add(getBlackPieceMove());
    }

    public ArrayList<Coord> getAllMoves(){
    	ArrayList<Coord> copyMoves = new ArrayList<Coord>(allMoves);
    	return copyMoves;
    }

	public void setTeamTurn(String turnColor){
		System.out.println(turnColor + " team make your moves:");
        teamTurn = turnColor;
	}


	public void setWhitePieceSelection(Coord aSelection){
		whitePieceSelection = aSelection;
	}


	public Coord getWhitePieceSelection(){
		Coord copyCoord = new Coord(whitePieceSelection);
		return copyCoord;
	}


	public void setWhitePieceMove(Coord aMove){
		whitePieceMove = aMove;
	}


	public Coord getWhitePieceMove(){
		Coord copyCoord = new Coord(whitePieceMove);
		return copyCoord;
	}


	public void setBlackPieceSelection(Coord aSelection){
		blackPieceSelection = aSelection;
	}


	public Coord getBlackPieceSelection(){
		Coord copyCoord = new Coord(blackPieceSelection);
		return copyCoord;
	}


	public void setBlackPieceMove(Coord aMove){
        blackPieceMove = aMove;
	}


	public Coord getBlackPieceMove(){
		Coord copyCoord = new Coord(blackPieceMove);
		return copyCoord;
	}

}
