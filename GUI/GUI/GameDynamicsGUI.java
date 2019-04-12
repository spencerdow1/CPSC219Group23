package GUI;

import Logic.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameDynamicsGUI extends GameDynamics {
    /**
     *default constructor
     */
    public GameDynamicsGUI(){}

    /**
     * Only allows pieces of a certain color to be moved.
     * @param selectedPiece
     * @return
     */
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

    /**
     * Selects a piece and allows the user to move it.
     * @param board
     * @param currentPositionWhite
     * @param desiredPositionWhite
     * @param currentPositionBlack
     * @param desiredPositionBlack
     * @param gamePieces
     * @param gameSet
     */
    public void moveWithUserInput(Board board , Coord currentPositionWhite, Coord desiredPositionWhite,
                                  Coord currentPositionBlack, Coord desiredPositionBlack, ArrayList<Piece> gamePieces,
                                  GameSet gameSet){
       ;
        Piece selectedPieceWhite = null;
        Piece selectedPieceBlack = null;
        boolean goodMove = false;


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

    /**
     * Moves a piece on the board with the AI
     * @param board
     * @param currentPositionWhite
     * @param desiredPositionWhite
     * @param gamePieces
     * @param gameSet
     * @param computerPlayer
     */
    public void moveWithAI(Board board , Coord currentPositionWhite, Coord desiredPositionWhite,
                                  ArrayList<Piece> gamePieces, GameSet gameSet, AIPlayer computerPlayer){
        Piece selectedPieceWhite;
        Piece selectedPieceBlack = null;
        ArrayList<Coord> blackTurn;


        Scanner keyboard = new Scanner(System.in);
        selectedPieceWhite = gameSet.getPieceByCoord(currentPositionWhite);
        blackTurn = computerPlayer.chooseMove(gameSet, board);
        selectedPieceBlack = gameSet.getPieceByCoord(blackTurn.get(0));




        blackTurn = computerPlayer.chooseMove(gameSet, board);
        if(selectedPieceWhite != null){


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
        }
        else System.out.print("invalid turn please try again");

    }


}
