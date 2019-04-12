package GUI;

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

public class GUIendBanner extends Application {

    private String name = "";
    private Stage stage = new Stage();

    /**
     *  Constructor that sets the stage name and stage
     * @param name
     * @param stage
     */
    public GUIendBanner(String name, Stage stage){
        setName(name);
        setStage(stage);
    }

    /**
     * Setter for the stage
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Setter for the named
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);

    }

    /**
     * Start method that starts the stage for the end banner once the game is completed.
     * @param primaryStage
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception {
        // set title
        primaryStage.setTitle("Game Over");
        //Create everything I need
        Label congrats = new Label("        " + "Congratulations" + " " + name );
        Button mainMenu = new Button("Main Menu");
        Label rematch = new Label("Would you like to play again?");
        MainMenu mainmenuOpen = new MainMenu();

        Group root = new Group();
        int xSceneLayout = 500;
        int ySceneLayout = 500;

        Scene scene = new Scene(root, xSceneLayout, ySceneLayout, Color.BLACK);


        congrats.setLayoutX(xSceneLayout-500);
        congrats.setLayoutY(ySceneLayout / 6);
        congrats.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 30));
        congrats.setTextFill(Color.DARKRED);
        root.getChildren().add(congrats);

        mainMenu.setStyle("-fx-background-color:GREY");
        mainMenu.setLayoutX(xSceneLayout-310);
        mainMenu.setLayoutY(ySceneLayout -100);
        mainMenu.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 20));
        mainMenu.setTextFill(Color.DARKRED);
        root.getChildren().add(mainMenu);


        rematch.setLayoutX(xSceneLayout-375);
        rematch.setLayoutY(ySceneLayout -250);
        rematch.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 20));
        rematch.setTextFill(Color.DARKRED);
        root.getChildren().add(rematch);

        mainMenu.setOnAction(e -> {
            stage.close();
            Stage s = new Stage();
            try {
                mainmenuOpen.start(s);
            } catch (Exception e1) {

                e1.printStackTrace();
            }
            primaryStage.close();


        });




        primaryStage.setScene(scene);
        primaryStage.show();
    }
}