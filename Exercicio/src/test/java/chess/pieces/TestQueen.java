package chess.pieces;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestQueen {

    @Test
    public void testCreateQueen(){
        Queen queenWhite = Queen.createWhiteQueen();
        assertEquals('q', queenWhite.getRepresentation());
        assertTrue(queenWhite.isWhite());
        assertFalse(queenWhite.isBlack());
        assertEquals(9.0,queenWhite.getPower(), 0.05);
        assertEquals(Piece.Name.QUEEN,queenWhite.getType());

        Queen queenBlack = Queen.createBlackQueen();
        assertEquals('Q', queenBlack.getRepresentation());
        assertTrue(queenBlack.isBlack());
        assertFalse(queenBlack.isWhite());
        assertEquals(9.0,queenBlack.getPower(), 0.05);
        assertEquals(Piece.Name.QUEEN,queenBlack.getType());
    }
    @Test
    public void testQueenMove(){
        ArrayList<String> valueQueen = new ArrayList<>();
        Queen queen = Piece.createWhiteQueen();
        valueQueen = queen.possibleMoves("e4");
        System.out.println(queen.possibleMoves("e4"));
        assertTrue(valueQueen.contains("e5"));
        assertTrue(valueQueen.contains("e6"));
        assertTrue(valueQueen.contains("e7"));
        assertTrue(valueQueen.contains("e8"));
//      ----------------------------------
        assertTrue(valueQueen.contains("f5"));
        assertTrue(valueQueen.contains("g6"));
        assertTrue(valueQueen.contains("h7"));
//      ----------------------------------
        assertTrue(valueQueen.contains("f4"));
        assertTrue(valueQueen.contains("g4"));
        assertTrue(valueQueen.contains("h4"));
//      ----------------------------------
        assertTrue(valueQueen.contains("f3"));
        assertTrue(valueQueen.contains("g2"));
        assertTrue(valueQueen.contains("h1"));
//      ----------------------------------
        assertTrue(valueQueen.contains("e3"));
        assertTrue(valueQueen.contains("e2"));
        assertTrue(valueQueen.contains("e1"));
//      ----------------------------------
        assertTrue(valueQueen.contains("d4"));
        assertTrue(valueQueen.contains("c4"));
        assertTrue(valueQueen.contains("b4"));
        assertTrue(valueQueen.contains("a4"));
//      ----------------------------------
        assertTrue(valueQueen.contains("d5"));
        assertTrue(valueQueen.contains("c6"));
        assertTrue(valueQueen.contains("b7"));
        assertTrue(valueQueen.contains("a8"));
        assertEquals(27, valueQueen.size());

    }

}
