package chess.pieces;

import org.junit.Test;

import static org.junit.Assert.*;


public class testPiece {
//    @Test
//
//    public void testCreate() {
//        Piece whitePawn = Piece.createWhitePawn();
//        assertEquals('p', whitePawn.getRepresentation());
//
//        Piece blackPawn = Piece.createBlackPawn();
//        assertEquals('P', blackPawn.getRepresentation());
//
//        Piece whiteKnight = Piece.createWhiteKnight();
//        assertEquals('n', whiteKnight.getRepresentation());
//
//        Piece blackKnight = Piece.createBlackKnight();
//        assertEquals('N', blackKnight.getRepresentation());
//
//        Piece whiteRook = Piece.createWhiteRook();
//        assertEquals('r', whiteRook.getRepresentation());
//
//        Piece blackRook = Piece.createBlackRook();
//        assertEquals('R', blackRook.getRepresentation());
//
//        Piece whiteBishop = Piece.createWhiteBishop();
//        assertEquals('b', whiteBishop.getRepresentation());
//
//        Piece blackBishop = Piece.createBlackBishop();
//        assertEquals('B', blackBishop.getRepresentation());
//
//        Piece whiteQueen = Piece.createWhiteQueen();
//        assertEquals('q', whiteQueen.getRepresentation());
//
//        Piece blackQueen = Piece.createBlackQueen();
//        assertEquals('Q', blackQueen.getRepresentation());
//
//        Piece whiteKing = Piece.createWhiteKing();
//        assertEquals('k', whiteKing.getRepresentation());
//
//        Piece blackKing = Piece.createBlackKing();
//        assertEquals('K', blackKing.getRepresentation());

//
//        Piece pawnInColor = new Piece(Piece.INCOLOR, '.');
//        assertEquals(piece.INCOLOR, pawnInColor.getColor());
//        assertEquals('.',pawnInColor.getRepresentation());
//        System.out.println(pawnInColor.getRepresentation());
//    }
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
        assertEquals(Piece.Name.NO_COLOR, blank.getType());
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
}
