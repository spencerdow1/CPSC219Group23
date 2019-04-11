package GUI;

import java.util.ArrayList;
import java.util.Scanner;

public class GameDynamics extends Movement {
    GameSet gameSet = new DefaultGameSet();
    Board board = new Board(gameSet);
    Piece[][] currentBoard = new Piece[5][5];
    ArrayList<Piece> gamePieces = gameSet.getGamePieces();
    String playerOneName = "player 1";
    String playerTwoName = "player 2";
    Player playerOne;
    Player playerTwo;
    AIPlayer computerPlayer;


    public GameDynamics(){}


    public GameDynamics(Player playerOne, Player playerTwo){
            this.playerOne = playerOne;
            this.playerTwo = playerTwo;
            playerOneName = playerOne.getName();
            playerTwoName = playerTwo.getName();
        }

        public GameDynamics(Player playerOne, AIPlayer aComputerPlayer){
            this.playerOne = playerOne;
            computerPlayer = aComputerPlayer;
            playerOneName = playerOne.getName();
            playerTwoName = aComputerPlayer.getName();
        }

    public void simultaneousMovement(ArrayList<Coord> turnMoves,
                                     GameSet pieces, Board currentBoard){

        // throw an error if turnMoves is not length 4
        if (turnMoves.size() != 4){
            System.out.print("Invalid moves passed to ");
            System.out.println("simultaneousMovement");
        }

        Coord whiteMove = turnMoves.get(1);
        Coord blackMove = turnMoves.get(3);
        Coord whitePieceLocation = turnMoves.get(0);
        Coord blackPieceLocation = turnMoves.get(2);
        int whiteIndex = pieces.getPieceIndexByCoord(whitePieceLocation);
        int blackIndex = pieces.getPieceIndexByCoord(blackPieceLocation);
        Piece whitePiece = pieces.getPiece(whiteIndex);
        Piece blackPiece = pieces.getPiece(blackIndex);
        String whitePieceType = whitePiece.getType();
        String blackPieceType = blackPiece.getType();

        // IF PIECES MOVE TO THE SAME SPOT
        if (whiteMove.equals(blackMove)){
            // if both pieces are the same type they annihilate
            if (whitePieceType.equals(blackPieceType)){
                pieces.removePieces(whiteIndex, blackIndex);
            }

            // if one tye is different there are two cases
            else {
                if (whitePieceType.equals("knight")){
                    pieces.removePiece(blackIndex);
                    movePiece(whitePiece, whiteMove);
                }
                else {
                    pieces.removePiece(whiteIndex);
                    movePiece(blackPiece, blackMove);
                }
            }
        }

        // OTHERWISE HANDLE MOVES AND CAPTURES
        else {
            // get the pieces which will be moved to for black and white
            Piece whitePieceReference = currentBoard.getPiece(whiteMove);
            Piece blackPieceReference = currentBoard.getPiece(blackMove);

            // WHITE MOVE
            if (whitePieceReference != null){
                // if white is moving to a location that black is not
                // moving away from then delete that piece
                if (whiteMove.equals(blackPieceLocation) == false){
                    int annihilateIndex = pieces.getPieceIndexByCoord(whiteMove);
                    pieces.removePiece(annihilateIndex);
                    movePiece(whitePiece, whiteMove);
                }
                // otherwise just move because black is moving
                else {
                    movePiece(whitePiece, whiteMove);
                }
            }
            else {
                movePiece(whitePiece, whiteMove);
            }

            // BLACK MOVE
            if (blackPieceReference != null){
                // if white is moving to a location that black is not
                // moving away from then delete that piece
                if (blackMove.equals(whitePieceLocation) == false){
                    int annihilateIndex = pieces.getPieceIndexByCoord(blackMove);
                    pieces.removePiece(annihilateIndex);
                    movePiece(blackPiece, blackMove);
                }
                // otherwise just move because black is moving
                else {
                    movePiece(blackPiece, blackMove);
                }
            }
            else {
                movePiece(blackPiece, blackMove);
            }
        }

        // check for possible upgrades in the game set
        ArrayList<Piece> alivePieces = pieces.getGamePieces();
        for (Piece aPiece : alivePieces){
            aPiece.upgrade();
        }

        // now that the gameset is modified just update the board
        currentBoard.updateBoard(pieces);
    }



