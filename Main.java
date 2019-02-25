import java.util.Scanner;

public class Main {
    private Piece white;
    private Piece black;

    public boolean winCondition(arraylist){
        boolean win = false;
        boolean whiteWin = arraylist.contains('P');
        boolean blackWin = arraylist.contains('p');
        if (whiteWin == false && blackWin == false){
            win = true;
            System.out.println("You have tied! Play again?");
            return win;
        }
        else if(whiteWin == true && blackWin == false){
            win = true;
            System.out.println("PLayer White has won! Play again?");
            return win;
        }
        else if(whiteWin == false && blackWin == true) {
            win = true;
            System.out.println("Player Black has won! Play again?");
            return win;
        }
        else{
            return win;
        }
    }

    public void main(String args[]) {
        System.out.print("Player 1 enter your name: ");
        Scanner keyboard = new Scanner(System.in);
        String whitePlayerName = keyboard.nextLine();

        setWhitePlayerName(whitePlayerName);

        System.out.print("Player 2 enter your name: ");
        String blackPlayerName = keyboard.nextLine();

        setBlackPlayerName(blackPlayerName);

        initializePeices();

        while (winCondition(Pieces) == false) {
            boolean isWhitesMoveLegal = false;
            boolean isBlacksMoveLegal = false;
            Piece whiteSelectedPiece = "P1";
            Piece blackSelectedPiece = "p1";
            Coord whiteMovementCoord = (0, 0);
            Coord blackMovementCoord = (0, 0);

            while (isWhitesMoveLegal == false) {
                System.out.print("White player select a piece: ");
                whiteSelectedPiece = keyboard.nextPiece();
                this.white = getPiece(whiteSelectedPiece);

                System.out.print("Where would you like to move the piece: ");
                whiteMovementCoord = keyboard.nextCoord();

                isWhitesMoveLegal = legalMove(this.white, whiteMovementCoord);
            }

            while (isBlacksMoveLegal == false) {
                System.out.print("Black player select a piece: ");
                blackSelecetedPeice = keyboard.nextPiece();
                this.black = getPiece(blackSelectedPiece);

                System.out.print("Where would you like to move the piece: ");
                blackMovementCoord = keyboard.nextCoord();

                isBlacksMoveLegal = legalMove(this.black, blackMovementCoord);
            }
            movePiece(this.white, whiteMovementCoord);
            movePiece(this.black, blackMovementCoord);


        }
    }}
