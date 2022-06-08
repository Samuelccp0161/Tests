package chess.pieces;

import org.junit.Test;

import static org.junit.Assert.*;

public class testPiece {
    @Test

    public void testCreate() {
        Piece whitePawn = Piece.createWhitePawn();
        assertEquals('p', whitePawn.getRepresentation());
        assertTrue(whitePawn.isWhite());
        assertFalse(whitePawn.isBlack());

        Piece blackPawn = Piece.createBlackPawn();
        assertEquals('P', blackPawn.getRepresentation());
        assertTrue(blackPawn.isBlack());
        assertFalse(blackPawn.isWhite());

        Piece whiteKnight = Piece.createWhiteKnight();
        assertEquals('n', whiteKnight.getRepresentation());
        assertTrue(whiteKnight.isWhite());
        assertFalse(whiteKnight.isBlack());

        Piece blackKnight = Piece.createBlackKnight();
        assertEquals('N', blackKnight.getRepresentation());
        assertTrue(blackKnight.isBlack());
        assertFalse(blackKnight.isWhite());

        Piece whiteRook = Piece.createWhiteRook();
        assertEquals('r', whiteRook.getRepresentation());
        assertTrue(whiteRook.isWhite());
        assertFalse(whiteRook.isBlack());

        Piece blackRook = Piece.createBlackRook();
        assertEquals('R', blackRook.getRepresentation());
        assertTrue(blackRook.isBlack());
        assertFalse(blackRook.isWhite());

        Piece whiteBishop = Piece.createWhiteBishop();
        assertEquals('b', whiteBishop.getRepresentation());
        assertTrue(whiteBishop.isWhite());
        assertFalse(whiteBishop.isBlack());

        Piece blackBishop = Piece.createBlackBishop();
        assertEquals('B', blackBishop.getRepresentation());
        assertTrue(blackBishop.isBlack());
        assertFalse(blackBishop.isWhite());

        Piece whiteQueen = Piece.createWhiteQueen();
        assertEquals('q', whiteQueen.getRepresentation());
        assertTrue(whiteQueen.isWhite());
        assertFalse(whiteQueen.isBlack());

        Piece blackQueen = Piece.createBlackQueen();
        assertEquals('Q', blackQueen.getRepresentation());
        assertTrue(blackQueen.isBlack());
        assertFalse(blackQueen.isWhite());

        Piece whiteKing = Piece.createWhiteKing();
        assertEquals('k', whiteKing.getRepresentation());
        assertTrue(whiteKing.isWhite());
        assertFalse(whiteKing.isBlack());

        Piece blackKing = Piece.createBlackKing();
        assertEquals('K', blackKing.getRepresentation());
        assertTrue(blackKing.isBlack());
        assertFalse(blackKing.isWhite());

//
//        Piece pawnInColor = new Piece(Piece.INCOLOR, '.');
//        assertEquals(piece.INCOLOR, pawnInColor.getColor());
//        assertEquals('.',pawnInColor.getRepresentation());
//        System.out.println(pawnInColor.getRepresentation());
    }
}
