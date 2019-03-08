
public abstract class Piece {
    private PieceType pieceType;
    private PlayerTeam player;

    public Piece(PieceType pieceType, PlayerTeam player) {
        this.pieceType = pieceType;
        this.player = player;
    }

    public String toString() {
        return player.toString() + pieceType.toString();
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public PlayerTeam getPlayerTeam() {
        return player;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public abstract boolean validateMove(Coord currentPosition, Coord desiredPosition, Board board);
}

