package sample;

public enum PieceType {
    Knight("k"), Pawn("p");

    private String value;

    PieceType(String value) {
        this.value = value;

    }

    @Override
    public String toString() {
        return this.value;
    }


}

