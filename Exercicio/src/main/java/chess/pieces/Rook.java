package chess.pieces;

public class Rook extends Piece{
    public Rook(Piece rook) {
        super(Colors.NO_COLOR, Name.ROOK, rook.getRepresentation());
    }
}
