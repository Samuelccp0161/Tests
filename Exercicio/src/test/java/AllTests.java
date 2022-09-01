import Exceptions.BlowsUpTest;
import chess.*;
import chess.pieces.*;
import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        BoardTest.class,
        CharacterTest.class,
        TestPiece.class,
        GameTest.class,
        TestQueen.class,
        TestKing.class,
        TestBishop.class,
        TestKnight.class,
        TestPawn.class,
        TestRook.class,
        TestFactorial.class,
        TestSequential.class,
        BlowsUpTest.class,

})

public class AllTests {
}