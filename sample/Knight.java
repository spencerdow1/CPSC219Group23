package sample;

public class Knight extends Piece {

    public Knight(PlayerTeam player){
        super(PieceType.Knight, player);
    }

    @Override
    public PieceType getPieceType() {
        return super.getPieceType();
    }

    @Override
    public boolean validateMove(Coord currentPosition, Coord desiredPosition, Board board) {
        Boolean isValid = false;
        int differenceInX = Math.abs(currentPosition.getXCoord() - desiredPosition.getXCoord());
        int differenceInY = Math.abs(currentPosition.getYCoord() - desiredPosition.getYCoord());

        if(currentPosition == desiredPosition){
            isValid = false;
        }
        if(differenceInX + differenceInY == 3 && differenceInX != 0 && differenceInY != 0){
            isValid = true;
        }
        return isValid;

    }


}

