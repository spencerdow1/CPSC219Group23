import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;


public class GUI extends Application implements EventHandler<KeyEvent> {
    private final int WINDOW_WIDTH = 600;
    private final int WINDOW_HEIGHT = 400;
    private Board board = new Board();
    int pixelsY = WINDOW_HEIGHT / 5;
    int pixelsX = WINDOW_WIDTH / 5;

    public void start(Stage primaryStage) {
        //creates primary stage
        primaryStage.setTitle("Apocalypse Chess");
        BorderPane gamePane = new BorderPane();
        Pane wrapperPane = new Pane();
        gamePane.setCenter(wrapperPane);
        Scene gameScene = new Scene(gamePane, WINDOW_WIDTH, WINDOW_HEIGHT);

        VBox introBox = new VBox();
        Scene introScene = new Scene(introBox, WINDOW_WIDTH, WINDOW_HEIGHT);
        Text instructions1 = new Text("Player 1 enter your name: ");
        TextField enterName1 = new TextField();
        enterName1.setPromptText("name");
        Text instructions2 = new Text("Player 1 enter your name: ");
        TextField enterName2 = new TextField();
        enterName2.setPromptText("name");
        Text instructions5 = new Text("Good luck!");
        Button startButton = new Button("START");

        introBox.getChildren().add(instructions1);
        instructions1.setTextAlignment(TextAlignment.CENTER);
        introBox.getChildren().add(enterName1);

        introBox.getChildren().add(instructions2);
        instructions2.setTextAlignment(TextAlignment.CENTER);
        introBox.getChildren().add(enterName2);

        introBox.getChildren().add(startButton);

        primaryStage.setScene(introScene);
        primaryStage.show();

        // not every line of code here is utilized, will need to revisit in future
        Group root = new Group();
        Canvas gameCanvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
        wrapperPane.getChildren().add(root);
        root.getChildren().add(gameCanvas);

        for (int i = 0; i < 25; i++) {
            Rectangle square = new Rectangle();
            root.getChildren().add(square);

            int row = (i / 8) % 2;
            if (row == 0)
                square.setFill( i % 2 == 0 ? Color.BROWN : Color.WHITE);
            else
                square.setFill( i % 2 == 0 ? Color.GREEN :  Color.BROWN);
        }


        for(int x = 0; x <=4 ; x += 2){

            Rectangle pattern = new Rectangle(0* pixelsX,x* pixelsY, pixelsX, pixelsY);
            root.getChildren().add(pattern);
            pattern.setFill(Color.BROWN);
            for(int y = 1; y<4 ; y += 2){
                Rectangle pattern2 = new Rectangle(1* pixelsX,y* pixelsY, pixelsX, pixelsY);
                root.getChildren().add(pattern2);
                pattern2.setFill(Color.BROWN);
                for(int z = 0; z <=4; z+=2){
                    Rectangle pattern3 = new Rectangle(2* pixelsX,z* pixelsY, pixelsX, pixelsY);
                    root.getChildren().add(pattern3);
                    pattern3.setFill(Color.BROWN);
                    for(int w = 1; w<4 ; w += 2){
                        Rectangle pattern4 = new Rectangle(3* pixelsX,w* pixelsY, pixelsX, pixelsY);
                        root.getChildren().add(pattern4);
                        pattern4.setFill(Color.BROWN);
                        for(int u = 0; u <=4; u+=2){
                            Rectangle pattern5 = new Rectangle(4* pixelsX,u* pixelsY, pixelsX, pixelsY);
                            root.getChildren().add(pattern5);
                            pattern5.setFill(Color.BROWN);
                        }
                    }
                }
            }
         }



        //root.getChildren().add(rect);
        //rect.setFill(Color.BLUE);
        for (int y = 4; y >= 0; y--) {
            for (int x = 0; x < 5; x++) {
                Rectangle rect = new Rectangle();
                rect.setWidth(600/20);
                rect.setHeight(400/20);
              //  rect.setX(Board.getSpace()*pixelsX);
                //rect.setY(Board.get()*pixelsY);
                root.getChildren().add(rect);
                rect.setFill(Color.BLUE);            }
        }



        startButton.setOnAction(event-> {
            System.out.println("Game has started.");
            primaryStage.setScene(gameScene);

        });
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(KeyEvent event) {

    }
}
