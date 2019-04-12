package GUI;
import Logic.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

import static java.lang.Math.abs;

import java.awt.Insets;

public class GUIBOARD extends Application {
	
	private Player playerOne;
	private Player playerTwo;
	private AIPlayer computer;
	private String diff;
	
	public GUIBOARD(){
    }

    public GUIBOARD(Player white, Player black, String difficulty) {
		playerOne = white;
		playerTwo = black;
		diff = difficulty;
	}

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setResizable(false);
    	int WINDOW_WIDTH=300;
    	int WINDOW_HEIGHT=300;
    	
    	
    	
    	
        StackPane spRoot=new StackPane();
        StackPane spRoot2 = new StackPane();
        GridPane root = new GridPane();
        Label apoc= new Label("APOCALYPSE");
        Label player1Label = new Label(playerOne.getName());
        //player1Label.setPadding(new Insets (0, 0, 75, 0));
        
        Label player2Label = new Label(playerTwo.getName());
        Scene theScene = new Scene(spRoot, 500, 500, Color.BLACK);
        
        
        root.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        root.setMinSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        SubScene sub = new SubScene(root,300,300);
        SubScene sub2 = new SubScene(spRoot2,375,375);
      
      
        
        
        
        apoc.setFont(Font.font("Mistral", FontWeight.EXTRA_BOLD, 50));
    	apoc.setTextFill(Color.DARKRED);
    	StackPane.setAlignment( apoc, Pos.TOP_CENTER );
    	spRoot.getChildren().add(apoc);
        spRoot.setStyle("-fx-background-color: BLACK;");
        //spRoot.getChildren().addAll(root);
       
        player1Label.setFont(Font.font("Times new roman", FontWeight.EXTRA_BOLD, 25));
        player1Label.setTextFill(Color.DARKCYAN);
    	StackPane.setAlignment( player1Label, Pos.BOTTOM_CENTER );
    	spRoot2.getChildren().add(player1Label);
    	spRoot2.setStyle("-fx-background-color: BLACK;");
    	
    	player2Label.setFont(Font.font("Times new roman", FontWeight.EXTRA_BOLD, 25));
        player2Label.setTextFill(Color.DARKCYAN);
    	StackPane.setAlignment(player2Label, Pos.TOP_CENTER);
    	spRoot2.getChildren().add(player2Label);
//
//    	Label username = new Label();
//    	
//    	username.setTextFill(Color.GREEN);
//    	StackPane.setAlignment( apoc, Pos.TOP_CENTER );
//      spRoot.getChildren().add(username);
        
        
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

            Image imageBlackPawn = new Image("GUI/black_pawn.png");
            Image imageWhitePawn = new Image("GUI/white_pawn.png");
            Image imageBlackKnight = new Image("GUI/black_knight.png");
            Image imageWhiteKnight = new Image("GUI/white_knight.png");
            Image imageWhitePawnHighlight = new Image ( "GUI/white_pawn_highlight.png");
            Image imageBlackPawnHighlight = new Image ( "GUI/black_pawn_highlight.png");
            Image imageWhiteKnightHighlight = new Image ( "GUI/white_Knight_highlight.png");
            Image imageBlackKnightHighlight = new Image ( "GUI/black_knight_highlight.png");


        // Define dimensions of the board
        int dimX = 300;
        int dimY = 300;
 
        	
        	//GridPane.setConstraints(root.getChildren()., getNewcoord, 0);
       
        
        // create the click based game
        ApocalypseClick clickGame = new ApocalypseClick(dimX, dimY, root,playerOne.getName(), playerTwo.getName(), diff, primaryStage);

        // build the scene and add the event
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, clickGame);
        
      
        
      

        GameSet gameSet = new DefaultGameSet();
        ArrayList<Piece> list = gameSet.getGamePieces();

        for (int l = 0; l < 5; l++){

            for (int j = 0; j < 5; j++){
                for (Piece aPiece : list){
                    Coord checkCoord = new Coord(l,j);
                    if(aPiece.getPosition().equals(checkCoord)){
                        if(aPiece.getType() == "pawn"){
                            if(aPiece.getColour() == "white"){
                                root.add(new ImageView(imageWhitePawn), l, abs(4-j));
                            }
                            else root.add(new ImageView(imageBlackPawn), l,abs(4-j));
                        }
                        if(aPiece.getType() == "knight"){
                            if(aPiece.getColour() == "white"){
                                root.add(new ImageView(imageWhiteKnight), l, abs(4-j));
                            }
                            else root.add(new ImageView(imageBlackKnight), l, abs(4-j));
                        }
                    }

                    }
                }
        

        }
        

        spRoot.getChildren().addAll(sub2,sub);
        primaryStage.setScene(theScene);
        
        primaryStage.show();
    }
    


    public static void main(String[] args) {
        launch(args);
    }
}

