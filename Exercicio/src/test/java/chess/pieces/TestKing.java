package chess.pieces;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestKing extends TestPiece {
    @Test
    public void testKing(){
        King kingWhite = King.createWhiteKing();
        assertEquals('k', kingWhite.getRepresentation());
        assertTrue(kingWhite.isWhite());
        assertFalse(kingWhite.isBlack());
        assertEquals(0.0,kingWhite.getPower(), 0.00);
        assertEquals(King.class,kingWhite.getClass());

        King kingBlack = King.createBlackKing();
        assertEquals('K', kingBlack.getRepresentation());
        assertTrue(kingBlack.isBlack());
        assertFalse(kingBlack.isWhite());
        assertEquals(0.0,kingBlack.getPower(), 0.00);
        assertEquals(King.class,kingBlack.getClass());
    }
    @Test
    public void testKingMove(){
        King king = King.createBlackKing();
        System.out.println(king.possibleMoves("a1"));
        assertContains(king.possibleMoves("a1"), "b1", "a2", "b2");
    }
}
