package chess;

import chess.pieces.TestPiece;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
//import util.StringUtil;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        BoardTest.class,
        CharacterTest.class,
        TestPiece.class,
        GameTest.class,
})

public class AllTests {
}
