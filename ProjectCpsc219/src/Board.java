import java.util.Scanner;

public class Board {
    private Space[][] board = new Space[5][5];

    //Initializes the game board and sets the pieces

    public Board(){
        initializeSquares();
        initializeWhite();
        initializeBlack();
    }

    public Space[][] getSpace(){
        return board;
    }

    // takes in a coordinate and matches it with the correct space
    public Space getSpace(Coord coordinate){
        Space result = null;
        for (int x = 0; x < 5; x++){
            for(int y = 0; y < 5; y++){
                if (board[x][y].getCoord() == coordinate ){
                    result = board[x][y];
                }

            }

        }
        return result;
    }

    public void setPiece(Coord coordinate, Piece piece){
        getSpace(coordinate).setPiece(piece);
    }

    //used for capture takes in a Space and clears it
    public void Capture(Space board){
        if(board.emptySpace()){
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
                              currentCheckPiece.getPlayer() == PlayerTeam.White
                              && currentCheckSpace.getCoord().getYCoord() == 4){

                          setPiece(currentCheckSpace.getCoord(),new Knight(PlayerTeam.White));
                      }
                      else if(currentCheckPiece.getPieceType() == PieceType.Pawn &&
                                   currentCheckPiece.getPlayer() == PlayerTeam.Black
                                   && currentCheckSpace.getCoord().getYCoord() == 0){

                          setPiece(currentCheckSpace.getCoord(),new Knight(PlayerTeam.White));
                          }


                  }


            }
        }
    }

    //Sets piece to new position and removes it from the old one

    public void Move(Space currentPosition, Space desiredPosition){
        if (desiredPosition.emptySpace() == false){
            Capture(desiredPosition);
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
        else if (desiredPositionWhite == desiredPositionBlack){
            if(currentPositionWhite.getPiece().getPieceType() == currentPositionBlack.getPiece().getPieceType()){
                currentPositionWhite.removePiece();
                currentPositionBlack.removePiece();
            }
            else{
                if (currentPositionWhite.getPiece().getPieceType() == PieceType.Pawn &&
                        currentPositionBlack.getPiece().getPieceType() == PieceType.Knight){
                    currentPositionWhite.removePiece();
                    Move(currentPositionBlack,desiredPositionBlack);
                }
                else if(currentPositionWhite.getPiece().getPieceType() == PieceType.Knight &&
                        currentPositionBlack.getPiece().getPieceType() == PieceType.Pawn){
                    Move(currentPositionWhite,desiredPositionWhite);
                    currentPositionBlack.removePiece();
                }
            }
        }
        else{
            Move(currentPositionWhite,desiredPositionWhite);
            Move(currentPositionBlack, desiredPositionBlack);
        }
    }


    private void initializeSquares() {
        for (int x = 0; x < 5; x++) {

            for (int y = 0; y < 5; y++) {
                board[x][y] = new Space(new Coord(x, y));
            }
        }
    }

    //creates new white pieces and places them on the board
    private void initializeWhite(){
        board[0][1].setPiece(new Pawn(PlayerTeam.White));
        board[0][0].setPiece(new Knight(PlayerTeam.White));
        board[1][0].setPiece(new Pawn(PlayerTeam.White));
        board[2][0].setPiece(new Pawn(PlayerTeam.White));
        board[3][0].setPiece(new Pawn(PlayerTeam.White));
        board[4][0].setPiece(new Knight(PlayerTeam.White));
        board[4][3].setPiece(new Pawn(PlayerTeam.White));
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

    // searches the list for pawns of each team because when a players # of pawns = 0 they lose
    public boolean winCondition() {
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
                    desiredPlayerTeam = currentCheckPiece.getPlayer();
                    if (desiredPieceType == PieceType.Pawn && desiredPlayerTeam == PlayerTeam.White) {
                        whitePawns = whitePawns + 1;
                    }
                    if ((desiredPieceType == PieceType.Pawn && desiredPlayerTeam == PlayerTeam.Black)) {
                        blackPawns = blackPawns + 1;
                    }
                } 
                }
            }

        if (whitePawns == 0 || blackPawns == 0)  {
            return true;
        }

        return false;
    }



    //Initializes and movement
    public void moveWithUserInput(Board currentBoard){
        Space currentPositionWhite = board[0][0];
        Space desiredPositionWhite = board[0][0];
        Piece selectedPieceWhite = null;
        Space currentPositionBlack = board[0][0];
        Space desiredPositionBlack = board[0][0];
        Piece selectedPieceBlack = null;


        Scanner keyboard = new Scanner(System.in);

        while(!winCondition()) {
            //gets input from white player and checks to see if its valid
            boolean possibleMove = false;
            while (!possibleMove) {
                System.out.print("White player select the x coordinate of the piece you want to move(0(left) 4(right)): ");
                int currentPositionWhiteX = keyboard.nextInt();

                System.out.print("White player select the y coordinate of the piece you want to move(0(bottom) 4(top): ");
                int currentPositionWhiteY = keyboard.nextInt();

                System.out.print("White player select the x coordinate of the space you want to move to(0(left) 4(right)): ");
                int desiredPositionWhiteX = keyboard.nextInt();

                System.out.print("White player select the y coordinate of the space you want to move to(0(bottom) 4(top): ");
                int desiredPositionWhiteY = keyboard.nextInt();

                currentPositionWhite = board[currentPositionWhiteX][currentPositionWhiteY];
                desiredPositionWhite = board[desiredPositionWhiteX][desiredPositionWhiteY];
                selectedPieceWhite = currentPositionWhite.getPiece();
                if (selectedPieceWhite.validateMove(currentPositionWhite.getCoord(), desiredPositionWhite.getCoord(), currentBoard)){
                    possibleMove = true;
                }
                else System.out.println("The move you have entered is not valid please try again");
            }


        //Take input from player two and checks if its valid
            possibleMove = false;
            while (!possibleMove) {
                System.out.println();

                System.out.print("Black player select the x coordinate of the piece you want to move(0(left) 4(right)): ");
                int currentPositionBlackX = keyboard.nextInt();

                System.out.print("Black player select the y coordinate of the piece you want to move(0(bottom) 4(top): ");
                int currentPositionBlackY = keyboard.nextInt();

                System.out.print("Black player select the x coordinate of the space you want to move to(0(left) 4(right)): ");
                int desiredPositionBlackX = keyboard.nextInt();

                System.out.print("Black player select the y coordinate of the space you want to move to(0(bottom) 4(top): ");
                int desiredPositionBlackY = keyboard.nextInt();

                currentPositionBlack = board[currentPositionBlackX][currentPositionBlackY];
                desiredPositionBlack = board[desiredPositionBlackX][desiredPositionBlackY];
                selectedPieceBlack = currentPositionBlack.getPiece();

                if (selectedPieceBlack.validateMove(currentPositionBlack.getCoord(),desiredPositionBlack.getCoord(),currentBoard)){
                    possibleMove = true; }
                else System.out.println("The move you have entered is not valid please try again");
            }


         // execute moves


            simultaneousMove(currentPositionWhite, desiredPositionWhite, currentPositionBlack, desiredPositionBlack);
                checkUpgrade();
                printCurrentBoard();

            }
        
    }
}



