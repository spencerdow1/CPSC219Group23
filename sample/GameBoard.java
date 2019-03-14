package sample;

import javafx.application.Application;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;

public class GameBoard extends Application {

    private Player white = new Player(PlayerTeam.White);
    private Player black = new Player(PlayerTeam.Black);
    private Board board = new Board();

    public GameBoard() throws IOException {
    }
    private Coord lastClick;

    private int numClicks;

    private Coord whiteInput;

    private Coord whiteMove;

    private Coord blackInput;

    private Coord blackMove;



    /** Inner class which handles mouse click events and sets them to the

     lastClick coordinate

     @see Coord

     **/

    public class ChessClick implements EventHandler<MouseEvent> {



        private double sceneSize = 500;

        private double xClickLoc, yClickLoc;



        public void handle(MouseEvent aClick){

            numClicks += 1;

            System.out.print("");

            System.out.print("num clicks: ");

            System.out.println(numClicks);



            xClickLoc = aClick.getSceneX();

            yClickLoc = aClick.getSceneY();

            xClickLoc = xClickLoc*5/sceneSize;

            yClickLoc = yClickLoc*5/sceneSize;

            int xCoord = (int) Math.floor(xClickLoc);

            int yCoord = (int) Math.floor(yClickLoc);

            yCoord = Math.abs(yCoord - 4);



            setLastClick(xCoord, yCoord);

            System.out.print("Last click coordinate:   ");

            System.out.println(getLastClick());

            System.out.println("");

        }

    }





    public void setLastClick(int xLoc, int yLoc){

        // needs to be done with a setter but I'm too tired

        lastClick = new Coord(xLoc, yLoc);

    }





    public Coord getLastClick(){

        Coord copyCoord = new Coord(lastClick);

        return copyCoord;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root, 500, 500));
        newStage.showAndWait();

        game(primaryStage);
    }

    public void game(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        //if running from command line could check the arguments for a boolean if you want textbased or gui
        Board board = new Board();

        launch(args);
        //Set up Players
        /*System.out.print("sample.Player 1 enter your name: ");
        Scanner keyboard = new Scanner(System.in);
        white.setPlayerName(keyboard.nextLine());

        System.out.print("sample.Player 2 enter your name: ");
        black.setPlayerName(keyboard.nextLine());

        System.out.println("White sample.Player " + white.playerName + " vs " + "Black sample.Player " + black.playerName);*/
        board.printCurrentBoard();
        board.moveWithUserInput(board);


    }
}
