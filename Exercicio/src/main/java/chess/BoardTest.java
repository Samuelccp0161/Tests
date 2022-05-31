package chess;

import org.junit.Test;
import chess.pieces.Pawn;
import static org.junit.Assert.assertEquals;


public class BoardTest {
    @Test
    public void TestCreate(){
        Board board = new Board();
        assertEquals(0, board.getNumOfPieces());
    }

    @Test
    public void testCouterPawn() {
        Board board = new Board();
        Pawn pawn = new Pawn(Pawn.WHITE);
        board.addPawn(pawn);
        assertEquals(1,board.getNumOfPieces());

        Pawn pawnBlack = new Pawn(Pawn.BLACK);
        board.addPawn(pawnBlack);
        assertEquals(2, board.getNumOfPieces());

    }
}
