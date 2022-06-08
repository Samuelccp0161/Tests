package chess.pieces;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testPiece {
    @Test

    public void testCreate() {
        Piece whitePawn = Piece.createWhitePawn();
        assertEquals('p', whitePawn.getRepresentation());

        Piece blackPawn = Piece.createBlackPawn();
        assertEquals('P', blackPawn.getRepresentation());

        Piece whiteKnight = Piece.createWhiteKnight();
        assertEquals('n', whiteKnight.getRepresentation());

        Piece blackKnight = Piece.createBlackKnight();
        assertEquals('N', blackKnight.getRepresentation());

        Piece whiteRook = Piece.createWhiteRook();
        assertEquals('r', whiteRook.getRepresentation());

        Piece blackRook = Piece.createBlackRook();
        assertEquals('R', blackRook.getRepresentation());

        Piece whiteBishop = Piece.createWhiteBishop();
        assertEquals('b', whiteBishop.getRepresentation());

        Piece blackBishop = Piece.createBlackBishop();
        assertEquals('B', blackBishop.getRepresentation());

        Piece whiteQueen = Piece.createWhiteQueen();
        assertEquals('q', whiteQueen.getRepresentation());

        Piece blackQueen = Piece.createBlackQueen();
        assertEquals('Q', blackQueen.getRepresentation());

        Piece whiteKing = Piece.createWhiteKing();
        assertEquals('k', whiteKing.getRepresentation());

        Piece blackKing = Piece.createBlackKing();
        assertEquals('K', blackKing.getRepresentation());

//
//        Piece pawnInColor = new Piece(Piece.INCOLOR, '.');
//        assertEquals(piece.INCOLOR, pawnInColor.getColor());
//        assertEquals('.',pawnInColor.getRepresentation());
//        System.out.println(pawnInColor.getRepresentation());
    }
}
