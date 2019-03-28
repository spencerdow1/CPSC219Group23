/**
 * This is a convenience class for dealing with two tuples of integers for use
 * in the Apocalypse board. There are no restrictions on allowed x and y values.
 * Simple add function will accept negative values for a subtraction
 **/
public class Coord {

	/**
	 * While the coord variable is held private, x and y are set to public for
	 * syntactic convenience elsewhere in Apocalpyse
	 **/
	public int x;
	public int y;
	private int[] coord = new int[2];


	/**
	 * Constructor that defaults to zero.
	 **/
	public Coord() {
		setCoords(0, 0);
	}

	/**
	 * Constructor to initialize a coordinate tuple given x and y values.
	 **/
	public Coord(int someX, int someY) {
		setCoords(someX, someY);
	}

	/**
	 * Constructor which takes a coordinate as a parameter
	**/
	public Coord(Coord aCoord) {
		setCoords(aCoord.getXCoord(), aCoord.getYCoord());
	}
	/**
	 * Simple add function. Will accept negative values for a subtraction
	 * 
	 * @param <addX>: integer to add for the x value
	 * @param <addY>: integer to add for the y value
	 **/


	public void add(int addX, int addY) {
		setXCoord(getXCoord() + addX);
		setYCoord(getYCoord() + addY);
	}

	/**
	 * Simple add function. Will accept negative values for a subtraction
	 * 
	 * @param <someCoord>: Argument is given in coordinates for syntactic
	 *        convenience
	 **/
	public void add(Coord someCoord) {
		int addX = someCoord.getXCoord();
		int addY = someCoord.getYCoord();
		setXCoord(getXCoord() + addX);
		setYCoord(getYCoord() + addY);
	}

	/**
	 * Simple setter for the x coordinate
	 * 
	 * @param <someVal>: the given x (no restrictions)
	 **/
	private void setXCoord(int someVal) {
		coord[0] = someVal;
		x = someVal;
	}

	/**
	 * Simple getter for the x coordinate
	 * 
	 * @return <copyX>: a copy of the coordinate for encapsulation purposes
	 **/
	public int getXCoord() {
		int copyX = coord[0];
		return copyX;
	}

	/**
	 * Simple setter for the y coordinate
	 * 
	 * @param <someVal>: the given y (no restrictions)
	 **/
	private void setYCoord(int someVal) {
		coord[1] = someVal;
		y = someVal;
	}

	/**
	 * Simple getter for the y coordinate
	 * 
	 * @return <copyY>: a copy of the coordinate for encapsulation purposes
	 **/
	public int getYCoord() {
		int copyY = coord[1];
		return copyY;
	}

	/**
	 * Simple getter for both x and y coordinates
	 * 
	 * @return <copyCoord>: a copy of the coordinate for encapsulation purposes
	 **/
	public int[] getCoords() {
		int[] copyCoord = coord;
		return copyCoord;
	}

	/**
	 * Simple setter for both x and y coordinates
	 * 
	 * @see setXCoord()
	 * @see setYCoord()
	 **/
	public void setCoords(int anyX, int anyY) {
		setXCoord(anyX);
		setYCoord(anyY);
	}

	/**
	 * Custom toString() method
	 * @return <printString>: nicely formatted 2-tuple in (x, y)
	 **/
	@Override
	public String toString() {
		String string1;
		String string2;
		String printString;
		string1 = "(" + Integer.toString(getXCoord()) + ", ";
		string2 = Integer.toString(getYCoord()) + ")";
		printString = string1 + string2;
		return printString;
	}


	public boolean equals(Coord aCoord){
		boolean isTrue = false;
        int currentX = getXCoord();
        int currentY = getYCoord();
        int compareX = aCoord.getXCoord();
        int compareY = aCoord.getYCoord();
        if (currentX == compareX){
        	if (currentY == compareY){
        		isTrue = true;
        	}
        }
		return isTrue;
	}



}
