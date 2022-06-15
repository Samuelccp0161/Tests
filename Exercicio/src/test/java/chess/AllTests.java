package chess;

import chess.pieces.testPiece;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
//import util.StringUtil;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        BoardTest.class,
        CharacterTest.class,
        testPiece.class
})

public class AllTests {
}
