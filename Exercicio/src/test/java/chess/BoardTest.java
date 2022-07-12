package chess;

import chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import util.StringUtil;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    @Test
    public void freeTestPosition(){
        ArrayList<String> value = new ArrayList<>();
        value = board.freePositions("d4", Piece.createBlackKing());
        System.out.println(value);
        assertTrue(value.contains("c3"));
        assertTrue(value.contains("c4"));
        assertTrue(value.contains("c5"));

        assertTrue(value.contains("d3"));
        assertTrue(value.contains("d5"));

        assertTrue(value.contains("e5"));
        assertTrue(value.contains("e4"));
        assertTrue(value.contains("e3"));

//      ----------------------------------

        value = board.freePositions("a1", Piece.createBlackKing());
        System.out.println(value);
        assertTrue(value.contains("a2"));
        assertTrue(value.contains("b1"));
        assertTrue(value.contains("b2"));
        assertEquals(3, value.size());
    }


}