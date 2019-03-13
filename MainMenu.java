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

public class MainMenu extends Application{
	 private Player white = new Player(PlayerTeam.White);
	 private Player black = new Player(PlayerTeam.Black);
	 private Board board = new Board();
	 GUIBOARD gui = new GUIBOARD();

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
	
	apocLabel.setLayoutX(xSceneLayout / 20);
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
	
	//this one make it more aesthetically pleasing by not iluminating player 1 name
	TextField random = new TextField("");
	random.setPrefWidth(-80);
	random.setLayoutX(-80);
	random.setLayoutY(ySceneLayout / 2.5);
	//firstName.setStyle("-fx-background-color:DarkSlateGrey ");
	root.getChildren().add(random);
	
	TextField firstName = new TextField("Player 1");
	firstName.setPrefWidth(100);
	firstName.setLayoutX(80);
	firstName.setLayoutY(ySceneLayout / 2.5);
	firstName.setStyle("-fx-background-color:BLACK;-fx-text-fill: BLACK  ");
	root.getChildren().add(firstName);
	
	TextField secondName = new TextField("Player 2");
	secondName.setPrefWidth(100);
	secondName.setLayoutX(230);
	secondName.setLayoutY(ySceneLayout / 2.5);
	secondName.setStyle("-fx-background-color:BLACK;-fx-text-fill: BLACK  ");
	root.getChildren().add(secondName);
	
	ChoiceBox<String> selectDiff = new ChoiceBox<>(
	FXCollections.observableArrayList("Choose Difficulty","Beginner", "Intermediate", "Master"));
	selectDiff.setLayoutX(145);
	selectDiff.setLayoutY(350);
	selectDiff.setValue("Choose Difficulty");
	selectDiff.setStyle("-fx-background-color:LightCoral   ");
	root.getChildren().add(selectDiff);
	
	Button startButton = new Button("START GAME");
	startButton.setLayoutX(140);
	startButton.setLayoutY(450);
	startButton.setFont(Font.font("Mistral", FontWeight.EXTRA_BOLD, 25));
	startButton.setStyle("-fx-background-color:BLACK");
	startButton.setTextFill(Color.BLACK);
	root.getChildren().add(startButton);
	
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
	
	//change single player to one selected
	singleButton.setOnAction(e -> {
	singleButton.setTextFill(Color.WHITE);
	multiButton.setTextFill(Color.DARKRED);
	firstName.setStyle("-fx-background-color:LightCoral  ");
	secondName.setStyle("-fx-background-color:BLACK;-fx-text-fill: BLACK  ");
	startButton.setTextFill(Color.DARKRED);
	});
	
	//change to multiplayer mode
	multiButton.setOnAction(e -> {
	                multiButton.setTextFill(Color.WHITE);
	singleButton.setTextFill(Color.DARKRED);
	firstName.setStyle("-fx-background-color:LightCoral  ");
	secondName.setStyle("-fx-background-color:LightCoral  ");
	startButton.setTextFill(Color.DARKRED);
	});
	
	startButton.setOnAction(e -> {

	white.setPlayerName(firstName.getText());
    black.setPlayerName(secondName.getText());
	
    System.out.print(white.playerName);
    Stage s = new Stage();
	gui.start(s);
	
	});
	
	primaryStage.setScene(scene);
	primaryStage.show();
	}
}