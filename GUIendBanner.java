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

	public static void main(String[] args) {
		launch(args);

	}
	public void start(Stage primaryStage) throws Exception {
		// set title
		primaryStage.setTitle("Game Over");
		//Create everything I need 
		Label congrats = new Label("Congratulations"/* +player name,*/ );
		Button mainMenu = new Button("Main Menu");
		Button playAgain = new Button("Play Again ");
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
		
		playAgain.setStyle("-fx-background-color:GREY");
		playAgain.setLayoutX(xSceneLayout-310);
		playAgain.setLayoutY(ySceneLayout -200);
		playAgain.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 20));
		playAgain.setTextFill(Color.DARKRED);
		root.getChildren().add(playAgain);
		
		rematch.setLayoutX(xSceneLayout-375);
		rematch.setLayoutY(ySceneLayout -250);
		rematch.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 20));
		rematch.setTextFill(Color.DARKRED);
		root.getChildren().add(rematch);
		
		mainMenu.setOnAction(e -> {
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
