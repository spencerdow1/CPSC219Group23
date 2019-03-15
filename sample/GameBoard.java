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
