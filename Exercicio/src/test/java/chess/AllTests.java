package chess;

import chess.pieces.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
//import util.StringUtil;

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
        TestRook.class
})

public class AllTests {
}
