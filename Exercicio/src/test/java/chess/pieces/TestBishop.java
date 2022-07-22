package chess.pieces;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestBishop {
    @Test
    public void testBishop(){
            Bishop bishopWhite = Piece.createWhiteBishop();
            assertEquals('b', bishopWhite.getRepresentation());
            assertTrue(bishopWhite.isWhite());
            assertFalse(bishopWhite.isBlack());
            assertEquals(3.0,bishopWhite.getPower(), 0.05);
            assertEquals(Piece.Name.BISHOP,bishopWhite.getType());

            Bishop bishopBlack = Piece.createBlackBishop();
            assertEquals('B', bishopBlack.getRepresentation());
            assertTrue(bishopBlack.isBlack());
            assertFalse(bishopBlack.isWhite());
            assertEquals(3.0,bishopBlack.getPower(), 0.05);
            assertEquals(Piece.Name.BISHOP,bishopBlack.getType());
        }
}

