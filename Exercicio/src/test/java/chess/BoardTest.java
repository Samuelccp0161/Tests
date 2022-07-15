package chess;

import chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import util.StringUtil;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

   @Test
   public void testCreate() {
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
       System.out.println(board.printBoard());

   }
   @Test
   public void testSearchPiece(){
       board.initialize();
       assertEquals('P', board.getPiece("c7").getRepresentation());
       System.out.println(board.getPiece("c7"));
   }

   @Test
    public void testNewBoard(){
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
    public void pieceListColorsTest(){
        assertEquals(0,board.getPieceBlackList().size());
        assertEquals(0,board.getPieceWhiteList().size());

        board.push("a1", Piece.createWhitePawn());
        board.push("a2", Piece.createWhiteRook());
        board.push("a3", Piece.createWhiteQueen());
        board.push("b5", Piece.createBlackPawn());
        board.push("b1", Piece.createBlackRook());
        board.push("c4", Piece.createBlackQueen());

        board.pieceLists();

       board.getOrdWhite();
       for (Piece p : board.getPieceWhiteList())
           System.out.println(p.getRepresentation());
       assertEquals('q', board.getPieceWhiteList().get(0).getRepresentation());
       assertEquals('r', board.getPieceWhiteList().get(1).getRepresentation());
       assertEquals('p', board.getPieceWhiteList().get(2).getRepresentation());

       board.getOrdBlack();
       for (Piece p : board.getPieceBlackList())
           System.out.println(p.getRepresentation());
       assertEquals('Q', board.getPieceBlackList().get(0).getRepresentation());
       assertEquals('R', board.getPieceBlackList().get(1).getRepresentation());
       assertEquals('P', board.getPieceBlackList().get(2).getRepresentation());
   }
}