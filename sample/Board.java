package sample;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Board {
    public Space[][] board = new Space[5][5];

    //Initializes the game board and sets the pieces


    public Board() throws IOException {
        initializeSpaces();
        initializeWhite();
        initializeBlack();
    }

    public Space[][] getSpace(){
        return board;
    }

    // takes in a coordinate and matches it with the correct space
    public Space getSpace(Coord coordinate){
        Space result = board[coordinate.getXCoord()][coordinate.getYCoord()];

        return result;
    }

    public void setPiece(Coord coordinate, Piece piece){
        getSpace(coordinate).setPiece(piece);
    }

    //used for capture takes in a sample.Space and clears it
    public void capture(Space board){
        if(board.filledSpace()){
            board.removePiece();
        }
    }
    //Goes through the board and searches for pawns to be updated to knights and executes
    public void checkUpgrade(){
        Space[][] checkBoard = getSpace();


        for (int x = 0; x < 5; x++) {

            for (int y = 0; y < 5; y++) {
                  Space currentCheckSpace = checkBoard[x][y];
                  Piece currentCheckPiece = currentCheckSpace.getPiece();
                  if(currentCheckPiece != null){

                      if(currentCheckPiece.getPieceType() == PieceType.Pawn &&
                              currentCheckPiece.getPlayerTeam() == PlayerTeam.White
                              && currentCheckSpace.getCoord().getYCoord() == 4){

                          setPiece(currentCheckSpace.getCoord(),new Knight(PlayerTeam.White));
                      }
                      else if(currentCheckPiece.getPieceType() == PieceType.Pawn &&
                                   currentCheckPiece.getPlayerTeam() == PlayerTeam.Black
                                   && currentCheckSpace.getCoord().getYCoord() == 0){

                          setPiece(currentCheckSpace.getCoord(),new Knight(PlayerTeam.Black));
                          }


                  }


            }
        }
    }

    //Sets piece to new position and removes it from the old one

    public void move(Space currentPosition, Space desiredPosition){
        if (desiredPosition.filledSpace() == false){
            capture(desiredPosition);
        }
        desiredPosition.setPiece(currentPosition.getPiece());
        currentPosition.removePiece();

    }

    //Creates conditions to make the game appear as if both moves appear at the same time aswell as deals with
    //Certain situations that occur that require special actions
    public void simultaneousMove(Space currentPositionWhite, Space desiredPositionWhite,
                                 Space currentPositionBlack, Space desiredPositionBlack){

        if(currentPositionWhite == desiredPositionBlack && currentPositionBlack == desiredPositionWhite) {
            Piece tempStore = currentPositionWhite.getPiece();
            currentPositionWhite.removePiece();
            desiredPositionBlack.setPiece(currentPositionBlack.getPiece());
            currentPositionBlack.removePiece();
            desiredPositionWhite.setPiece(tempStore);

        }
        else if(desiredPositionWhite == currentPositionBlack || desiredPositionBlack == currentPositionWhite ){
            if(desiredPositionWhite == currentPositionBlack){
                move(currentPositionBlack, desiredPositionBlack);
                move(currentPositionWhite, desiredPositionWhite);
            }
            else if(desiredPositionBlack == currentPositionWhite){
                move(currentPositionWhite, desiredPositionWhite);
                move(currentPositionBlack, desiredPositionBlack);
            }
        }
        else if (desiredPositionWhite == desiredPositionBlack){
            if(currentPositionWhite.getPiece().getPieceType() == currentPositionBlack.getPiece().getPieceType()){
                currentPositionWhite.removePiece();
                currentPositionBlack.removePiece();
            }
            else{
                if (currentPositionWhite.getPiece().getPieceType() == PieceType.Pawn &&
                        currentPositionBlack.getPiece().getPieceType() == PieceType.Knight){
                    currentPositionWhite.removePiece();
                    move(currentPositionBlack,desiredPositionBlack);
                }
                else if(currentPositionWhite.getPiece().getPieceType() == PieceType.Knight &&
                        currentPositionBlack.getPiece().getPieceType() == PieceType.Pawn){
                    move(currentPositionWhite,desiredPositionWhite);
                    currentPositionBlack.removePiece();
                }
            }
        }
        else{
            move(currentPositionWhite,desiredPositionWhite);
            move(currentPositionBlack, desiredPositionBlack);
        }
        //updateGUI(gameBoard);
        //updateGUI will change the images printed on the board
    }


    private void initializeSpaces() {
        for (int x = 0; x < 5; x++) {

            for (int y = 0; y < 5; y++) {
                board[x][y] = new Space(new Coord(x, y));
            }
        }
    }

    //creates new white pieces and places them on the board
    private void initializeWhite(){
        board[0][0].setPiece(new Knight(PlayerTeam.White));
        board[0][1].setPiece(new Pawn(PlayerTeam.White));
        board[1][0].setPiece(new Pawn(PlayerTeam.White));
        board[2][0].setPiece(new Pawn(PlayerTeam.White));
        board[3][0].setPiece(new Pawn(PlayerTeam.White));
        board[4][0].setPiece(new Knight(PlayerTeam.White));
        board[4][1].setPiece(new Pawn(PlayerTeam.White));
    }
    //create new black pieces and puts them on the board
    private void initializeBlack(){

        board[0][3].setPiece(new Pawn(PlayerTeam.Black));
        board[0][4].setPiece(new Knight(PlayerTeam.Black));
        board[1][4].setPiece(new Pawn(PlayerTeam.Black));
        board[2][4].setPiece(new Pawn(PlayerTeam.Black));
        board[3][4].setPiece(new Pawn(PlayerTeam.Black));
        board[4][4].setPiece(new Knight(PlayerTeam.Black));
        board[4][3].setPiece(new Pawn(PlayerTeam.Black));
    }

    //print out current state of the board
    public void printCurrentBoard() {
        for (int y = 4; y >= 0; y--) {
            for (int x = 0; x < 5; x++) {
                System.out.print(board[x][y].getPieceToString() + " ");
            }
            System.out.print('\n');
        }
    }

    public boolean checkForStalemate(Board currentBoard) {
        boolean stalemate;
        int countWhite = 0;
        int countBlack = 0;
        Space currentSpace;
        Space checkSpace;

        for (int x = 0; x < 5; x++) {

            for (int y = 0; y < 5; y++) {

                for (int i = 0; i < 5; i++) {

                    for (int j = 0; j < 5; j++) {
                        currentSpace = board[x][y];
                        checkSpace = board[i][j];

                        if(board[x][y] != null && board[i][j] != null){

                            if (currentSpace.getPiece() != null) {

                                if (currentSpace.getPiece().getPlayerTeam() == PlayerTeam.White ){

                                    if (currentSpace.getPiece().validateMove(currentSpace.getCoord(), checkSpace.getCoord(), currentBoard)) {
                                        countWhite = countWhite + 1;
                                    }

                                }
                                else if(currentSpace.getPiece().getPlayerTeam() == PlayerTeam.Black){

                                    if (currentSpace.getPiece().validateMove(currentSpace.getCoord(), checkSpace.getCoord(), currentBoard)) {
                                        countBlack = countBlack + 1;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        if (countWhite == 0 && countBlack == 0){
            System.out.print("Its a draw!");
            stalemate = true;
        }
        else if(countWhite == 0){
            System.out.print("Sorry white player you have no more moves player black has won!");
            stalemate = true;
        }
        else if (countBlack == 0){
            System.out.print("Sorry black player you have no more moves player white has won!");
            stalemate = true;
        }
        else stalemate = false;
        return stalemate;
    }

    // searches the list for pawns of each team because when a players # of pawns = 0 they lose
    public boolean winCondition(Board currentBoard) {
        Space[][] checkBoard = getSpace();
        int blackPawns = 0;
        int whitePawns = 0;
        PieceType desiredPieceType;
        PlayerTeam desiredPlayerTeam;
        for (int x = 0; x < 5; x++) {

            for (int y = 0; y < 5; y++) {
                Space currentCheckSpace = checkBoard[x][y];
                Piece currentCheckPiece = currentCheckSpace.getPiece();;
                if (currentCheckPiece != null) {
                    desiredPieceType = currentCheckPiece.getPieceType();
                    desiredPlayerTeam = currentCheckPiece.getPlayerTeam();
                    if (desiredPieceType == PieceType.Pawn && desiredPlayerTeam == PlayerTeam.White) {
                        whitePawns = whitePawns + 1;
                    }
                    if ((desiredPieceType == PieceType.Pawn && desiredPlayerTeam == PlayerTeam.Black)) {
                        blackPawns = blackPawns + 1;
                    }
                } 
                }
            }

        if (whitePawns == 0)  {
            System.out.print("Player Black has won!");
            return true;
        }
        else if (blackPawns == 0) {
            System.out.print("Player White has won!");
            return true;
        }
        if (checkForStalemate(currentBoard)){
            return true;
        }

        return false;
    }

    public PlayerTeam moveCorrectColorPiece(Space currentPosition){
        PlayerTeam colorOfPiece = null;
        if (currentPosition.getPiece() != null){
            if (currentPosition.getPiece().getPlayerTeam() == PlayerTeam.White){
                colorOfPiece = PlayerTeam.White;
            }
            else if(currentPosition.getPiece().getPlayerTeam() == PlayerTeam.Black){
                colorOfPiece = PlayerTeam.Black;
            }
        }
         return colorOfPiece;
    }



    //Initializes and movement
    /*public void moveWithUserInput(Board currentBoard){
        Space currentPositionWhite = board[2][2];
        Space desiredPositionWhite = board[0][0];
        Piece selectedPieceWhite = null;
        Space currentPositionBlack = board[0][0];
        Space desiredPositionBlack = board[0][0];
        Piece selectedPieceBlack = null;


        Scanner keyboard = new Scanner(System.in);

        while(!winCondition(currentBoard)) {
            //gets input from white player and checks to see if its valid
            boolean possibleMove = false;
            boolean rightColor = false;
            int currentPositionWhiteX;
            int currentPositionWhiteY;
            int currentPositionBlackX;
            int currentPositionBlackY;
            int desiredPositionWhiteX;
            int desiredPositionWhiteY;
            int desiredPositionBlackX;
            int desiredPositionBlackY;


            while (!possibleMove && !rightColor ) {
                // This takes in a string from the user, and takes all the integers
                // it finds. The first two integers found are added to the array
                // and then the x and y coordinates are set from there. Otherwise
                // this works exactly as before.
                System.out.print("White player select coordinate of the PIECE (x,y): ");
                String whitePosStr = keyboard.nextLine(); 
                char[] inputArray = whitePosStr.toCharArray();

                ArrayList<Integer> coordArray = new ArrayList<Integer>();
                for (char aChar : inputArray){
                    if ( aChar > 47 && aChar < 53 ){
                        int anInt = (int) aChar;
                        // FYI -48 is because of position of integers 0-9 on
                        // on ASCII table
                        coordArray.add(anInt - 48);
                    }
                }

                currentPositionWhiteX = coordArray.get(0);
                currentPositionWhiteY = coordArray.get(1);
                currentPositionWhite = board[currentPositionWhiteX][currentPositionWhiteY];
                selectedPieceWhite = currentPositionWhite.getPiece();

                System.out.print("White player select coordinate of the MOVE (x,y): ");
                String whiteMoveStr = keyboard.nextLine(); 
                inputArray = whiteMoveStr.toCharArray();

                coordArray = new ArrayList<Integer>();
                for (char aChar : inputArray){
                    if ( aChar > 47 && aChar < 53 ){
                        int anInt = (int) aChar;
                        coordArray.add(anInt - 48);
                    }
                }

                desiredPositionWhiteX = coordArray.get(0);
                desiredPositionWhiteY = coordArray.get(1);
                desiredPositionWhite = board[desiredPositionWhiteX][desiredPositionWhiteY];


                if (selectedPieceWhite!=null){
                    if (selectedPieceWhite.validateMove(currentPositionWhite.getCoord(), desiredPositionWhite.getCoord(), currentBoard)
                    && moveCorrectColorPiece(currentPositionWhite) == PlayerTeam.White){
                    possibleMove = true;
                    }
                    else System.out.println("The move you have entered is not valid please try again");
                    }
                else {
                    System.out.println("Invalid piece selection.");
                }
                
            }


            possibleMove = false;
            rightColor = false;
            while (!possibleMove && !rightColor ) {
                //Take input from player two and checks if its valid
                System.out.print("Black player select coordinate of the PIECE (x,y): ");
                String blackPosStr = keyboard.nextLine(); 
                char[] inputArray = blackPosStr.toCharArray();

                ArrayList<Integer> coordArray = new ArrayList<Integer>();
                for (char aChar : inputArray){
                    if ( aChar > 47 && aChar < 53 ){
                        int anInt = (int) aChar;
                        coordArray.add(anInt - 48);
                    }
                }

                currentPositionBlackX = coordArray.get(0);
                currentPositionBlackY = coordArray.get(1);
                currentPositionBlack = board[currentPositionBlackX][currentPositionBlackY];
                selectedPieceBlack = currentPositionBlack.getPiece();

                System.out.print("Black player select coordinate of the MOVE (x,y): ");
                String blackMoveStr = keyboard.nextLine(); 
                inputArray = blackMoveStr.toCharArray();

                coordArray = new ArrayList<Integer>();
                for (char aChar : inputArray){
                    if ( aChar > 47 && aChar < 53 ){
                        int anInt = (int) aChar;
                        coordArray.add(anInt - 48);
                    }
                }

                desiredPositionBlackX = coordArray.get(0);
                desiredPositionBlackY = coordArray.get(1);
                desiredPositionBlack = board[desiredPositionBlackX][desiredPositionBlackY];

                if (selectedPieceBlack!=null){
                    if (selectedPieceBlack.validateMove(currentPositionBlack.getCoord(), desiredPositionBlack.getCoord(), currentBoard )&&
                    moveCorrectColorPiece(currentPositionBlack) == PlayerTeam.Black){
                        possibleMove = true;
                    }
                    else System.out.println("The move you have entered is not valid please try again");
                }
                else {
                    System.out.println("Invalid piece Selection.");
                }
            }



         // execute moves


            simultaneousMove(currentPositionWhite, desiredPositionWhite, currentPositionBlack, desiredPositionBlack);

                checkUpgrade();
                printCurrentBoard();


            }

    }*/
    public void moveWithUserInput(Board currentBoard) throws IOException {
        Space currentPositionWhite = board[2][2];
        Space desiredPositionWhite = board[0][0];
        Piece selectedPieceWhite = null;
        Space currentPositionBlack = board[0][0];
        Space desiredPositionBlack = board[0][0];
        Piece selectedPieceBlack = null;


        Scanner keyboard = new Scanner(System.in);

        while (!winCondition(currentBoard)) {
            //gets input from white player and checks to see if its valid
            boolean possibleMove = false;
            boolean rightColor = false;
            int currentPositionWhiteX;
            int currentPositionWhiteY;
            int currentPositionBlackX;
            int currentPositionBlackY;
            int desiredPositionWhiteX;
            int desiredPositionWhiteY;
            int desiredPositionBlackX;
            int desiredPositionBlackY;
            GameBoard game = new GameBoard();
            GameBoard cont = new GameBoard();


            while (!possibleMove && !rightColor) {

                currentPositionWhite = getSpace(cont.getLastClick()) ;
                selectedPieceWhite = currentPositionWhite.getPiece();



                desiredPositionWhite = getSpace(cont.getLastClick());


                if (selectedPieceWhite != null) {
                    if (selectedPieceWhite.validateMove(currentPositionWhite.getCoord(), desiredPositionWhite.getCoord(), currentBoard)
                            && moveCorrectColorPiece(currentPositionWhite) == PlayerTeam.White) {
                        possibleMove = true;
                    } else System.out.println("The move you have entered is not valid please try again");
                } else {
                    System.out.println("Invalid piece selection.");
                }

            }


            possibleMove = false;
            rightColor = false;
            while (!possibleMove && !rightColor) {
                //Take input from player two and checks if its valid
                System.out.print("Black player select coordinate of the PIECE (x,y): ");
                String blackPosStr = keyboard.nextLine();
                char[] inputArray = blackPosStr.toCharArray();

                ArrayList<Integer> coordArray = new ArrayList<Integer>();
                for (char aChar : inputArray) {
                    if (aChar > 47 && aChar < 53) {
                        int anInt = (int) aChar;
                        coordArray.add(anInt - 48);
                    }
                }

                currentPositionBlackX = coordArray.get(0);
                currentPositionBlackY = coordArray.get(1);
                currentPositionBlack = board[currentPositionBlackX][currentPositionBlackY];
                selectedPieceBlack = currentPositionBlack.getPiece();

                System.out.print("Black player select coordinate of the MOVE (x,y): ");
                String blackMoveStr = keyboard.nextLine();
                inputArray = blackMoveStr.toCharArray();

                coordArray = new ArrayList<Integer>();
                for (char aChar : inputArray) {
                    if (aChar > 47 && aChar < 53) {
                        int anInt = (int) aChar;
                        coordArray.add(anInt - 48);
                    }
                }

                desiredPositionBlackX = coordArray.get(0);
                desiredPositionBlackY = coordArray.get(1);
                desiredPositionBlack = board[desiredPositionBlackX][desiredPositionBlackY];

                if (selectedPieceBlack != null) {
                    if (selectedPieceBlack.validateMove(currentPositionBlack.getCoord(), desiredPositionBlack.getCoord(), currentBoard) &&
                            moveCorrectColorPiece(currentPositionBlack) == PlayerTeam.Black) {
                        possibleMove = true;
                    } else System.out.println("The move you have entered is not valid please try again");
                } else {
                    System.out.println("Invalid piece Selection.");
                }
            }


            // execute moves


            simultaneousMove(currentPositionWhite, desiredPositionWhite, currentPositionBlack, desiredPositionBlack);

            checkUpgrade();
            ;


        }
    }
}




