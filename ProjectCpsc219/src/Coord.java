public class Coord {
    int x;
    int y;

    public Coord(int enteredX, int enteredY) {
        x = enteredX;
        y = enteredY;

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
