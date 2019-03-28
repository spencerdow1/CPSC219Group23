package GUI;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.lang.Math;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class ApocalypseClick implements EventHandler<MouseEvent> {
        
    private int sceneSizeX, sceneSizeY;
    private double xClickLoc, yClickLoc;
    private int numTurnClicks = 0;
    private int numTurn = 0;
    private Coord lastClick;
    private PsuedoApocalypse myGame;
    private ArrayList<Coord> turnCoords;
    private GridPane root;
    private Coord WhitePieceSelection;
    private Coord WhitePieceMove;
    private Coord BlackPieceSelection;
    private Coord BlackPieceMove;
    GameDynamics gameDynamics = new GameDynamics();
    GameSet gameSet = new DefaultGameSet();
    Board board = new Board(gameSet);
    ArrayList<Piece> list = gameSet.getGamePieces();


    public ApocalypseClick(int dimX, int dimY, GridPane root){
        setXSize(dimX);
        setYSize(dimY);
        setMyGame();
        setRoot(root);

    }


    public void handle(MouseEvent aClick){
        numTurnClicks += 1;

        xClickLoc = aClick.getSceneX()-100;
        yClickLoc = aClick.getSceneY()-100;
        xClickLoc = xClickLoc*5/sceneSizeX;
        yClickLoc = yClickLoc*5/sceneSizeY;
        int xCoord = (int) Math.floor(xClickLoc);
        int yCoord = (int) Math.floor(yClickLoc);
        yCoord = Math.abs(yCoord - 4);

        // creates a coordinate object that sets the last click location
        setLastClick(xCoord, yCoord);
        Coord clickCoord = getLastClick();

        // set the team turn maybe?

        // Logic to send the clicks to the right location
        if (numTurnClicks == 1){
            setWhitePieceSelection(clickCoord);
            myGame.setWhitePieceSelection(clickCoord);
        }
        else if (numTurnClicks == 2){
            // we can re-set turn clicks back to zero here
            setWhitePieceMove(clickCoord);
            myGame.setWhitePieceMove(clickCoord);
        }
        else if (numTurnClicks == 3){
            setBlackPieceSelection(clickCoord);
            myGame.setBlackPieceSelection(clickCoord);
        }
        else {
            // note we leave this here because we might re-set the number
            // of turn clicks if the (future) move is not valid to 2
            setBlackPieceMove(clickCoord);
            myGame.setBlackPieceMove(clickCoord);
        }

        if (numTurnClicks == 4){

            // re-set the turn clicks and carry out the turn //
            // this is where we can actually carry out the simultaneous
            // movement in the game
            
            // increment the turn
            numTurn += 1;
            System.out.println("Turn number "+numTurn);

            // set the movement list that the game would use
            myGame.setAllMoves();

            // this is just convenience to display in console, later
            // change to actual movement
            for (Coord aMove : myGame.getAllMoves()){
                System.out.println(aMove.toString());
            }
            
            System.out.println("");
            // re-set the turn clicks to start a new turn
            numTurnClicks = 0;
                root.getChildren().clear();
                updateGui(gameDynamics, gameSet, board);
            if(gameDynamics.winCondition(gameSet, board) == "draw" || gameDynamics.winCondition(gameSet , board) == "black"
                    || gameDynamics.winCondition(gameSet , board) == "white"){
                System.out.print(gameDynamics.winCondition(gameSet, board));
                System.exit(0);

            }
        }

    }

    public ArrayList<Piece> getList() {
        return list;
    }

    public void setList(ArrayList<Piece> list) {
        this.list = list;
    }

    public void setRoot(GridPane root){
        this.root = root;
    }


    public void setMyGame(){
        myGame = new PsuedoApocalypse();
    }

    public void setWhitePieceSelection(Coord whitePieceSelection) {
        WhitePieceSelection = whitePieceSelection;
    }

    public Coord getWhitePieceSelection() {
        return WhitePieceSelection;
    }

    public void setWhitePieceMove(Coord whitePieceMove) {
        WhitePieceMove = whitePieceMove;
    }

    public Coord getWhitePieceMove() {
        return WhitePieceMove;
    }

    public void setBlackPieceSelection(Coord blackPieceSelection) {
        BlackPieceSelection = blackPieceSelection;
    }

    public Coord getBlackPieceSelection() {
        return BlackPieceSelection;
    }

    public void setBlackPieceMove(Coord blackPieceMove) {
        BlackPieceMove = blackPieceMove;
    }

    public Coord getBlackPieceMove() {
        return BlackPieceMove;
    }

    // we don't want to have to worry about a constructor which will produce a
    // copy of the game for the given state, we are not concerned about
    // privacy leaks here. We're all consenting adults here.
    public PsuedoApocalypse getMyGame(){
        return myGame;
    }

    public void setLastClick(int x, int y){
        lastClick = new Coord(x, y);
    }


    public Coord getLastClick(){
        Coord copyCoord = new Coord(lastClick);
        return copyCoord;
    }


    public void setXSize(int size){
        sceneSizeX = size;        
    }


    public int getXSize(){
        int copySize = sceneSizeX;
        return copySize;
    }


    public void setYSize(int size){
        sceneSizeY = size;
    }


    public int getYSize(){
        int copySize = sceneSizeY;
        return copySize;
    }


    public void updateGui(GameDynamics gameDynamics, GameSet gameSet, Board board){
            gameDynamics.moveWithUserInput(board, getWhitePieceSelection(), getWhitePieceMove(),
                    getBlackPieceSelection(), getBlackPieceMove(), list, gameSet);
            list = gameSet.getGamePieces();

        int count = 0;
        int rowNum = 5;
        int colNum = 5;
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
         setList(list);
     }

    }