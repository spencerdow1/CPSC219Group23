package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class GameBoard extends Application {

    private Player white = new Player(PlayerTeam.White);
    private Player black = new Player(PlayerTeam.Black);

    public GameBoard() throws IOException {
    }



    public void start(Stage primaryStage) throws Exception {
        Board board = new Board();
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root, 500, 500));
        newStage.showAndWait();


        Parent noot = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(noot, 500, 500));
        primaryStage.show();

        /*Space currentPositionWhite = board.board[2][2];
        Space desiredPositionWhite = board.board[0][0];
        Piece selectedPieceWhite = null;
        Space currentPositionBlack = board.board[0][0];
        Space desiredPositionBlack = board.board[0][0];
        Piece selectedPieceBlack = null;

        while(!board.winCondition(board)) {
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
                JFrame white = new JFrame();
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

                white = new JFrame();
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
                JFrame black = new JFrame();
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

                black = new JFrame();
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




        }*/


    }




    public static void main(String[] args) throws IOException {
        //if running from command line could check the arguments for a boolean if you want textbased or gui


        launch(args);
        //Set up Players
        /*System.out.print("sample.Player 1 enter your name: ");
        Scanner keyboard = new Scanner(System.in);
        white.setPlayerName(keyboard.nextLine());

        System.out.print("sample.Player 2 enter your name: ");
        black.setPlayerName(keyboard.nextLine());

        System.out.println("White sample.Player " + white.playerName + " vs " + "Black sample.Player " + black.playerName);*/


    }
}
