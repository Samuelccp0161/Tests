import Exceptions.BlowsUpTest;
import Exercise_9.WordCountTest;
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
        WordCountTest.class,


})

public class AllTests {
}