package chess;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterTest {
    @Test
    public void testWhitespace(){

    assertTrue(Character.isWhitespace('\n'));
    assertTrue(Character.isWhitespace('\t'));
    assertFalse(Character.isWhitespace('\b'));
    }
    @Test
    public void testIdentifier(){

        assertTrue(Character.isJavaIdentifierPart('2'));
    }
}