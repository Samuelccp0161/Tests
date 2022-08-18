package chess.pieces;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestQueen {

    @Test
    public void testCreateQueen(){
        Queen queenWhite = Piece.createWhiteQueene();
        assertEquals('q', queenWhite.getRepresentation());
        assertTrue(queenWhite.isWhite());
        assertFalse(queenWhite.isBlack());
        assertEquals(9.0,queenWhite.getPower(), 0.05);
        assertEquals(Queen.class,queenWhite.getClass());

        Queen queenBlack = Piece.createBlackQueene();
        assertEquals('Q', queenBlack.getRepresentation());
        assertTrue(queenBlack.isBlack());
        assertFalse(queenBlack.isWhite());
        assertEquals(9.0,queenBlack.getPower(), 0.05);
        assertEquals(Queen.class,queenBlack.getClass());
    }
}
