package chess;

import org.junit.Before;
import org.junit.Test;
//import chess.pieces.Pawn;

//import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testCreate(){

        assertEquals(0,  board.getNumOfPieces());
    }

   @Test
    public void testInitialize(){

       board.initialize();
       assertEquals(16,board.getNumOfPieces());
       System.out.println(board.getNumOfPieces());
       assertEquals("........" + Board.NEWLINE +
               "PPPPPPPP" + Board.NEWLINE +
               "........" + Board.NEWLINE +
               "........" + Board.NEWLINE +
               "........" + Board.NEWLINE +
               "........" + Board.NEWLINE +
               "pppppppp" + Board.NEWLINE +
               "........", board.printBoardTwo());

       System.out.println(board.printBoardTwo());
    }

}
