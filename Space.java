public class Space {
    private Coord coordinate;
    private Piece piece;


    public Space(Coord coordinate){
        this.coordinate = coordinate;
    }

    public Space(Coord coordinate, Piece piece){
        this.coordinate = coordinate;
        this.piece = piece;
    }

    public Coord getCoord() {
        return coordinate;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void removePiece(){
        this.piece = null;
    }

    public String getDisplay(){
        if (piece != null){
            return piece.toString();
        }
        else return " ";

    }

    public boolean isSpaceValid(){
        if (this.getCoord().Valid()) {
            return true;
        }
        else return false;
    }

    public boolean emptySpace(){
        if (piece != null){
            return false;
        }
        else return true;
    }

    public String getPieceToString() {
        if (piece == null) {
            return "--";
        }
        return piece.toString();
    }


}
