package Exercise_11;

import Exercise_11.Files.CloneObject;
import chess.pieces.Piece;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class TestSerializeObject {
    @Test
    public void testSerializeObject() throws IOException, ClassNotFoundException {
        Piece piece = Piece.createBlackPawn();
        Piece clone = (Piece) CloneObject.cloneObject(piece);

        assertNotSame(piece, clone);
        assertEquals(piece, clone);
    }
}
