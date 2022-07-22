package chess.pieces;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestRook {
    @Test
    public void testRook(){
            Rook RookWhite = Piece.createWhiteRook();
            assertEquals('r', RookWhite.getRepresentation());
            assertTrue(RookWhite.isWhite());
            assertFalse(RookWhite.isBlack());
            assertEquals(5.0,RookWhite.getPower(), 0.05);
            assertEquals(Piece.Name.ROOK,RookWhite.getType());

            Rook rookBlack = Piece.createBlackRook();
            assertEquals('R', rookBlack.getRepresentation());
            assertTrue(rookBlack.isBlack());
            assertFalse(rookBlack.isWhite());
            assertEquals(5.0,rookBlack.getPower(), 0.05);
            assertEquals(Piece.Name.ROOK,rookBlack.getType());
        }

    }
