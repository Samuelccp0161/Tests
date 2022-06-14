package chess;

import chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import util.StringUtil;

//import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

//    @Test
//    public void testCreate(){
//
//        assertEquals(0,  board.getNumOfPieces());
//    }

   @Test
   public void testCreate() {
        Piece.resetCount();
       board.initialize();
       assertEquals(8, board.PiecesCount('p'));
       assertEquals(16, Piece.getCountWhite());
       assertEquals(16, Piece.getCountBlack());
       assertEquals(32, board.getNumbOfPieces());
       String blankRank = StringUtil.appendNewLine("........");
       System.out.println(Board.PiecesCount('p'));
       assertEquals(
               StringUtil.appendNewLine("RNBQKBNR") +
                       StringUtil.appendNewLine("PPPPPPPP") +
                       blankRank + blankRank + blankRank + blankRank +
                       StringUtil.appendNewLine("pppppppp") +
                       StringUtil.appendNewLine("rnbqkbnr"),
               board.printBoardTwo());

   }

}
