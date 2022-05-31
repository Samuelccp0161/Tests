package chess.pieces;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PawnTest {


    @Test

    public void testCreate(){
        Pawn pawn = new Pawn(Pawn.WHITE);
        assertEquals(Pawn.WHITE, pawn.getColor() );

        Pawn pawnBlack = new Pawn(Pawn.BLACK);
        assertEquals(Pawn.BLACK, pawnBlack.getColor() );

        Pawn pawnInColor = new Pawn();
        assertEquals(pawn.WHITE, pawnInColor.getColor());
    }

}
