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



public class GUIinstructions extends Application {
	
	
	
	
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {

        launch(args);

    }
    
    
    @Override
    /**
     * Sets the instructions scene and which is accessed from the main menu.
     */
    public void start(Stage primaryStage) throws Exception {
    	MainMenu mainmenucall = new MainMenu();
        // set title
        primaryStage.setTitle("Instructions");

        //create the labels
        Label Instructions = new Label("Instructions ");
        Label InstructionsContent = new Label("Horsemen and footmen move and capture the same as knights and pawns in chess,\r\n"+
        
        "except footmen do not have a double-step option on their first move.\r\n"+
        "\r\n"+
        		" For each turn, each player secretly determines his move,\r\n"
        +" then the players simultaneously declare them. The following rules apply:\r\n"+
        		
        		"	*If they moved to the same square, a horseman captures a footman.\r\n"+
        		"	*Same-type pieces are both removed from the board.\r\n"+
        		"	*If a capture was declared using a pawn, "
        		+ "but the piece to be captured\r\n"+
        		"	  moved from its square, the pawns move still stands.\r\n"+
        		"	  The move converts to a diagonal step instead of a capture.\r\n"+
        		"\r\n"+
        		"A pawn is promoted to a horseman when it reaches the opponents first row.\r\n"+
        		"\r\n"+
        		"\r\n"+
        		"The game ends once one player has eliminated all of the oponents pawns.");
        

        //main menu button
        Button mainmenuButton = new Button("Main Menu");
        
        
        //size of scene and new instance of a Group
        Group root = new Group();
        int xSceneLayout = 710;
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


        //paramaters for instructions label
        Instructions.setLayoutX(xSceneLayout -500);
        Instructions.setLayoutY(ySceneLayout -600);
        Instructions.setFont(Font.font("Times new Roman", FontWeight.EXTRA_BOLD, 50));
        Instructions.setTextFill(Color.DARKRED);
        root.getChildren().add(Instructions);


        //parameters for instructions content
        InstructionsContent.setLayoutX(xSceneLayout -705);
        InstructionsContent.setLayoutY(ySceneLayout -450);
        InstructionsContent.setFont(Font.font("Times new Roman", FontWeight.EXTRA_BOLD, 20));
        InstructionsContent.setTextFill(Color.WHITE);
        root.getChildren().add(InstructionsContent);
        
        
        mainmenuButton.setStyle("-fx-background-color:GREY");
        mainmenuButton.setLayoutX(xSceneLayout-150);
        mainmenuButton.setLayoutY(ySceneLayout -50);
        mainmenuButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 20));
        mainmenuButton.setTextFill(Color.DARKRED);
        root.getChildren().add(mainmenuButton);
        
        mainmenuButton.setOnAction(e -> {
            
            Stage s = new Stage();
            try {
                mainmenucall.start(s);
                
            } catch (Exception e1) {

                e1.printStackTrace();
            }
            primaryStage.close();


        });

        

        primaryStage.setScene(scene);

        primaryStage.show();

    }

}
