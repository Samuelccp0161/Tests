import Exceptions.BlowsUpTest;
import Exceptions.HandlerTest;
import chess.*;
import chess.pieces.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

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