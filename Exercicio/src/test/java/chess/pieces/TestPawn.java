package chess.pieces;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestPawn extends TestPiece{
    @Test
    public void testCreatePawn(){
        Pawn pawnWhite = Piece.createWhitePawn();
        assertEquals('p', pawnWhite.getRepresentation());
        assertTrue(pawnWhite.isWhite());
        assertFalse(pawnWhite.isBlack());
        assertEquals(1.0,pawnWhite.getPower(), 0.05);
        assertEquals(Piece.Name.PAWN,pawnWhite.getType());

        Pawn pawnBlack = Piece.createBlackPawn();
        assertEquals('P', pawnBlack.getRepresentation());
        assertTrue(pawnBlack.isBlack());
        assertFalse(pawnBlack.isWhite());
        assertEquals(1.0,pawnBlack.getPower(), 0.05);
        assertEquals(Piece.Name.PAWN,pawnBlack.getType());
    }

}
