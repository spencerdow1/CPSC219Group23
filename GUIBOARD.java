import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.lang.Math;

public class GUIBOARD extends Application {


    @Override
    public void start(Stage primaryStage) {
        System.out.println("");
        GridPane root = new GridPane();
        int size = 5;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col ++) {
                StackPane square = new StackPane();
                String color ;
                if ((row + col) % 2 == 0) {
                    color = "white";
                } else {
                    color = "black";
                }
                square.setStyle("-fx-background-color: "+color+";");
                root.add(square, col, row);
            }
        }
       
        for (int i = 0; i < size; i++) {
            root.getColumnConstraints().add(new ColumnConstraints(5,
                Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY,
                Priority.ALWAYS, HPos.CENTER, true));
            root.getRowConstraints().add(new RowConstraints(5,
                Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY,
                Priority.ALWAYS, VPos.CENTER, true));
        }


        // Define dimensions of the board
        int dimX = 500;
        int dimY = 500;

        // create the click based game
        ApocalypseClick clickGame = new ApocalypseClick(dimX, dimY);

        // build the scene and add the event
        Scene theScene = new Scene(root, dimX, dimY);
        theScene.addEventFilter(MouseEvent.MOUSE_CLICKED, clickGame);
        primaryStage.setScene(theScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
