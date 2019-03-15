package sample;

import javafx.collections.FXCollections;
import javafx.embed.swing.JFXPanel;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Controller {
    @FXML
    private Text whitePlayer;
    @FXML
    private Text blackPlayer;
    @FXML
    public ImageView rectangle1;
    @FXML
    public ImageView rectangle2;
    @FXML
    public ImageView rectangle3;
    @FXML
    public ImageView rectangle4;
    @FXML
    public ImageView rectangle5;
    @FXML
    public ImageView rectangle6;
    @FXML
    public ImageView rectangle7;
    @FXML
    public ImageView rectangle8;
    @FXML
    public ImageView rectangle9;
    @FXML
    public ImageView rectangle10;
    @FXML
    public ImageView rectangle11;
    @FXML
    public ImageView rectangle12;
    @FXML
    public ImageView rectangle13;
    @FXML
    public ImageView rectangle14;
    @FXML
    public ImageView rectangle15;
    @FXML
    public ImageView rectangle16;
    @FXML
    public ImageView rectangle17;
    @FXML
    public ImageView rectangle18;
    @FXML
    public ImageView rectangle19;
    @FXML
    public ImageView rectangle20;
    @FXML
    public ImageView rectangle21;
    @FXML
    public ImageView rectangle22;
    @FXML
    public ImageView rectangle23;
    @FXML
    public ImageView rectangle24;
    @FXML
    public ImageView rectangle25;
    @FXML
    public GridPane currentBoard;

    public Controller() throws IOException {
    }


    /**
     * @return
     */
    public ArrayList createListOfSpaces(){
        ArrayList<ImageView> GuiSpaces = new ArrayList<>();
        GuiSpaces.add(rectangle1);
        GuiSpaces.add(rectangle2);
        GuiSpaces.add(rectangle3);
        GuiSpaces.add(rectangle4);
        GuiSpaces.add(rectangle5);
        GuiSpaces.add(rectangle6);
        GuiSpaces.add(rectangle7);
        GuiSpaces.add(rectangle8);
        GuiSpaces.add(rectangle9);
        GuiSpaces.add(rectangle10);
        GuiSpaces.add(rectangle11);
        GuiSpaces.add(rectangle12);
        GuiSpaces.add(rectangle13);
        GuiSpaces.add(rectangle14);
        GuiSpaces.add(rectangle15);
        GuiSpaces.add(rectangle16);
        GuiSpaces.add(rectangle17);
        GuiSpaces.add(rectangle18);
        GuiSpaces.add(rectangle19);
        GuiSpaces.add(rectangle20);
        GuiSpaces.add(rectangle21);
        GuiSpaces.add(rectangle22);
        GuiSpaces.add(rectangle23);
        GuiSpaces.add(rectangle24);
        GuiSpaces.add(rectangle25);
        return GuiSpaces;
    }


    public static void UpdateGUIBoard(Space[][] board, ArrayList<ImageView> list){
        Image imageWhiteKnight = new Image("/sample/WhiteK.png");
        Image imageBlackKnight = new Image("/sample/BlackK.png");
        Image imageWhitePawn = new Image("/sample/WhiteP.png");
        Image imageBlackPawn = new Image("/sample/BlackP.png");
        int counter = 0;
            for (int l = 0; l < 5; l++){
                for (int j = 0; j < 5; j++){
                    if(board[j][l].getPiece() == null){ counter++; continue;}
                    if (board[j][l].getPiece().getPieceType() == PieceType.Knight){
                        if (board[j][l].getPiece().getPlayerTeam() == PlayerTeam.White) {
                            list.get(counter).setImage(imageWhiteKnight);
                            counter++;
                        }
                        else{
                            list.get(counter).setImage(imageBlackKnight);
                            counter++;
                        }
                    }
                    else if (board[j][l].getPiece().getPieceType() == PieceType.Pawn){
                        if (board[j][l].getPiece().getPlayerTeam() == PlayerTeam.White) {
                            list.get(counter).setImage(imageWhitePawn);
                            counter++;
                        }
                        else{
                            list.get(counter).setImage(imageBlackPawn);
                            counter++;
                        }
                    }
                    else{
                        continue;
                    }

                }
            }
    }


    public void clearRectangles(ArrayList<ImageView> list){
        for (int i = 0; i < list.size(); i++ ){
            list.get(i).setImage(null);
        }
    }




    public void initialize() throws IOException {

        ArrayList<ImageView> list = createListOfSpaces();;
        Board board = new Board();
        try {
            board = new Board();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Space currentPositionWhite = board.board[2][2];
        Space desiredPositionWhite = board.board[0][0];
        Piece selectedPieceWhite = null;
        Space currentPositionBlack = board.board[0][0];
        Space desiredPositionBlack = board.board[0][0];
        Piece selectedPieceBlack = null;

        /*while(!board.winCondition(board)) {
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
                JFXPanel white = new JFXPanel();
                String whitePosStr = JOptionPane.showInputDialog(white, "Please enter the coordinate of the piece you would like to move(x,y): ");
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
                currentPositionWhite = board.board[currentPositionWhiteX][currentPositionWhiteY];
                selectedPieceWhite = currentPositionWhite.getPiece();

                white = new JFXPanel();
                String whiteMoveStr = JOptionPane.showInputDialog(white, "Please enter the coordinate of the space you would like to move to(x,y): ");
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
                desiredPositionWhite = board.board[desiredPositionWhiteX][desiredPositionWhiteY];



                if (selectedPieceWhite!=null){
                    if (selectedPieceWhite.validateMove(currentPositionWhite.getCoord(), desiredPositionWhite.getCoord(), board)
                            && board.moveCorrectColorPiece(currentPositionWhite) == PlayerTeam.White){
                        possibleMove = true;
                        rightColor = true;
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
                JFXPanel black = new JFXPanel();
                String blackPosStr = JOptionPane.showInputDialog(black,"Please enter the coordinate of the piece you would like to move(x,y): " );
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
                currentPositionBlack = board.board[currentPositionBlackX][currentPositionBlackY];
                selectedPieceBlack = currentPositionBlack.getPiece();

                black = new JFXPanel();
                String blackMoveStr = JOptionPane.showInputDialog(black,"Please enter the coordinate of the piece you would like to move(x,y): " );
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
                desiredPositionBlack = board.board[desiredPositionBlackX][desiredPositionBlackY];

                if (selectedPieceBlack!=null){
                    if (selectedPieceBlack.validateMove(currentPositionBlack.getCoord(), desiredPositionBlack.getCoord(), board )&&
                            board.moveCorrectColorPiece(currentPositionBlack) == PlayerTeam.Black){
                        possibleMove = true;
                        rightColor = true;
                    }
                    else System.out.println("The move you have entered is not valid please try again");
                }
                else {
                    System.out.println("Invalid piece Selection.");
                }
            }



            // execute moves


            board.simultaneousMove(currentPositionWhite, desiredPositionWhite, currentPositionBlack, desiredPositionBlack);


            board.checkUpgrade();
            board.printCurrentBoard();


        }*/

        clearRectangles(list);
        UpdateGUIBoard(board.board, list);

    }
}
