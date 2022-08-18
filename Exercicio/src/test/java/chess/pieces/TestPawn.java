package chess.pieces;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPawn extends TestPiece{
    @Test
    public void testCreatePawn(){
        Piece pawnWhite = Piece.createWhitePawn();
        assertEquals('p', pawnWhite.getRepresentation());
        assertTrue(pawnWhite.isWhite());
        assertFalse(pawnWhite.isBlack());
        assertEquals(1.0,pawnWhite.getPower(), 0.05);
        assertEquals(Pawn.class,pawnWhite.getClass());

        Piece pawnBlack = Piece.createBlackPawn();
        assertEquals('P', pawnBlack.getRepresentation());
        assertTrue(pawnBlack.isBlack());
        assertFalse(pawnBlack.isWhite());
        assertEquals(1.0,pawnBlack.getPower(), 0.05);
        assertEquals(Pawn.class,pawnBlack.getClass());
    }

}
