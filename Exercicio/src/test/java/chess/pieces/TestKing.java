package chess.pieces;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestKing extends TestPiece {
    @Test
    public void testKing(){
            King kingWhite = Piece.createWhiteKing();
            assertEquals('k', kingWhite.getRepresentation());
            assertTrue(kingWhite.isWhite());
            assertFalse(kingWhite.isBlack());
            assertEquals(1.0,kingWhite.getPower(), 0.05);
            assertEquals(Piece.Name.KING,kingWhite.getType());

            King kingBlack = Piece.createBlackKing();
            assertEquals('K', kingBlack.getRepresentation());
            assertTrue(kingBlack.isBlack());
            assertFalse(kingBlack.isWhite());
            assertEquals(1.0,kingBlack.getPower(), 0.05);
            assertEquals(Piece.Name.KING,kingBlack.getType());
        }

    }

