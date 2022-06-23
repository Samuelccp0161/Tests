package chess;

import chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import util.StringUtil;
import static org.junit.Assert.assertEquals;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

   @Test
   public void testCreate() {
        Piece.resetCount();
        Piece.resetCountBlack();
        board.initialize();

       assertEquals(2, board.piecesCount('R'));
       assertEquals(2, board.piecesCount('n'));
       assertEquals(2, board.piecesCount('b'));
       assertEquals(1, board.piecesCount('k'));
       assertEquals(8, board.piecesCount('p'));
       assertEquals(2, board.piecesCount('R'));

       assertEquals(16, Piece.getCountWhite());
       assertEquals(16, Piece.getCountBlack());
       assertEquals(32, board.getNumbOfPieces());
       assertEquals(
               StringUtil.appendNewLine("RNBQKBNR") +
                       StringUtil.appendNewLine("PPPPPPPP") +
                       StringUtil.appendNewLine("........") +
                       StringUtil.appendNewLine("........") +
                       StringUtil.appendNewLine("........") +
                       StringUtil.appendNewLine("........") +
                       StringUtil.appendNewLine("pppppppp") +
                       StringUtil.appendNewLine("rnbqkbnr"),
               board.printBoard());

   }
   @Test
   public void testSearchPiece(){
       board.initialize();
       assertEquals('P', board.getPiece("c7").getRepresentation());
       System.out.println(board.getPiece("c7"));
   }

   @Test
    public void testNewBoard(){
       Piece.resetCount();
       Piece.resetCountBlack();

       assertEquals(
               StringUtil.appendNewLine("........") +
                       StringUtil.appendNewLine("........") +
                       StringUtil.appendNewLine("........") +
                       StringUtil.appendNewLine("........") +
                       StringUtil.appendNewLine("........") +
                       StringUtil.appendNewLine("........") +
                       StringUtil.appendNewLine("........") +
                       StringUtil.appendNewLine("........"),
               board.printBoard());
       System.out.println(board.printBoard());
   }

   @Test
   public void pushPiece(){
        board.push("c4", Piece.createBlackKing());
        assertEquals(board.getPiece("c4").getType(), Piece.Name.KING );
   }

/*   @Test
*    public void powerPieces(){
*        board.push("a7", Piece.createBlackBishop());
*        assertEquals(3, board.powerBlack(), 0.05);
*
*       board.push("a2", Piece.createWhitePawn());
*       assertEquals(0.5, board.powerWhite(), 0.05);
   }*/


}
