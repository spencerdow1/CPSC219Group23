package sample;

import static java.lang.Math.abs;

public class Pawn extends Piece {

    public Pawn(PlayerTeam player) {
        super(PieceType.Pawn, player);
    }

    @Override
    public PieceType getPieceType() {
        return super.getPieceType();
    }

    @Override
    public boolean validateMove(Coord currentPosition, Coord desiredPosition, Board board) {
        boolean isValid = false;
        Space[][] checkSpaces = board.getSpace();
        int currentX = currentPosition.getXCoord();
        int currentY = currentPosition.getYCoord();
        int desiredX = desiredPosition.getXCoord();
        int desiredY = desiredPosition.getYCoord();

        //Movement possibilities for white pawns
        if (this.getPieceType() == null){
            isValid = false;
        }
        //used for normal pawn movement
        else if (this.getPieceType() != null) {
            if (this.getPlayerTeam() == PlayerTeam.White) {
                if(checkSpaces[desiredX][desiredY].filledSpace()){
                    if (abs(currentPosition.getYCoord() - desiredPosition.getYCoord()) == 1
                            && abs(currentPosition.getXCoord() - desiredPosition.getXCoord()) == 0 )
                    {

                        if (currentPosition.getYCoord() < desiredPosition.getYCoord()) {
                            isValid = true;
                        }
                    }
                    }
                    //used if pawns can capture
                    if (!checkSpaces[desiredX][desiredY].filledSpace()) {

                        if (abs(currentPosition.getYCoord() - desiredPosition.getYCoord()) == 1
                            && abs(currentPosition.getXCoord() - desiredPosition.getXCoord()) == 1 ){

                            isValid = true;

                        }

                    }

            }
            //Movement possibilities for black pawn
            else if (this.getPlayerTeam() == PlayerTeam.Black) {
                if (checkSpaces[desiredX][desiredY].filledSpace()) {
                    if (abs(currentPosition.getYCoord() - desiredPosition.getYCoord()) == 1
                            && abs(currentPosition.getXCoord() - desiredPosition.getXCoord()) == 0) {
                        if (currentPosition.getYCoord() > desiredPosition.getYCoord()) {
                            isValid = true;
                        }
                    }
                }
                else if (!checkSpaces[desiredX][desiredY].filledSpace()) {
                    if (abs(currentPosition.getYCoord() - desiredPosition.getYCoord()) == 1
                            && abs(currentPosition.getXCoord() - desiredPosition.getXCoord()) == 1 )
                    {
                        isValid = true;
                    }
                }
            }
        }
        return isValid;
    }
}



