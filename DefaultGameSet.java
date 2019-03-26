
import java.util.ArrayList;

public class DefaultGameSet extends GameSet{

	public DefaultGameSet(){

		ArrayList<Piece> defaultPieces = new ArrayList<Piece>();

		defaultPieces.add( new Piece("pawn", "white", new Coord(0, 1), "WP1") );
		defaultPieces.add( new Piece("pawn", "white", new Coord(1, 0), "WP2") );
		defaultPieces.add( new Piece("pawn", "white", new Coord(2, 0), "WP3") );
		defaultPieces.add( new Piece("pawn", "white", new Coord(3, 0), "WP4") );
		defaultPieces.add( new Piece("pawn", "white", new Coord(4, 1), "WP5") );
		defaultPieces.add( new Piece("knight", "white", new Coord(0, 0), "WK1") );
		defaultPieces.add( new Piece("knight", "white", new Coord(4, 0), "WK2") );   
		defaultPieces.add( new Piece("pawn", "black", new Coord(0, 3), "BP1") );
		defaultPieces.add( new Piece("pawn", "black", new Coord(1, 4), "BP2") );
		defaultPieces.add( new Piece("pawn", "black", new Coord(2, 4), "BP3") );
		defaultPieces.add( new Piece("pawn", "black", new Coord(3, 4), "BP4") );
		defaultPieces.add( new Piece("pawn", "black", new Coord(4, 3), "BP5") );
		defaultPieces.add( new Piece("knight", "black", new Coord(0, 4), "BK1") );
		defaultPieces.add( new Piece("knight", "black", new Coord(4, 4), "BK2") );

		setGamePieces(defaultPieces);
	}

}
