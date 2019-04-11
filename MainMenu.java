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
import Logic.*;

public class MainMenu extends Application{
	 private Player white = new HumanPlayer();
	 private Player black = new HumanPlayer();
	 private Board board = new Board();
	 private String diff = "";
	 GUIFileIO highscore = new GUIFileIO();
	 GUIBOARD gui = new GUIBOARD(white, black, diff);
	 GUIreadme readme = new GUIreadme();
	 GUIinstructions instructions = new GUIinstructions();

	public void setDiff(String diff) {
		this.diff = diff;
	}

	public static void main(String[] args) {
	launch(args);
	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	// set title
	primaryStage.setTitle("Apocalypse");
	//Create everything I need 
	Label apocLabel = new Label("APOCALYPSE ");
	// setBackround color
	Group root = new Group();
	int xSceneLayout = 400;
	int ySceneLayout = 600;
	
	Scene scene = new Scene(root, xSceneLayout, ySceneLayout, Color.BLACK);
	
	apocLabel.setLayoutX(xSceneLayout /4);
	apocLabel.setLayoutY(ySceneLayout / 6);
	apocLabel.setFont(Font.font("Mistral", FontWeight.EXTRA_BOLD, 50));
	apocLabel.setTextFill(Color.DARKRED);
	root.getChildren().add(apocLabel);
	
	ToggleGroup group = new ToggleGroup(); 
	ToggleButton singleButton = new ToggleButton("SINGLE PLAYER");
	singleButton.setLayoutX(80);
	singleButton.setLayoutY(ySceneLayout / 3);
	singleButton.setFont(Font.font("Arial Black", FontWeight.EXTRA_BOLD, 10));
	singleButton.setStyle("-fx-background-color:BLACK");
	singleButton.setTextFill(Color.DARKRED);
	root.getChildren().add(singleButton);
	
	ToggleButton multiButton = new ToggleButton("MULTIPLAYER");
	multiButton.setLayoutX(230);
	multiButton.setLayoutY(ySceneLayout / 3);
	multiButton.setFont(Font.font("Arial Black", FontWeight.EXTRA_BOLD, 10));
	multiButton.setStyle("-fx-background-color:BLACK");
	multiButton.setTextFill(Color.DARKRED);
	root.getChildren().add(multiButton);
	
	singleButton.setToggleGroup(group); 
	multiButton.setToggleGroup(group); 
	
	
	TextField firstName = new TextField("Player One");
	firstName.setPrefWidth(100);
	firstName.setLayoutX(80);
	firstName.setLayoutY(ySceneLayout / 2.5);
	firstName.setStyle("-fx-background-color:BLACK;-fx-text-fill: BLACK  ");
	
	
	TextField secondName = new TextField("Computer");
	secondName.setPrefWidth(100);
	secondName.setLayoutX(230);
	secondName.setLayoutY(ySceneLayout / 2.5);
	secondName.setStyle("-fx-background-color:BLACK;-fx-text-fill: BLACK  ");
	
	
	ChoiceBox<String> selectDiff = new ChoiceBox<>(
	FXCollections.observableArrayList("Beginner", "Advanced"));
	selectDiff.setLayoutX(145);
	selectDiff.setLayoutY(350);
	selectDiff.setValue("Beginner");
	selectDiff.setStyle("-fx-background-color:LightCoral   ");
	
	
	Button startButton = new Button("START GAME");
	startButton.setLayoutX(140);
	startButton.setLayoutY(450);
	startButton.setFont(Font.font("Mistral", FontWeight.EXTRA_BOLD, 25));
	startButton.setStyle("-fx-background-color:BLACK");
	startButton.setTextFill(Color.DARKRED);
	
	
	Button instructionButton = new Button("Instructions");
	instructionButton.setLayoutX(xSceneLayout-xSceneLayout);
	instructionButton.setLayoutY(575);
	instructionButton.setFont(Font.font("Arial Black", FontWeight.EXTRA_BOLD, 12));
	instructionButton.setStyle("-fx-background-color:BLACK");
	instructionButton.setTextFill(Color.WHITE);
	root.getChildren().add(instructionButton);
	
	Button readmeButton = new Button("Readme");
	readmeButton.setLayoutX(xSceneLayout-70);
	readmeButton.setLayoutY(575);
	readmeButton.setFont(Font.font("Arial Black", FontWeight.EXTRA_BOLD, 12));
	readmeButton.setStyle("-fx-background-color:BLACK");
	readmeButton.setTextFill(Color.WHITE);
	root.getChildren().add(readmeButton);
	
	Button highscores = new Button("HighScores");
	highscores.setLayoutX(xSceneLayout-240);
	highscores.setLayoutY(575);
	highscores.setFont(Font.font("Arial Black", FontWeight.EXTRA_BOLD, 12));
	highscores.setStyle("-fx-background-color:BLACK");
	highscores.setTextFill(Color.WHITE);
	root.getChildren().add(highscores);
	
	instructionButton.setOnAction(e -> {
		Stage c = new Stage();
		try {
			instructions.start(c);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		
	});
	//change single player to one selected
	singleButton.setOnAction(e -> {
	singleButton.setTextFill(Color.WHITE);
	multiButton.setTextFill(Color.DARKRED);
	firstName.setStyle("-fx-background-color:LightCoral  ");
	secondName.setStyle("-fx-background-color:BLACK;-fx-text-fill: BLACK  ");
	secondName.setText("Computer");
	startButton.setTextFill(Color.DARKRED);
	root.getChildren().add(selectDiff);
	root.getChildren().remove(firstName);
	root.getChildren().add(firstName);
	root.getChildren().remove(startButton);
	root.getChildren().add(startButton);
	
	});
	readmeButton.setOnAction(e ->{
	Stage b = new Stage();
	try {
		readme.start(b);
	} catch (Exception e1) {
		
		e1.printStackTrace();
	}
	
	
	
	});
	
	
	
		
	
	//change to multiplayer mode
	multiButton.setOnAction(e -> {
	                multiButton.setTextFill(Color.WHITE);
	singleButton.setTextFill(Color.DARKRED);
	firstName.setStyle("-fx-background-color:LightCoral  ");
	secondName.setText("Player Two");
	secondName.setStyle("-fx-background-color:LightCoral  ");
	startButton.setTextFill(Color.DARKRED);
	root.getChildren().remove(secondName);
	root.getChildren().remove(firstName);
	root.getChildren().add(firstName);
	root.getChildren().add(secondName);
	root.getChildren().remove(selectDiff);
	root.getChildren().remove(startButton);
	root.getChildren().add(startButton);
	});
	highscores.setOnAction(e -> {
		Stage a = new Stage();
		try{
			highscore.start(a);
		} catch (Exception e1){
			e1.printStackTrace();
		}
			});
	startButton.setOnAction(e -> {
	
	white.setName(firstName.getText());
    black.setName(secondName.getText());
    

    setDiff(selectDiff.getValue());
    
    GUIBOARD gui = new GUIBOARD(white, black, diff);
    
    Stage s = new Stage();
	gui.start(s);
	primaryStage.close();
	
	});
	
	primaryStage.setScene(scene);
	primaryStage.show();
	}
}