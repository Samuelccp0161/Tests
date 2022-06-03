package chess;

import chess.pieces.PawnTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PawnTest.class,
        BoardTest.class,
        CharacterTest.class
})

public class AllTests {
}



