package chess.pieces;

import org.junit.Test;

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
}
