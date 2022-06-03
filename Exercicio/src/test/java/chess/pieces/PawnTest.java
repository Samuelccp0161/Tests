package chess.pieces;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PawnTest {
    @Test

    public void testCreate(){
        Pawn pawn = new Pawn(Pawn.WHITE, 'p');
        assertEquals(Pawn.WHITE, pawn.getColor() );
        assertEquals('p', pawn.getRepresentation());

        Pawn pawnBlack = new Pawn(Pawn.BLACK,'P');
        assertEquals(Pawn.BLACK, pawnBlack.getColor() );
        assertEquals('P', pawnBlack.getRepresentation());

        Pawn pawnInColor = new Pawn(Pawn.INCOLOR, '.');
        assertEquals(pawn.INCOLOR, pawnInColor.getColor());
        assertEquals('.',pawnInColor.getRepresentation());
        System.out.println(pawnInColor.getRepresentation());
    }

}
