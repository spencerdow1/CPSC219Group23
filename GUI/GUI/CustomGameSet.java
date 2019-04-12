package GUI;

import java.util.ArrayList;

public class CustomGameSet extends GameSet {

	ArrayList<Piece> customSet;

    /**
     *
     * @param aGameSet
     */
	public CustomGameSet(ArrayList<Piece> aGameSet){
        super.setGamePieces(aGameSet);
	}

    /**
     *
     * @param setNum
     */
	public CustomGameSet(int setNum){

		if (setNum == 1){
            super.setGamePieces(createCustomSetOne());
		}
		else if (setNum == 2){
			super.setGamePieces(createCustomSetTwo());
		}
		else if (setNum == 3){
			super.setGamePieces(createCustomSetThree());
		}
        else if (setNum == 4){
            super.setGamePieces(createCustomSetFour());
        }
        else if (setNum == 5){
            super.setGamePieces(createCustomSetFive());
        }
		else {
			System.out.print("No constructor or custom game set number ");
			System.out.println("for set number "+setNum);
		}
	}

    /**
     *
     * @param pieceOne
     */
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

    /**
     *
     * @param pieceOne
     * @param pieceTwo
     * @param pieceThree
     */
	public CustomGameSet(Piece pieceOne, Piece pieceTwo, Piece pieceThree){
        customSet = new ArrayList<Piece>();
        customSet.add(pieceOne);
        customSet.add(pieceTwo);
        customSet.add(pieceThree);
        setGamePieces(customSet);
	}

    /**
     *
     * @param pieceOne
     * @param pieceTwo
     * @param pieceThree
     * @param pieceFour
     */
	public CustomGameSet(Piece pieceOne, Piece pieceTwo, Piece pieceThree,
                         Piece pieceFour){
        customSet = new ArrayList<Piece>();
        customSet.add(pieceOne);
        customSet.add(pieceTwo);
        customSet.add(pieceThree);
        customSet.add(pieceFour);
        setGamePieces(customSet);
	}

    /**
     *
     * @return
     */
	public ArrayList<Piece> createCustomSetOne(){
        customSet = new ArrayList<Piece>();
        Piece whitePawn1 = new Piece("pawn", "white", new Coord(2,0), "p1");
        Piece blackPawn2 = new Piece("pawn", "black", new Coord(2,4), "P2");
        customSet.add(whitePawn1);
        customSet.add(blackPawn2);

        return customSet;
	}

    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
    public ArrayList<Piece> createCustomSetThree(){
    	customSet = new ArrayList<Piece>();
    	Piece pawn1 = new Piece("pawn", "white", new Coord(2,1), "WP1");
    	Piece pawn2 = new Piece("pawn", "black", new Coord(2,4), "BP1");
    	customSet.add(pawn1);
    	customSet.add(pawn2);
    	return customSet;
    }

    /**
     *
     * @return
     */
    public ArrayList<Piece> createCustomSetFour(){
        customSet = new ArrayList<Piece>();
        Piece pawn1 = new Piece("pawn", "white", new Coord(4,0), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(4,1), "BP1");
        Piece knight3 = new Piece("knight", "white", new Coord(2,2), "WK2");
        Piece knight4 = new Piece("knight", "black", new Coord(0,4), "BK2");
        customSet.add(pawn1);
        customSet.add(pawn2);
        customSet.add(knight3);
        customSet.add(knight4);
        return customSet;
    }

    /**
     *
     * @return
     */
    public ArrayList<Piece> createCustomSetFive(){
        customSet = new ArrayList<Piece>();
        Piece pawn1 = new Piece("pawn", "white", new Coord(0,3), "WP1");
        Piece pawn2 = new Piece("pawn", "black", new Coord(0,4), "BP1");
        Piece knight3 = new Piece("knight", "white", new Coord(1,3), "WK2");
        Piece pawn4 = new Piece("pawn", "black", new Coord(1,4), "BP2");
        customSet.add(pawn1);
        customSet.add(pawn2);
        customSet.add(knight3);
        customSet.add(pawn4);
        return customSet;
    }



}
