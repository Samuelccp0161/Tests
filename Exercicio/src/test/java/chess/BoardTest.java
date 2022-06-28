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

    @Test
    public void powerPieces(){

        board.push("b1", Piece.createWhitePawn());
        board.push("b6", Piece.createWhitePawn());
        board.push("b3", Piece.createWhitePawn());
        board.push("a1", Piece.createWhitePawn());
        board.push("a2", Piece.createWhitePawn());

        board.push("c3", Piece.createBlackPawn());
        board.push("c1", Piece.createBlackPawn());
        board.push("d2", Piece.createBlackPawn());

        assertEquals(2.5, board.powerWhite(), 0.05);
        assertEquals(2, board.powerBlack(), 0.05);

        System.out.println(board.powerPawn('p'));
        System.out.println(board.powerBlack());
   }


}
