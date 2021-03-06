package chess;

import chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import util.StringUtil;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;

    @Before
    public void setUp(){
        game = new Game();
    }

    @Test
    public void testCreate(){
        assertEquals(64, game.piecesCount('.'));
        assertEquals(0, game.getNumbOfPieces());
//      ----------------------------------
        assertEquals(StringUtil.appendNewLine("........") +
                        StringUtil.appendNewLine("........") +
                        StringUtil.appendNewLine("........") +
                        StringUtil.appendNewLine("........") +
                        StringUtil.appendNewLine("........") +
                        StringUtil.appendNewLine("........") +
                        StringUtil.appendNewLine("........") +
                        StringUtil.appendNewLine("........"),
                game.printBoard());
    }
    @Test
    public void testInitialize(){

        game.initialize();
        assertEquals(2, game.piecesCount('R'));
        assertEquals(2, game.piecesCount('n'));
        assertEquals(2, game.piecesCount('b'));
        assertEquals(1, game.piecesCount('k'));
        assertEquals(8, game.piecesCount('p'));
        assertEquals(2, game.piecesCount('R'));
//      ----------------------------------
        assertEquals(16, Piece.getCountWhite());
        assertEquals(16, Piece.getCountBlack());
        assertEquals(32, game.getNumbOfPieces());
        assertEquals(
                StringUtil.appendNewLine("RNBQKBNR") +
                        StringUtil.appendNewLine("PPPPPPPP") +
                        StringUtil.appendNewLine("........") +
                        StringUtil.appendNewLine("........") +
                        StringUtil.appendNewLine("........") +
                        StringUtil.appendNewLine("........") +
                        StringUtil.appendNewLine("pppppppp") +
                        StringUtil.appendNewLine("rnbqkbnr"),
                game.printBoard());
        System.out.println(game.printBoard());
    }
    @Test
    public void pushPiece(){
        game.push("c4", Piece.createBlackKing());
        assertEquals(game.getPieces("c4").getType(), Piece.Name.KING );
    }
    @Test
    public void powerPieces(){
        game.push("b1", Piece.createWhitePawn());
        game.push("b6", Piece.createWhitePawn());
        game.push("b3", Piece.createWhitePawn());
        game.push("a1", Piece.createWhitePawn());
        game.push("a2", Piece.createWhitePawn());
//      ----------------------------------
        game.push("c3", Piece.createBlackPawn());
        game.push("c1", Piece.createBlackPawn());
        game.push("d2", Piece.createBlackPawn());
//      ----------------------------------
        assertEquals(2.5, game.powerWhite(), 0.05);
        assertEquals(2, game.powerBlack(), 0.05);
//      ----------------------------------
        System.out.println(game.powerPawn('p'));
        System.out.println(game.powerBlack());
    }
}
