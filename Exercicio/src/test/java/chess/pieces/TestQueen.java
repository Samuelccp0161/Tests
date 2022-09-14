package chess.pieces;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestQueen extends TestPiece {

    @Test
    public void testCreateQueen(){
        Queen queenWhite = Piece.createWhiteQueen();
        assertEquals('q', queenWhite.getRepresentation());
        assertTrue(queenWhite.isWhite());
        assertFalse(queenWhite.isBlack());
        assertEquals(9.0,queenWhite.getPower(), 0.05);
        assertEquals(Queen.class,queenWhite.getClass());

        Queen queenBlack = Piece.createBlackQueen();
        assertEquals('Q', queenBlack.getRepresentation());
        assertTrue(queenBlack.isBlack());
        assertFalse(queenBlack.isWhite());
        assertEquals(9.0,queenBlack.getPower(), 0.05);
        assertEquals(Queen.class,queenBlack.getClass());
    }
    @Test
    public void testQueenMoves(){
        Queen queen = Queen.createBlackQueen();
        System.out.println(queen.possibleMoves("a1"));
        assertContains(queen.possibleMoves("a1"), "a2","a3", "a4", "a5","a6","a7","a8","b2","c3","d4","e5","f6","g7","h8","b1","c1","d1","e1","f1","g1","h1");
    }
}
