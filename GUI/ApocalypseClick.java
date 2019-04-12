package GUI;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.lang.Math;
import java.util.ArrayList;
import Logic.*;
import javafx.stage.Stage;

import static java.lang.Math.abs;

public class ApocalypseClick implements EventHandler<MouseEvent> {
        
    private int sceneSizeX, sceneSizeY;
    private double xClickLoc, yClickLoc;
    private int numTurnClicks = 0;
    private int numTurn = 0;
    private Coord lastClick;
    private ArrayList<Coord> turnCoords;
    private GridPane root;
    private Coord WhitePieceSelection;
    private Coord WhitePieceMove;
    private Coord BlackPieceSelection;
    private Coord BlackPieceMove;
    private String diff;
    private Stage scene = new Stage();
    GameDynamicsGUI gameDynamics = new GameDynamicsGUI();
    GameSet gameSet = new DefaultGameSet();
    Board board = new Board(gameSet);
    ArrayList<Piece> list = gameSet.getGamePieces();
    String name1 = "";
    String name2 = "Computer";
    FileIO file = new FileIO();

    /**
     *
     * @param dimX
     * @param dimY
     * @param root
     * @param name1
     * @param name2
     * @param diff
     * @param scence
     */
    public ApocalypseClick(int dimX, int dimY, GridPane root, String name1, String name2, String diff, Stage scence){
        setXSize(dimX);
        setYSize(dimY);
        setRoot(root);
        this.name1 = name1;
        setName2(name2);
        setDiff(diff);
        setScene(scene);

    }


    /**
     *
     * @param scene
     */

    public void setScene(Stage scene) {
        this.scene = scene;
    }

    /**
     *
     * @param diff
     */
    public void setDiff(String diff) {
        this.diff = diff;
    }

    /**
     *
     * @param comp
     */
    public void setName2(String comp) {
        this.name2 = comp;
    }

    /**
     *
     * @param diff
     * @return
     */
    public int interpretDiff(String diff){
        if(diff.equals("Advanced")){
            return 1;
        }
        else return 0;
    }

