import java.util.ArrayList;

public class Console{

	private String[][] chessBoard = { { "P1", "P2 ", "P3 ", "P4 ", "K2 " }, { "P1 ", ".  ", ".  ", ".  ", "P5 " },
			{ ".  ", ".  ", ".  ", ".  ", ".  " }, { "p1 ", ".  ", ".  ", ".  ", "p5 " },
			{ "k1 ", "p2 ", "p3 ", "p4 ", "k2 " } };

	public String[][] getBoard() {
		return chessBoard;

	}

	public void setBoard(char[][] board) {

	}

	public void placePiece(String piece, int row, int col) {
		chessBoard[row][col] = piece;
	}

	public void print() {
		for (int row = 0; row < 5; row++) {
			for (int column = 0; column < 5; column++) {
				System.out.print(chessBoard[row][column]);
			}
			System.out.println();
		}

        }

}
