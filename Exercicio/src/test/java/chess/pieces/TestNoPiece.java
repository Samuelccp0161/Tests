package chess.pieces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestNoPiece {
    @Test
    public void noPieceTest(){

        Piece blank = Piece.noColor();
        assertEquals('.', blank.getRepresentation());
        assertEquals(NoPiece.class, blank.getClass());
    }
}
