package chess.pieces;

import org.junit.Test;

import java.util.ArrayList;

//import static chess.pieces.King.assertContains;
//import static chess.pieces.King.assertContains;
import static org.junit.Assert.*;

public class TestKing extends TestPiece {
    @Test
    public void testKing(){
        King kingWhite = Piece.createWhiteKing();
        assertEquals('k', kingWhite.getRepresentation());
        assertTrue(kingWhite.isWhite());
        assertFalse(kingWhite.isBlack());
        assertEquals(0.0,kingWhite.getPower(), 0.05);
        assertEquals(King.class,kingWhite.getClass());

        King kingBlack = Piece.createBlackKing();
        assertEquals('K', kingBlack.getRepresentation());
        assertTrue(kingBlack.isBlack());
        assertFalse(kingBlack.isWhite());
        assertEquals(0.0,kingBlack.getPower(), 0.05);
        assertEquals(King.class,kingBlack.getClass());
    }
    @Test
    public void testKingMoves(){
        King king = Piece.createBlackKing();
        assertContains(king.possibleMoves("a1"), "a2", "b2", "b1" );
        assertContains(king.possibleMoves("b5"), "a5", "b6", "b4", "c5", "a4", "a6", "c6", "c4");
        System.out.println(king.possibleMoves("b5"));
    }

}

