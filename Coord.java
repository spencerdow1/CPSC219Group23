import java.util.ArrayList;

public class Coord {

    public int x;
    public int y;
    public int[] coord = new int[2];

    public void setXCoord(int someVal){
        coord[0] = someVal;
    }

    public int getXCoord(){
        int copyX = coord[0];
        return copyX;
    }

    public void setYCoord(int someVal){
        coord[1] = someVal;
    }

    public int getYCoord(){
        int copyY = coord[1];
        return copyY;
    }

    public int[] getCoords(){
    	int[] copyCoord = coord;
    	return copyCoord;
    }

    public void setCoords(int anyX, int anyY){
        setXCoord(anyX);
        setYCoord(anyY);
    }

    public String toString(){
    	String string1; String string2; String printString;
    	string1 = "("+Integer.toString(getXCoord())+", ";
    	string2 = Integer.toString(getYCoord())+")";
    	printString = string1 + string2;
    	return printString;
    }

    /** Defaults to zero!!!
    **/
	public Coord(){
		setCoords(0,0);
		this.x = getXCoord();
        this.y = getYCoord();
        this.coord = getCoords();
        }

    /** Initialize a coordinate tuple given x and y values.
    **/
	public Coord(int someX, int someY){
        setCoords(someX, someY);
        this.coord = getCoords();
        this.x = getXCoord();
        this.y = getYCoord();
	}
}

