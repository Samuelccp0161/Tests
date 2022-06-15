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
//       assertEquals(2, board.piecesCount('r'));
       assertEquals(2, board.piecesCount('R'));
       assertEquals(2, board.piecesCount('n'));
       assertEquals(2, board.piecesCount('b'));
       assertEquals(1, board.piecesCount('k'));
       assertEquals(8, board.piecesCount('p'));
       assertEquals(2, board.piecesCount('R'));
       System.out.println(board.piecesCount('P'));
//       assertEquals(8, board.PiecesCount('p'));
       assertEquals(16, Piece.getCountWhite());
       assertEquals(16, Piece.getCountBlack());
       assertEquals(32, board.getNumbOfPieces());
       String blankRank = StringUtil.appendNewLine("........");
       assertEquals(
               StringUtil.appendNewLine("RNBQKBNR") +
                       StringUtil.appendNewLine("PPPPPPPP") +
                       blankRank + blankRank + blankRank + blankRank +
                       StringUtil.appendNewLine("pppppppp") +
                       StringUtil.appendNewLine("rnbqkbnr"),
               board.printBoardTwo());

   }
//   @Test
//   public void testSearchPiece(){
//
//   }

}
