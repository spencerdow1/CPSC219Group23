
import java.util.ArrayList;

public class CustomGameSet extends GameSet{

	ArrayList<Piece> customSet;


	public CustomGameSet(ArrayList<Piece> aGameSet){
        super.setGamePieces(aGameSet);
	}


	public CustomGameSet(int setNum){

		if (setNum == 1){
            super.setGamePieces(createCustomSetOne());
		}
		else if (setNum == 2){
			super.setGamePieces(createCustomSetTwo());
		}

		else {
			System.out.print("No constructor or custom game set number ");
			System.out.println("for set number "+setNum);
		}
	}


	public CustomGameSet(Piece pieceOne){
        customSet = new ArrayList<Piece>();
        customSet.add(pieceOne);
        setGamePieces(customSet);
	}


	public CustomGameSet(Piece pieceOne, Piece pieceTwo){
        customSet = new ArrayList<Piece>();
        customSet.add(pieceOne);
        customSet.add(pieceTwo);
        setGamePieces(customSet);
	}


	public CustomGameSet(Piece pieceOne, Piece pieceTwo, Piece pieceThree){
        customSet = new ArrayList<Piece>();
        customSet.add(pieceOne);
        customSet.add(pieceTwo);
        customSet.add(pieceThree);
        setGamePieces(customSet);
	}


	public CustomGameSet(Piece pieceOne, Piece pieceTwo, Piece pieceThree,
		Piece pieceFour){
        customSet = new ArrayList<Piece>();
        customSet.add(pieceOne);
        customSet.add(pieceTwo);
        customSet.add(pieceThree);
        customSet.add(pieceFour);
        setGamePieces(customSet);
	}


	public ArrayList<Piece> createCustomSetOne(){
        customSet = new ArrayList<Piece>();
        Piece whitePawn1 = new Piece("pawn", "white", new Coord(2,0), "p1");
        Piece blackPawn2 = new Piece("pawn", "black", new Coord(2,4), "P2");
        customSet.add(whitePawn1);
        customSet.add(blackPawn2);

        return customSet;
	}


    public ArrayList<Piece> createCustomSetTwo(){
    	customSet = new ArrayList<Piece>();
	    Piece pawn1 = new Piece("pawn", "white", new Coord(2,2), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(1,3), "BP1");
        Piece pawn3 = new Piece("pawn", "black", new Coord(3,3), "BP2");
        Piece knight1 = new Piece("knight", "white", new Coord(0,0), "WK1");
        customSet.add(pawn1);
        customSet.add(pawn2);
        customSet.add(pawn3);
        customSet.add(knight1);

        return customSet;
    }

}
