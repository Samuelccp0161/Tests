package chess;

import chess.pieces.King;
import chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import util.StringUtil;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;
    @Before
    public void setUp(){
        game = new Game();
    }
    @Test
    public void testCreate(){
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
        assertEquals(16, game.getNumbOfPiecesWhite());
        assertEquals(16, game.getNumbOfPiecesBlack());
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
        assertEquals(game.getPieces("c4").getClass(), King.class);
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

    @Test
    public void testSaveBoardSerialized() throws IOException, ClassNotFoundException {
        try {
            String filename = "savefile";

            game.push("a2", Piece.createBlackBishop());
            game.push("a4", Piece.createWhiteKing());
            game.push("b2", Piece.createWhiteBishop());

            game.saveSerialized(filename);

            Game game1 = new Game();

            game1.loadSerialized(filename);

            assertEquals(game.printBoard(), game1.printBoard());
        }finally {
            File file = new File("savefile");

            if (file.exists())
                assertTrue(file.delete());
        }

    }

    @Test
    public void testSaveBoardTextual() throws IOException, ClassNotFoundException {
        try {
            String filename = "savefile";

            game.push("a1", Piece.createBlackPawn());
//            game.push("a4", Piece.createWhiteKing());
//            game.push("b2", Piece.createWhiteBishop());

            game.saveTextual(filename);

            Game game1 = new Game();

            game1.loadTextual(filename);

            assertEquals(game.printBoard(), game1.printBoard());
        }finally {
            File file = new File("savefile");

            if (file.exists())
                assertTrue(file.delete());
        }
    }
    @Test
    public void testStringToPiece(){
        String pawnBlack = "P";
        String queenWhite = "q";
        String bishopBlack = "B";
        String rookWhite = "r";

        assertEquals(Piece.createBlackPawn().getRepresentation(), game.stringToPiece(pawnBlack).getRepresentation());
        assertEquals(Piece.createWhiteQueen().getRepresentation(), game.stringToPiece(queenWhite).getRepresentation());
        assertEquals(Piece.createBlackBishop().getRepresentation(), game.stringToPiece(bishopBlack).getRepresentation());
        assertEquals(Piece.createWhiteRook().getRepresentation(), game.stringToPiece(rookWhite).getRepresentation());

    }
}
