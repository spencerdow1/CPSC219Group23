import java.util.ArrayList;

public class Board {

	private Piece[][] currentBoard;
	private Piece retreivedPiece;

	// creates new board
	public Board() {
		currentBoard = new Piece[5][5];
	}

	public Board(ArrayList<Piece> alivePieces) {

		currentBoard = new Piece[5][5];

		for (Piece aPiece : alivePieces) {
			Coord location = aPiece.getPosition();
			setPiece(aPiece, location);
		}
	}

	// inititalizing the pieces
	public void initializePieces() {
		Coord initializer = new Coord(1, 0);
		currentBoard[1][0] = new Piece("pawn", "black", initializer, "p2");
		initializer = new Coord(2, 0);
		currentBoard[2][0] = new Piece("pawn", "black", initializer, "p3");
		initializer = new Coord(3, 0);
		currentBoard[3][0] = new Piece("pawn", "black", initializer, "p4");
		initializer = new Coord(0, 0);
		currentBoard[0][0] = new Piece("knight", "black", initializer, "k1");
		initializer = new Coord(0, 4);
		currentBoard[0][4] = new Piece("knight", "black", initializer, "k2");
		initializer = new Coord(0, 1);
		currentBoard[0][1] = new Piece("pawn", "black", initializer, "p1");
		initializer = new Coord(4, 1);
		currentBoard[4][1] = new Piece("pawn", "black", initializer, "p5");
		initializer = new Coord(0, 3);
		currentBoard[0][3] = new Piece("pawn", "white", initializer, "P1");
		initializer = new Coord(4, 3);
		currentBoard[4][3] = new Piece("pawn", "white", initializer, "P5");
		initializer = new Coord(0, 4);
		currentBoard[0][4] = new Piece("knight", "white", initializer, "K1");
		initializer = new Coord(4, 4);
		currentBoard[4][4] = new Piece("pawn", "white", initializer, "K2");
		initializer = new Coord(1, 4);
		currentBoard[1][4] = new Piece("pawn", "white", initializer, "P2");
		initializer = new Coord(2, 4);
		currentBoard[2][4] = new Piece("pawn", "white", initializer, "P3");
		initializer = new Coord(3, 4);
		currentBoard[3][4] = new Piece("pawn", "white", initializer, "P4");

	}

	public Piece getPiece(Coord aCoord) {
		int someX = aCoord.x;
		int someY = aCoord.y;

		if (currentBoard[someX][someY] != null) {
			retreivedPiece = currentBoard[someX][someY];
		} else {
			retreivedPiece = null;
		}

		return retreivedPiece;
	}

	public static Piece getPieceByName(String selectedPieceName) {
		Piece selectedPiece = null;

		for (int i = 0; i < pieces.size(); i++) {
			if (selectedPieceName == Piece.getName(pieces.get(i))) {
				selectedPiece = pieces.get(i);
			}

			else {
				selectedPiece = null;
			}
		}
		return selectedPiece;
	}

	public void setPiece(Piece aPiece, Coord aCoord) {

		currentBoard[aCoord.x][aCoord.y] = aPiece;
	}

}

/*
 * public void changePieceLocation(Piece pieceToChange) { Coord
 * storeMovementCoord = pieceToChange.getMovementCoord(); Coord
 * resetMovementCoord = new Coord(0, 0);
 *
 * pieceToChange.setMovementCoord(resetMovementCoord);
 * pieceToChange.setPosition(storeMovementCoord);
 *
 * }
 *
 * }
 */
