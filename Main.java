import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Piece white;
    private Piece black;
	private Player whitePlayerName;
	private Player blackPlayerName;
    //winCondition will search the list for pawns of each color and return whether the game is over and will print who won

    public boolean winCondition( ArrayList<Piece> arraylist){
        boolean win = false;
        boolean whiteWin = arraylist.contains('P');
        boolean blackWin = arraylist.contains('p');
        
        if (whiteWin == true && blackWin == true){
            
        	win = true;
            
        	System.out.println("You have tied! Play again?");
            return win;
        }
        
        else if(whiteWin == false && blackWin == true){
            
        	win = true;
            
        	System.out.println("Player White has won! Play again?");
            return win;
        }
        
        else if(whiteWin == true && blackWin == false) {
            
        	win = true;
            System.out.println("Player Black has won! Play again?");
            
            return win;
        }
        else{
            return win;
        }
    }

    public void startGame() {
        System.out.print("Player 1 enter your name: ");
        Scanner keyboard = new Scanner(System.in);
        String whitePlayerName = keyboard.nextLine();

        Player.setWhitePlayerName(whitePlayerName);

        System.out.print("Player 2 enter your name: ");
        String blackPlayerName = keyboard.nextLine();

        Player.setBlackPlayerName(blackPlayerName);
        
        Board.initializePieces();
        }
    
    public void runGame(ArrayList<Piece> pieces) {
    
     while (winCondition(pieces) == false) {
            boolean isWhitesMoveLegal = false;
            boolean isBlacksMoveLegal = false;
            String whiteSelectedPiece;
            String blackSelectedPiece;
            Coord whiteMovementCoord = null;
            Coord blackMovementCoord = null;
            Scanner keyboard = new Scanner(System.in);

            while (isWhitesMoveLegal == false) {
                System.out.print("White player select a piece: ");
                
                whiteSelectedPiece = keyboard.nextLine();
                white = whiteSelectedPiece.getPiece();

                System.out.print("Where would you like to move the piece: ");
                int whiteMovementX = keyboard.nextInt();
                whiteMovementCoord.setX(whiteMovementX);
                
                System.out.print("Where would you like to move the piece: ");
                int whiteMovementY = keyboard.nextInt();
                whiteMovementCoord.setY(whiteMovementY);
               
               

                isWhitesMoveLegal = Movement.legalMove(white, whiteMovementCoord, null);
            }

            while (isBlacksMoveLegal == false) {
                System.out.print("Black player select a piece: ");
                blackSelectedPiece = keyboard.nextLine();
                black = Piece.getPiece(blackSelectedPiece);

                System.out.print("Where would you like to move the piece: ");
                int blackMovementX = keyboard.nextInt();
                blackMovementCoord.setXCoord(blackMovementX);
                
                System.out.print("Where would you like to move the piece: ");
                int blackMovementY = keyboard.nextInt();
                blackMovementCoord.setYCoord(blackMovementY);

                isBlacksMoveLegal = Movement.legalMove(black, blackMovementCoord, null);
            }
            if (whiteMovementCoord == blackMovementCoord && white.getType() == black.getType()){
            	pieces.remove(white);
            	pieces.remove(black);
            }
            else if(whiteMovementCoord == blackMovementCoord && (white.getType() != black.getType())){
                if(white.getType() == "pawn" && black.getType() == "knight") {
                    Movement.movePiece(black, blackMovementCoord);
                    pieces.remove(white);
                }
                else {
                    Movement.movePiece(white, whiteMovementCoord);
                    pieces.remove(black);
                }}
            else {
                Movement.movePiece(white, whiteMovementCoord);
                Movement.movePiece(black, blackMovementCoord);
            }




    }}

	public static void main(String args[]) {
		startGame();
		runGame(Piece.getCurrentListOfPieces());
	}}