    /**
     *
     * @param aClick
     */
    public void handle(MouseEvent aClick) {
        numTurnClicks += 1;

        xClickLoc = aClick.getSceneX() - 100;
        yClickLoc = aClick.getSceneY() - 100;
        xClickLoc = xClickLoc * 5 / sceneSizeX;
        yClickLoc = yClickLoc * 5 / sceneSizeY;
        int xCoord = (int) Math.floor(xClickLoc);
        int yCoord = (int) Math.floor(yClickLoc);
        yCoord = Math.abs(yCoord - 4);

        // creates a coordinate object that sets the last click location
        setLastClick(xCoord, yCoord);
        Coord clickCoord = getLastClick();
        AIPlayer computer = new AIPlayer(interpretDiff(diff));

        // set the team turn maybe?

        // Logic to send the clicks to the right location
        if(name2.equals("Computer")) {
            if (numTurnClicks == 1) {
                setHighlightedPiece(clickCoord);
                setWhitePieceSelection(clickCoord);


                updateGui(gameDynamics, gameSet, board);


            } else if (numTurnClicks == 2) {
                // we can re-set turn clicks back to zero here
                setWhitePieceMove(clickCoord);

                unhighlightAll();


                // re-set the turn clicks and carry out the turn //
                // this is where we can actually carry out the simultaneous
                // movement in the game

                // increment the turn
                numTurn += 1;
                System.out.println("Turn number " + numTurn);

                // set the movement list that the game would use


                // this is just convenience to display in console, later
                // change to actual movement


                System.out.println("");
                // re-set the turn clicks to start a new turn
                numTurnClicks = 0;
                root.getChildren().clear();
                gameDynamics.moveWithAI(board, getWhitePieceSelection(), getWhitePieceMove(),
                        list, gameSet, computer);
                updateGui(gameDynamics, gameSet, board);
                if (gameDynamics.winCondition(gameSet, board) == "draw" || gameDynamics.winCondition(gameSet, board) == "black"
                        || gameDynamics.winCondition(gameSet, board) == "white") {
                    if(gameDynamics.winCondition(gameSet, board) == "white"){
                        file.Write(name1);
                        GUIendBanner banner = new GUIendBanner(name1, scene);
                        Stage a = new Stage();
                        try {
                            banner.start(a);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        scene.close();

                    }

                }
            }
        }
        else{
            if (numTurnClicks == 1) {
                setHighlightedPiece(clickCoord);
                setWhitePieceSelection(clickCoord);


                updateGui(gameDynamics, gameSet, board);


            } else if (numTurnClicks == 2) {
                // we can re-set turn clicks back to zero here
                setWhitePieceMove(clickCoord);

                unhighlightAll();
                updateGui(gameDynamics, gameSet, board);
            }
        else if (numTurnClicks == 3){
            setHighlightedPiece(clickCoord);
            setBlackPieceSelection(clickCoord);
            updateGui(gameDynamics, gameSet, board);


            }

            else {
            // note we leave this here because we might re-set the number
            // of turn clicks if the (future) move is not valid to 2
            setBlackPieceMove(clickCoord);

            }


            if (numTurnClicks == 4){

            // re-set the turn clicks and carry out the turn //
            // this is where we can actually carry out the simultaneous
            // movement in the game

            // increment the turn
            numTurn += 1;
            unhighlightAll();

            System.out.println("Turn number "+numTurn);

            // set the movement list that the game would use

            System.out.println("");
            // re-set the turn clicks to start a new turn
            numTurnClicks = 0;
            root.getChildren().clear();
            gameDynamics.moveWithUserInput(board, getWhitePieceSelection(), getWhitePieceMove(),
                        getBlackPieceSelection(), getBlackPieceMove(), list, gameSet);
            updateGui(gameDynamics, gameSet, board);
            if(gameDynamics.winCondition(gameSet, board) == "draw" || gameDynamics.winCondition(gameSet , board) == "black"
                    || gameDynamics.winCondition(gameSet , board) == "white"){
                if(gameDynamics.winCondition(gameSet , board) == "white"){
                    file.Write(name1);
                    GUIendBanner banner = new GUIendBanner(name1, scene);
                    Stage a = new Stage();
                    try {
                        banner.start(a);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(gameDynamics.winCondition(gameSet , board) == "black"){
                    file.Write(name2);
                    GUIendBanner banner = new GUIendBanner(name2, scene);
                    Stage a = new Stage();
                    try {
                        banner.start(a);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.exit(0);

            }
        }
        }
    }

    /**
     *
     * @return
     */
            public ArrayList<Piece> getList () {
                return list;
            }

    /**
     *
     * @param list
     */
            public void setList (ArrayList < Piece > list) {
                this.list = list;
            }

    /**
     *
     * @param root
     */
            public void setRoot (GridPane root){
                this.root = root;
            }

    /**
     *
     * @param whitePieceSelection
     */
            public void setWhitePieceSelection (Coord whitePieceSelection){
                WhitePieceSelection = whitePieceSelection;
            }

    /**
     *
     * @return
     */
            public Coord getWhitePieceSelection () {
                return WhitePieceSelection;
            }

    /**
     *
     * @param whitePieceMove
     */
            public void setWhitePieceMove (Coord whitePieceMove){
                WhitePieceMove = whitePieceMove;
            }

    /**
     *
     * @return
     */
            public Coord getWhitePieceMove () {
                return WhitePieceMove;
            }

    /**
     *
     * @param blackPieceSelection
     */
            public void setBlackPieceSelection (Coord blackPieceSelection){
                BlackPieceSelection = blackPieceSelection;
            }

    /**
     *
     * @return
     */
            public Coord getBlackPieceSelection () {
                return BlackPieceSelection;
            }

    /**
     *
     * @param blackPieceMove
     */
            public void setBlackPieceMove (Coord blackPieceMove){
                BlackPieceMove = blackPieceMove;
            }

    /**
     *
     * @return
     */
            public Coord getBlackPieceMove () {
                return BlackPieceMove;
            }

            // we don't want to have to worry about a constructor which will produce a
            // copy of the game for the given state, we are not concerned about
            // privacy leaks here. We're all consenting adults here.

    /**
     *
     * @param x
     * @param y
     */
            public void setLastClick ( int x, int y){
                lastClick = new Coord(x, y);
            }

    /**
     *
     * @return
     */
            public Coord getLastClick () {
                Coord copyCoord = new Coord(lastClick);
                return copyCoord;
            }

    /**
     *
     * @param size
     */
            public void setXSize ( int size){
                sceneSizeX = size;
            }

    /**
     *
     * @return
     */
            public int getXSize () {
                int copySize = sceneSizeX;
                return copySize;
            }

    /**
     *
     * @param size
     */
            public void setYSize ( int size){
                sceneSizeY = size;
            }

    /**
     *
     * @return
     */
            public int getYSize () {
                int copySize = sceneSizeY;
                return copySize;
            }

    /**
     *
     * @param gameDynamics
     * @param gameSet
     * @param board
     */

            public void updateGui (GameDynamicsGUI gameDynamics, GameSet gameSet, Board board){
                list = gameSet.getGamePieces();
                int count = 0;
                int rowNum = 5;
                int colNum = 5;
                for (int row = 0; row < rowNum; row++) {
                    for (int col = 0; col < colNum; col++) {
                        Rectangle rec = new Rectangle();
                        if (count == 0) {
                            rec.setWidth(60);
                            rec.setHeight(60);
                            rec.setFill(Color.DARKRED);
                            count++;

                        } else if (count == 1) {
                            rec.setWidth(60);
                            rec.setHeight(60);
                            rec.setFill(Color.GREY);
                            count = count - 1;

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
                Image imageWhitePawnHighlight = new Image("GUI/white_pawn_highlight.png");
                Image imageBlackPawnHighlight = new Image("GUI/black_pawn_highlight.png");
                Image imageWhiteKnightHighlight = new Image("GUI/white_Knight_highlight.png");
                Image imageBlackKnightHighlight = new Image("GUI/black_knight_highlight.png");

                for (int l = 0; l < 5; l++) {

                    for (int j = 0; j < 5; j++) {

                        for (Piece aPiece : list) {
                            Coord checkCoord = new Coord(l, j);
                            if (aPiece.getPosition().equals(checkCoord)) {
                                if (aPiece.getType() == "pawn") {
                                    if (aPiece.getColour() == "white") {
                                        if (aPiece.isHighlighted()) {
                                            root.add(new ImageView(imageWhitePawnHighlight), l, abs(4 - j));
                                        } else {
                                            root.add(new ImageView(imageWhitePawn), l, abs(4 - j));
                                        }
                                    } else{
                                        if (aPiece.isHighlighted()) {
                                            root.add(new ImageView(imageBlackPawnHighlight), l, abs(4 - j));
                                        }
                                        else root.add(new ImageView(imageBlackPawn), l, abs(4 - j));
                                    }
                                }
                                if (aPiece.getType() == "knight") {
                                    if (aPiece.getColour() == "white") {
                                        if (aPiece.isHighlighted()) {
                                            root.add(new ImageView(imageWhiteKnightHighlight), l, abs(4 - j));
                                        } else {
                                            root.add(new ImageView(imageWhiteKnight), l, abs(4 - j));
                                        }

                                    } else{
                                        if (aPiece.isHighlighted()) {
                                            root.add(new ImageView(imageBlackKnightHighlight), l, abs(4 - j));
                                        }
                                        else root.add(new ImageView(imageBlackKnight), l, abs(4 - j));
                                    }
                                }
                            }

                        }
                    }

                }
                setList(list);
            }

    /**
     *
     * @param pieceCoordinate
     */
    public void setHighlightedPiece (Coord pieceCoordinate){
                Piece selectedPieceWhite = gameSet.getPieceByCoord(pieceCoordinate);
                selectedPieceWhite.setHighlighted(true);
            }

            public void unhighlightAll ()
            {
                for (Piece aPiece : list) {
                    aPiece.setHighlighted(false);
                }
            }

            public static void setOnAction (Object ClickGame){
                // TODO Auto-generated method stub

            }


        }