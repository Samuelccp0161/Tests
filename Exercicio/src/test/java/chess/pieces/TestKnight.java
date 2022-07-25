package chess.pieces;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestKnight extends TestPiece{
    @Test
    public void testCreateKnight(){
        Knight knightWhite = Piece.createWhiteKnight();
        assertEquals('n', knightWhite.getRepresentation());
        assertTrue(knightWhite.isWhite());
        assertFalse(knightWhite.isBlack());
        assertEquals(2.5,knightWhite.getPower(), 0.05);
        assertEquals(Knight.class,knightWhite.getClass());

        Knight knightBlack = Piece.createBlackKnight();
        assertEquals('N', knightBlack.getRepresentation());
        assertTrue(knightBlack.isBlack());
        assertFalse(knightBlack.isWhite());
        assertEquals(2.5,knightBlack.getPower(), 0.05);
        assertEquals(Knight.class,knightBlack.getClass());
    }

}
