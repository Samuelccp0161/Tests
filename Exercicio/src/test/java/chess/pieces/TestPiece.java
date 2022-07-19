package chess.pieces;

import chess.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class TestPiece {

    @Test
    public void testCreate() {

        verifyCreation(
                Piece.createWhitePawn(), Piece.createBlackPawn(),
                Piece.Name.PAWN, Piece.PAWN_REPRESENTATION);

        verifyCreation(
                Piece.createWhiteRook(), Piece.createBlackRook(),
                Piece.Name.ROOK, Piece.ROOK_REPRESENTATION);

        verifyCreation(
                Piece.createWhiteKnight(), Piece.createBlackKnight(),
                Piece.Name.KNIGHT, Piece.KNIGHT_REPRESENTATION);

        verifyCreation(
                Piece.createWhiteBishop(), Piece.createBlackBishop(),
                Piece.Name.BISHOP, Piece.BISHOP_REPRESENTATION);

        verifyCreation(Piece.createWhiteQueen(), Piece.createBlackQueen(),
                Piece.Name.QUEEN, Piece.QUEEN_REPRESENTATION);

        verifyCreation(Piece.createWhiteKing(), Piece.createBlackKing(),
                Piece.Name.KING, Piece.KING_REPRESENTATION);

        Piece blank = Piece.noColor();
        assertEquals('.', blank.getRepresentation());
        assertEquals(Piece.Name.NO_POINTS, blank.getType());
    }

    private void verifyCreation(Piece whitePiece, Piece blackPiece,
                                Piece.Name type, char representation) {
        assertTrue(whitePiece.isWhite());
        assertFalse(whitePiece.isBlack());
        assertEquals(type, whitePiece.getType());
        assertEquals(representation, whitePiece.getRepresentation());
        assertTrue(blackPiece.isBlack());
        assertFalse(blackPiece.isWhite());
        assertEquals(type, blackPiece.getType());
        assertEquals(Character.toUpperCase(representation),
                blackPiece.getRepresentation());
    }
    @Test
    public void compareTo(){
        Piece pieceQueen = Piece.createBlackQueen();
        Piece piecePawn = Piece.createWhitePawn();
        assertEquals(-1, pieceQueen.compareTo(piecePawn));
        assertEquals(1, piecePawn.compareTo(pieceQueen));
        System.out.println(piecePawn.compareTo(pieceQueen));

    }
    @Test
    public void testKingMoves(){
        ArrayList<String> value = new ArrayList<>();
        value = Piece.possibleMoves("d4", Piece.createBlackKing());
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
        value = Piece.possibleMoves("a1", Piece.createBlackKing());
        assertTrue(value.contains("a2"));
        assertTrue(value.contains("b1"));
        assertTrue(value.contains("b2"));
        System.out.println(value);
        assertEquals(3, value.size());
//      ----------------------------------
        value = Piece.possibleMoves("a8", Piece.createBlackKing());
        assertTrue(value.contains("a7"));
        assertTrue(value.contains("b7"));
        assertTrue(value.contains("b8"));
        System.out.println(value);
        assertEquals(3, value.size());
    }
    @Test
    public void testQueenMove(){
        ArrayList<String> valueQueen = new ArrayList<>();
        valueQueen = Piece.possibleMoves("e4", Piece.createBlackQueen());
        System.out.println(Piece.possibleMoves("e4", Piece.createBlackQueen()));
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