    public boolean stalemate(GameSet aGameSet, Board theBoard){
        boolean stalemate = false;
        ArrayList<Piece> whitePieces = aGameSet.getWhitePieces();
        ArrayList<Piece> blackPieces = aGameSet.getBlackPieces();
        int numWhitePieces = whitePieces.size();
        int numBlackPieces = blackPieces.size();
        int numWhiteMoves = 0;
        int numBlackMoves = 0;
        Piece whitePiece, blackPiece;
        ArrayList<Coord> whiteMoves, blackMoves;

        for (int i = 0; i < numWhitePieces; i++){
            whitePiece = whitePieces.get(i);
            whiteMoves = genMoves(whitePiece, theBoard);
            for (int n = 0; n < whiteMoves.size(); n++){
                numWhiteMoves++;
            }
            if (numWhiteMoves > 0){
                break;
            }
        }

        for (int j = 0; j < numBlackPieces; j++){
            blackPiece = blackPieces.get(j);
            blackMoves = genMoves(blackPiece, theBoard);
            for (int m = 0; m < blackMoves.size(); m++){
                numBlackMoves++;
            }
            if (numBlackMoves > 0){
                break;
            }

        }

        if (numWhiteMoves == 0 || numBlackMoves == 0){
            stalemate = true;
        }

        return stalemate;

    }



    public String winCondition(GameSet theGameSet, Board theBoard){
        ArrayList<Piece> aPieceList = theGameSet.getGamePieces();
        int numWhitePawns = 0;
        int numBlackPawns = 0;
        String currentType, colour, winString;

        for (Piece aPiece : aPieceList){
            currentType = aPiece.getType();

            if (currentType.equals("pawn")){
                colour = aPiece.getColour();

                if (colour.equals("white")){
                    numWhitePawns += 1;
                }
                else if (colour.equals("black")){
                    numBlackPawns += 1;
                }
                else {
                    System.out.print("Invalid piece colour found ");
                    System.out.println("in winCondition()");
                }
            }
        }

        if (numWhitePawns == 0){
            if (numBlackPawns == 0){
                winString = "draw";
            }
            else {
                winString = "black";
            }
        }

        else if (numBlackPawns == 0){
            winString = "white";
        }

        else if (stalemate(theGameSet, theBoard)){
            winString = "stalemate";
        }

        else {
            winString = "continue";
        }

        return winString;
    }

    public String moveCorrectColorPiece(Piece selectedPiece){
        String colorOfPiece = null;
        if (selectedPiece != null){
            if (selectedPiece.getColour() == "white"){
                colorOfPiece = "white";
            }
            else if (selectedPiece.getColour() == "black"){
                colorOfPiece = "black";
            }
        }
        return colorOfPiece;
    }

    public void moveWithUserInput(Board board , Coord currentPositionWhite, Coord desiredPositionWhite,
                                  Coord currentPositionBlack, Coord desiredPositionBlack, ArrayList<Piece> gamePieces,
                                  GameSet gameSet){
       ;
        Piece selectedPieceWhite = null;
        Piece selectedPieceBlack = null;
        //boolean goodMove = false;


        Scanner keyboard = new Scanner(System.in);
        selectedPieceWhite = gameSet.getPieceByCoord(currentPositionWhite);



        selectedPieceBlack = gameSet.getPieceByCoord(currentPositionBlack);
        if(legalMove(selectedPieceWhite, board, desiredPositionWhite)
                && moveCorrectColorPiece(selectedPieceWhite) == "white"
                && legalMove(selectedPieceBlack, board, desiredPositionBlack )
                && moveCorrectColorPiece(selectedPieceBlack) == "black"){


            ArrayList<Coord> moves = new ArrayList<>();
            moves.add(currentPositionWhite);
            moves.add(desiredPositionWhite);
            moves.add(currentPositionBlack);
            moves.add(desiredPositionBlack);



            // execute moves


            simultaneousMovement(moves, gameSet, board);
            board.printBoard();


        }
        else {
            System.out.print("invalid turn please try again");
            if(legalMove(selectedPieceWhite, board, desiredPositionWhite)
                    && moveCorrectColorPiece(selectedPieceWhite) == "white"){
                System.out.println("");
                System.out.print("Black player has made an error please try again");
            }
            else {
                System.out.println("");
                System.out.println("White player has made an error please try again");
            }
        }

    }
    public void moveWithAI(Board board , Coord currentPositionWhite, Coord desiredPositionWhite,
                                  ArrayList<Piece> gamePieces, GameSet gameSet, AIPlayer computerPlayer){
        Piece selectedPieceWhite = null;
        Piece selectedPieceBlack = null;
        ArrayList<Coord> blackTurn;


        Scanner keyboard = new Scanner(System.in);
        selectedPieceWhite = gameSet.getPieceByCoord(currentPositionWhite);
        blackTurn = computerPlayer.chooseMove(gameSet, board);
        selectedPieceBlack = gameSet.getPieceByCoord(blackTurn.get(0));




        blackTurn = computerPlayer.chooseMove(gameSet, board);

        if(legalMove(selectedPieceWhite, board, desiredPositionWhite)
                && moveCorrectColorPiece(selectedPieceWhite) == "white") {


            ArrayList<Coord> moves = new ArrayList<>();
            moves.add(currentPositionWhite);
            moves.add(desiredPositionWhite);
            moves.addAll(blackTurn);



            // execute moves


            simultaneousMovement(moves, gameSet, board);
            board.printBoard();


        }
        else System.out.print("invalid turn please try again");

    }


}
