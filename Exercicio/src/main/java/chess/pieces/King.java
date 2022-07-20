package chess.pieces;

public class King extends Piece{
    protected King(Colors color) {
        super(color, Piece.Name.KING, KING_REPRESENTATION);
    }
}
