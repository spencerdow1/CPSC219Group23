package GUI;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import java.util.ArrayList;



import javafx.application.Application;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;

import javafx.scene.Group;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.scene.text.FontWeight;

import javafx.stage.Stage;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleButton;

import javafx.scene.control.ToggleGroup;

import javafx.scene.control.CheckBox;

import javafx.scene.control.ChoiceBox;

import javafx.stage.Stage;

import javafx.collections.FXCollections;



public class GUIreadme extends Application {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        launch(args);

    }



    @Override
/**
 *
 */
    public void start(Stage primaryStage) throws Exception {

        // set title

        primaryStage.setTitle("Readme");

        //Create everything I need'

        Label Authors = new Label("Authors");
        Label Authors2 = new Label ("Group 23");
        Label files = new Label("Files");
        Label files2 = new Label ("Text Based: AIPlayer.java, ApocalypseTerminal.java, Board.java, Coord.java, CustomGameSet.java, DefaultGameSet.java, GameDynamicsTerminal.java, GameSet.java, HumanPlayer.java, Movement.java, Piece.java, Player.java");
        Label files3 = new Label("GUI Version (All in the GUI package): AIPlayer.java, ApocalypseClick.java, Board.java, Coord.java, CustomGameSet.java, DefaultGameSet.java, GameDynamics.java, GameSet.java, GUIBOARD.java, HumanPlayer.java,");
        Label files4 = new Label("MainMenu, Movement.java, Piece.java, Player.java, black_knight.png, black_pawn.png, white_knight.png, white_pawn.java, white_pawn_highlight,black_pawn_highlight,white_knight_highlight,black_knight_highlight");
        Label preReq = new Label("Prerequisites");
        Label preReq1 = new Label("Java JavaFX\r\n" +
                "Files included in this pakage");
        Label instructions = new Label("Instructions");
        Label instructions1 = new Label ("Apocalypse is a variation of the game chess played on a 5x5 board. Each Player has two knights and two pawns. The pieces can be moved and captured identical to chess.\r\n "
                +"The game can either be played against an AI or against another individual.\r\n"
                +"Moves are done simultaneously. This means in each turn, the players chooses their move without knowledge of the other, then moves are executed on the board at the same time.\r\n"
                +"If two pawns or two knights are moved to the same position on the board,they are both removed from the board.\r\n"
                +"If a knight from one player and a pawn from another are moved to the same spot then the pawn is captured by the knight. If a pawn reaches the opponents side of the board, then the pawn is upgraded to a knight.\r\n"
                +"To win the game a player must either: Capture all of the players pawns or the opponent is unable to make a move.");

        Label refrences = new Label("Refrences");
        Label refrences1 = new Label("Resources used for CPSC 219 Project group 23 These are all the websites I used while making the project Used for information about java and the game and different approaches to tackle the project.");
        Label refrences2 = new Label("https://dzone.com/articles/using-java-enums\r\n" +

                "https://www.tutorialspoint.com/java/java_abstraction.htm\r\n" +

                "https://stackoverflow.com/questions/15452429/java-arrays-sort-2d-array\r\n" +

                "https://beginnersbook.com/2013/05/static-vs-non-static-methods/\r\n" +

                "https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles\r\n" +

                "https://stackoverflow.com/questions/218384/what-is-a-nullpointerexception-and-how-do-i-fix-it\r\n" +

                "https://codereview.stackexchange.com/questions/82312/simple-chess-game-part-2-the-pieces\r\n" +

                "https://codereview.stackexchange.com/questions/194736/chess-application-in-java\r\n" +

                "https://en.wikipedia.org/wiki/Apocalypse_(chess_variant)\r\n" +

                "http://apocalypsechess.online/\r\n" +

                "https://www.chessvariants.com/rules/apocalypse\r\n" +

                "https://www.makeareadme.com/\r\n" +

                "https://courses.cs.washington.edu/courses/cse326/02wi/homework/hw5/good-readmes.html\r\n" +

                "https://stackoverflow.com/questions/43647368/how-can-i-get-make-my-program-wait-until-javafx-window-has-been-closed-before-co\r\n" +

                "https://stackoverflow.com/questions/21083945/how-to-avoid-not-on-fx-application-thread-currentthread-javafx-application-th\r\n" +

                "https://docs.oracle.com/javafx/scenebuilder/1/overview/jsbpub-overview.htm\r\n" +

                "https://docs.oracle.com/javase/8/javafx/api/overview-summary.html\r\n" +

                "https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/choice-box.htm#BCEDJAEH\r\n" +

                "https://stackoverflow.com/questions/22145327/nullpointerexception-javafx-label-settext\r\n" +

                "https://stackoverflow.com/questions/22848829/how-do-i-add-an-image-inside-a-rectangle-or-a-circle-in-javafx");


        Group root = new Group();

        int xSceneLayout = 1100;
        int ySceneLayout = 900;

        Scene scene = new Scene(root, xSceneLayout, ySceneLayout, Color.BLACK);

        Authors.setLayoutX(xSceneLayout-1100 );
        Authors.setLayoutY(ySceneLayout -900);
        Authors.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 40));
        Authors.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(Authors);

        Authors2.setLayoutX(xSceneLayout-1100 );
        Authors2.setLayoutY(ySceneLayout -850);
        Authors2.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 25));
        Authors2.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(Authors2);

        files.setLayoutX(xSceneLayout-1100 );
        files.setLayoutY(ySceneLayout -800);
        files.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 40));
        files.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(files);

        files2.setLayoutX(xSceneLayout-1100 );
        files2.setLayoutY(ySceneLayout -750);
        files2.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 10));
        files2.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(files2);

        files3.setLayoutX(xSceneLayout-1100 );
        files3.setLayoutY(ySceneLayout -740);
        files3.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 10));
        files3.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(files3);

        files4.setLayoutX(xSceneLayout-1100 );
        files4.setLayoutY(ySceneLayout -730);
        files4.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 10));
        files4.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(files4);

        preReq.setLayoutX(xSceneLayout-1100 );
        preReq.setLayoutY(ySceneLayout -720);
        preReq.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 40));
        preReq.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(preReq);

        preReq1.setLayoutX(xSceneLayout-1100 );
        preReq1.setLayoutY(ySceneLayout -680);
        preReq1.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
        preReq1.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(preReq1);

        instructions.setLayoutX(xSceneLayout-1100 );
        instructions.setLayoutY(ySceneLayout -640);
        instructions.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 40));
        instructions.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(instructions);

        instructions1.setLayoutX(xSceneLayout-1100 );
        instructions1.setLayoutY(ySceneLayout -600);
        instructions1.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 12));
        instructions1.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(instructions1);

        refrences.setLayoutX(xSceneLayout-1100 );
        refrences.setLayoutY(ySceneLayout -510);
        refrences.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 40));
        refrences.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(refrences);

        refrences1.setLayoutX(xSceneLayout-1100 );
        refrences1.setLayoutY(ySceneLayout -470);
        refrences1.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 12));
        refrences1.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(refrences1);

        refrences2.setLayoutX(xSceneLayout-1100 );
        refrences2.setLayoutY(ySceneLayout -455);
        refrences2.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 12));
        refrences2.setTextFill(Color.GHOSTWHITE);
        root.getChildren().add(refrences2);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

}
