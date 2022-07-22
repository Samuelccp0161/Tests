package chess.pieces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRook {
    @Test
    public void testRook(){
        Rook rookBlack = new Rook(Piece.createBlackRook());
        assertEquals('R', rookBlack.getRepresentation());
        Rook rookWhite = new Rook(Piece.createWhiteRook());
        assertEquals('r', rookWhite.getRepresentation());
    }
}
