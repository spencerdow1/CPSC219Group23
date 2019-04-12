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



public class GUIFileIO extends Application {
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {

        launch(args);



    }



    @Override
/**
 * FileIo scene that displays the highscores in a text file which is accessed through the mainmenu
 */
    public void start(Stage primaryStage) throws Exception {
    	MainMenu mainmenuCall = new MainMenu();
        // set title

        primaryStage.setTitle("High Scores");

        //Create everything I need'
        
        Button mainmenuButton = new Button("Main Menu");
        Label HSlabel = new Label("High Score ");
        Label firstPlace = new Label();

        //create new group
        Group root = new Group();
        
        //define dimensions of Scene
        int xSceneLayout = 400;
        int ySceneLayout = 600;
        
        
        /**
    	 * Creates the scene
    	 * @param <root> takes in the group created
    	 * @param <xSceneLayout> sets x dimensions in scene
    	 * @param <ySceneLayout> sets y dimensions in scene
    	 * @param <Color.BLACK> sets the background color of scene
    	 * 
    	 * 
        **/
        
        Scene scene = new Scene(root, xSceneLayout, ySceneLayout, Color.BLACK);



        HSlabel.setLayoutX(xSceneLayout -310);

        HSlabel.setLayoutY(ySceneLayout / 6);

        HSlabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 50));

        HSlabel.setTextFill(Color.DARKRED);

        root.getChildren().add(HSlabel);



        firstPlace.setLayoutX(xSceneLayout -260);

        firstPlace.setLayoutY(ySceneLayout / 3);

        firstPlace.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 25));

        firstPlace.setTextFill(Color.WHITE);

        // The name of the file to open.

        String fileName = "src\\Logic\\Winners.txt";



        // This will reference one line at a time

        String line = null;

        String lists = "";

        ArrayList<String> winners = null;

        



        try {



            FileReader fileReader = new FileReader(fileName);



            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null){

                lists = lists + "\n" + line;

            }



            firstPlace.setText(lists);

            root.getChildren().add(firstPlace);



            bufferedReader.close();

        }

        catch(FileNotFoundException ex) {



        }

        catch(IOException ex) {



            ex.printStackTrace();

        }


        mainmenuButton.setStyle("-fx-background-color:GREY");
        mainmenuButton.setLayoutX(xSceneLayout-150);
        mainmenuButton.setLayoutY(ySceneLayout -100);
        mainmenuButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 20));
        mainmenuButton.setTextFill(Color.DARKRED);
        root.getChildren().add(mainmenuButton);
        
mainmenuButton.setOnAction(e -> {
            primaryStage.close();
            Stage s = new Stage();
            try {
                mainmenuCall.start(s);
                
            } catch (Exception e1) {

                e1.printStackTrace();
            }
            primaryStage.close();


        });

       


        primaryStage.setScene(scene);

        primaryStage.show();

    }

}
