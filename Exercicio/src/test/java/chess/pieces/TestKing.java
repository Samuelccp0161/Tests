package chess.pieces;

import org.junit.Test;

import java.util.ArrayList;

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
        ArrayList<String> value = new ArrayList<>();
        King king = Piece.createBlackKing();
        value = king.possibleMoves("d4");
        System.out.println(value);
        assertTrue(value.contains("c3"));
        assertTrue(value.contains("c4"));
        assertTrue(value.contains("c5"));
//      ----------------------------------
        assertTrue(value.contains("d3"));
        assertTrue(value.contains("d5"));
//      ----------------------------------
        assertTrue(value.contains("e5"));
        assertTrue(value.contains("e4"));
        assertTrue(value.contains("e3"));
        assertEquals(8,value.size() );
//      ----------------------------------
        value = king.possibleMoves("a1");
        assertTrue(value.contains("a2"));
        assertTrue(value.contains("b1"));
        assertTrue(value.contains("b2"));
        System.out.println(value);
        assertEquals(3, value.size());
//      ----------------------------------
        value = king.possibleMoves("a8");
        assertTrue(value.contains("a7"));
        assertTrue(value.contains("b7"));
        assertTrue(value.contains("b8"));
        System.out.println(value);
        assertEquals(3, value.size());
    }

}

