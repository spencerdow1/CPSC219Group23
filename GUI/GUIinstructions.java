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
    public static void main(String[] args) {

        launch(args);

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        // set title
        primaryStage.setTitle("Instructions");

        //create the labels
        Label Instructions = new Label("Instructions ");
        Label InstructionsContent = new Label(""); //Put the instructions in the quotations, use\r\n + to feed new line,
        //reference guireadme if confused
        //to change layout and parameters see line 90-95


        //size of scene
        Group root = new Group();
        int xSceneLayout = 400;
        int ySceneLayout = 600;

        //builds the scene
        Scene scene = new Scene(root, xSceneLayout, ySceneLayout, Color.BLACK);


        //paramaters for instructions label
        Instructions.setLayoutX(xSceneLayout -325);
        Instructions.setLayoutY(ySceneLayout / 6);
        Instructions.setFont(Font.font("Times new Roman", FontWeight.EXTRA_BOLD, 50));
        Instructions.setTextFill(Color.DARKRED);
        root.getChildren().add(Instructions);


        //parameters for instructions content
        InstructionsContent.setLayoutX(xSceneLayout -325);
        InstructionsContent.setLayoutY(ySceneLayout / 6);
        InstructionsContent.setFont(Font.font("Times new Roman", FontWeight.EXTRA_BOLD, 50));
        InstructionsContent.setTextFill(Color.DARKRED);
        root.getChildren().add(InstructionsContent);



        primaryStage.setScene(scene);

        primaryStage.show();

    }

}
