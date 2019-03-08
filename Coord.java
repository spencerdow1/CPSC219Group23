public class Coord {
    int x;
    int y;

    public Coord(int enteredX, int enteredY) {
        x = enteredX;
        y = enteredY;

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
