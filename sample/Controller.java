package sample;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Controller {
    @FXML
    private Text whitePlayer;
    @FXML
    private Text blackPlayer;
    @FXML
    public Rectangle rectangle1;
    @FXML
    public Rectangle rectangle2;
    @FXML
    public Rectangle rectangle3;
    @FXML
    public Rectangle rectangle4;
    @FXML
    public Rectangle rectangle5;
    @FXML
    public Rectangle rectangle6;
    @FXML
    public Rectangle rectangle7;
    @FXML
    public Rectangle rectangle8;
    @FXML
    public Rectangle rectangle9;
    @FXML
    public Rectangle rectangle10;
    @FXML
    public Rectangle rectangle11;
    @FXML
    public Rectangle rectangle12;
    @FXML
    public Rectangle rectangle13;
    @FXML
    public Rectangle rectangle14;
    @FXML
    public Rectangle rectangle15;
    @FXML
    public Rectangle rectangle16;
    @FXML
    public Rectangle rectangle17;
    @FXML
    public Rectangle rectangle18;
    @FXML
    public Rectangle rectangle19;
    @FXML
    public Rectangle rectangle20;
    @FXML
    public Rectangle rectangle21;
    @FXML
    public Rectangle rectangle22;
    @FXML
    public Rectangle rectangle23;
    @FXML
    public Rectangle rectangle24;
    @FXML
    public Rectangle rectangle25;

    public Controller() throws IOException {
    }


    /**
     * @return
     */
    public ArrayList createListOfSpaces(){
        ArrayList<Rectangle> GuiSpaces = new ArrayList<>();
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


    public void UpdateGUIBoard(Space[][] board, ArrayList<Rectangle> list){
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
                            list.get(counter).setFill(new ImagePattern(imageWhiteKnight));
                            counter++;
                        }
                        else{
                            list.get(counter).setFill(new ImagePattern(imageBlackKnight));
                            counter++;
                        }
                    }
                    else if (board[j][l].getPiece().getPieceType() == PieceType.Pawn){
                        if (board[j][l].getPiece().getPlayerTeam() == PlayerTeam.White) {
                            list.get(counter).setFill(new ImagePattern(imageWhitePawn));
                            counter++;
                        }
                        else{
                            list.get(counter).setFill(new ImagePattern(imageBlackPawn));
                            counter++;
                        }
                    }
                    else{
                        continue;
                    }

                }
            }
    }


    public void clearRectangles(ArrayList<Rectangle> list){
        for (int i = 0; i < list.size(); i++ ){
            list.get(i).setFill(null);
        }
    }




    public void initialize() throws IOException {
        MainController mainController = new MainController();
        //whitePlayer.setText(mainController.getOne());

        //blackPlayer.setText(mainController.getTwo());

        ArrayList<Rectangle> list = createListOfSpaces();
        Board gameBoard = null;
        try {
            gameBoard = new Board();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        UpdateGUIBoard(gameBoard.board, list);
    }
}
