package chess.pieces;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class TestPiece {
    private void verifyCreation(Piece whitePiece, Piece blackPiece, Class<?> klass, char representation) {
        assertTrue(whitePiece.isWhite());
        assertFalse(whitePiece.isBlack());
        assertEquals(klass, whitePiece.getClass());
        assertEquals(representation, whitePiece.getRepresentation());
        assertTrue(blackPiece.isBlack());
        assertFalse(blackPiece.isWhite());
        assertEquals(klass, blackPiece.getClass());
        assertEquals(Character.toUpperCase(representation),
                blackPiece.getRepresentation());
    }
    protected void assertContains(List<String> position, String... strings) {
        for (String positions :  strings)
            assertTrue(position.contains(positions));
    }
    @Test
    public void testCreate() {

        verifyCreation(
            Piece.createWhitePawn(), Piece.createBlackPawn(),
            Pawn.class, Piece.PAWN_REPRESENTATION);

        verifyCreation(
            Piece.createWhiteRook(), Piece.createBlackRook(),
            Rook.class, Piece.ROOK_REPRESENTATION);

        verifyCreation(
            Piece.createWhiteKnight(), Piece.createBlackKnight(),
            Knight.class, Piece.KNIGHT_REPRESENTATION);

        verifyCreation(
            Piece.createWhiteBishop(), Piece.createBlackBishop(),
            Bishop.class, Piece.BISHOP_REPRESENTATION);

        verifyCreation(Piece.createWhiteQueen(), Piece.createBlackQueen(),
            Queen.class, Piece.QUEEN_REPRESENTATION);

        verifyCreation(Piece.createWhiteKing(), Piece.createBlackKing(),
            King.class, Piece.KING_REPRESENTATION);

        Piece blank = Piece.noColor();
        assertEquals('.', blank.getRepresentation());
        assertEquals(NoPiece.class, blank.getClass());
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
