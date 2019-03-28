
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.lang.Math;
import java.util.ArrayList;
import javafx.scene.SubScene;

public class ApocalypseClick implements EventHandler<MouseEvent> {
        
    private int sceneSizeX, sceneSizeY;
    private double xClickLoc, yClickLoc;
    private int numTurnClicks = 0;
    private int numTurn = 0;
    private Coord lastClick;
    private PsuedoApocalypse myGame;
    private ArrayList<Coord> turnCoords;


    public ApocalypseClick(int dimX, int dimY){
        setXSize(dimX);
        setYSize(dimY);
        setMyGame();
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
            myGame.setWhitePieceSelection(clickCoord);
        }
        else if (numTurnClicks == 2){
            // we can re-set turn clicks back to zero here
            myGame.setWhitePieceMove(clickCoord);
        }
        else if (numTurnClicks == 3){
            myGame.setBlackPieceSelection(clickCoord);
        }
        else {
            // note we leave this here because we might re-set the number
            // of turn clicks if the (future) move is not valid to 2
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
        }        

    }


    public void setMyGame(){
        myGame = new PsuedoApocalypse();
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

    }