package Exercise_11;

import chess.Board;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import org.junit.After;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class TestPositionBoardFile {
    MyFile myFile = new MyFile("board");
    Board board = new Board();

    @Test
    public void testPositionPiecesBoardFile() throws IOException {
        try {
            board.push("a5", Piece.createWhitePawn());
            board.push("d8", Piece.createWhiteQueen());
            board.push("g5", Piece.createWhiteKing());

            String boards = board.printBoard();
            myFile.write(boards);
            assertEquals(myFile.read(),board.printBoard());
        }finally {
            myFile.delete();
        }
    }
    @Test
    public void testPositionPiecesBoardSerialized() throws IOException {
        File file = new File("board");
        Board board = new Board();
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
//        BufferedReader reader = new BufferedReader(writer)
        writer.write(board.printBoard());
        writer.flush();

    }
}
