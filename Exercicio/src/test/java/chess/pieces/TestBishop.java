package chess.pieces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBishop {
    @Test
    public void testBishop(){
        Bishop bishopBlack = new Bishop(Piece.createBlackBishop());
        assertEquals('B',bishopBlack.getRepresentation());
        Bishop bishopWhite = new Bishop(Piece.createWhiteBishop());
        assertEquals('b',bishopWhite.getRepresentation());
    }
}
