package sample;

public class Coord {

    int x;

    int y;



    public Coord(){

        x = 0;

        y = 0;

    }



    public Coord(int enteredX, int enteredY) {

        x = enteredX;

        y = enteredY;

    }



    /** Copy Constructor **/

    public Coord(Coord aCoord){

        x = aCoord.getXCoord();

        y = aCoord.getYCoord();

    }



    /** sets coordinates **/

    public void setCoord(int anX, int aY){

        x = anX;

        y = aY;

    }



    /** sets whole coordinate at a time **/

    public void setCoord(Coord aCoord){

        x = aCoord.getXCoord();

        y = aCoord.getYCoord();

    }



    public boolean Valid() {

        if ((x >= 0 && x < 5)

                && (y >= 0 && y < 5)) {

            return true;

        }

        return false;

    }



    public int getXCoord() {

        return x;

    }



    public int getYCoord() {

        return y;

    }



    public void setXCoord(int x) {

        this.x = x;

    }



    public void setYCoord(int y) {

        this.y = y;

    }



    @Override

    public String toString() {

        return this.getXCoord() + "," + this.getYCoord();

    }

}