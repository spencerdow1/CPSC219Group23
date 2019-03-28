import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.ConstraintsBase;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.Label;
import java.lang.Math;
import java.util.List;

public class GUIBOARD extends Application {
	
    @Override
    public void start(Stage primaryStage) {
    	int WINDOW_WIDTH=300;
    	int WINDOW_HEIGHT=300;
    	
    	
        StackPane spRoot=new StackPane();
        GridPane root = new GridPane();
        Label apoc= new Label("APOCALYPSE");
        Scene theScene = new Scene(spRoot, 500, 500, Color.BLACK);
        
        root.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        root.setMinSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        SubScene sub = new SubScene(root,300,300);
        
        
        apoc.setFont(Font.font("Mistral", FontWeight.EXTRA_BOLD, 50));
    	apoc.setTextFill(Color.DARKRED);
    	StackPane.setAlignment( apoc, Pos.TOP_CENTER );
    	spRoot.getChildren().add(apoc);
        spRoot.setStyle("-fx-background-color: BLACK;");
        //spRoot.getChildren().addAll(root);
        
        int rowNum = 5;
        int colNum = 5;
        int gridHeight = 5;
        int gridWidth = 5;
        
        int count = 0;
        
        //Color[] colors = {Color.RED, Color.BLACK};
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                Rectangle rec = new Rectangle();
                if (count == 0 ) {
                rec.setWidth(60);
                rec.setHeight(60);
                rec.setFill(Color.DARKRED);      
                count ++;
                
                }else if (count==1) {
                	rec.setWidth(60);
                    rec.setHeight(60);
                    rec.setFill(Color.GREY);
                    count = count -1;
                    
                }
                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
           
                root.getChildren().addAll(rec);
               
            }
        }
          
            Image imageBlackPawn = new Image("black_pawn.png");
            Image imageWhitePawn = new Image("white_pawn.png");
            Image imageBlackKnight = new Image("black_knight.png");
            Image imageWhiteKnight = new Image("white_knight.png");
            root.add(new ImageView(imageBlackPawn), 0,1);
            root.add(new ImageView(imageBlackPawn), 1,0);
            root.add(new ImageView(imageBlackPawn), 2,0);
            root.add(new ImageView(imageBlackPawn), 3,0);
            root.add(new ImageView(imageBlackPawn), 4,1);
            
            root.add(new ImageView(imageWhitePawn), 0,3);
            root.add(new ImageView(imageWhitePawn), 4,3);
            root.add(new ImageView(imageWhitePawn), 3,4);
            root.add(new ImageView(imageWhitePawn), 2,4);
            root.add(new ImageView(imageWhitePawn), 1,4);
            
            root.add(new ImageView(imageBlackKnight), 0,0);
            root.add(new ImageView(imageBlackKnight), 4,0);
            
            root.add(new ImageView(imageWhiteKnight), 4,4);
            root.add(new ImageView(imageWhiteKnight), 0,4);

        // Define dimensions of the board
        int dimX = 300;
        int dimY = 300;
 
        	
        	//GridPane.setConstraints(root.getChildren()., getNewcoord, 0);
 

        // create the click based game
        ApocalypseClick clickGame = new ApocalypseClick(dimX, dimY);
        
        // build the scene and add the event
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, clickGame);
        
        
       
      
        spRoot.getChildren().addAll(sub);
        
        
        primaryStage.setScene(theScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
