package chess.pieces;

public class Bishop extends Piece {
    public Bishop(Piece bishop) {
        super(Colors.NO_COLOR, Name.BISHOP, bishop.getRepresentation());
    }
}
