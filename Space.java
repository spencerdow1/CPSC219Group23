public class Space {
    private Coord coordinate;
    private Piece piece;


    public Space(Coord coordinate){
        this.coordinate = coordinate;
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


    public boolean filledSpace(){
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
