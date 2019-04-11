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

public class GUIFileIO extends Application{
	
	 
	public static void main(String[] args) {
	launch(args);
	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	// set title
	primaryStage.setTitle("High Scores");
	//Create everything I need'
	Label HSlabel = new Label("High Score ");
	Label firstPlace = new Label();
	// setBackround color
	Group root = new Group();
	int xSceneLayout = 400;
	int ySceneLayout = 600;
	
	Scene scene = new Scene(root, xSceneLayout, ySceneLayout, Color.BLACK);
	
	HSlabel.setLayoutX(xSceneLayout /4);
	HSlabel.setLayoutY(ySceneLayout / 6);
	HSlabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 50));
	HSlabel.setTextFill(Color.DARKRED);
	root.getChildren().add(HSlabel);
	
	firstPlace.setLayoutX(xSceneLayout /2.5);
	firstPlace.setLayoutY(ySceneLayout / 3);
	firstPlace.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 25));
	firstPlace.setTextFill(Color.WHITE);
	  // The name of the file to open.
    String fileName = "src\\GUI\\Winners.txt";

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

	
	primaryStage.setScene(scene);
	primaryStage.show();
	}
}