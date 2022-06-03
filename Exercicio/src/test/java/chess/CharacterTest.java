package chess;

import org.junit.Test;

import static java.lang.Character.isJavaIdentifierPart;
import static org.junit.Assert.assertEquals;
public class CharacterTest {
@Test

    public void testWhitespace(){

        assertEquals(true, Character.isWhitespace('\n'));
        assertEquals(true, Character.isWhitespace('\t'));
        assertEquals(false, Character.isWhitespace('\b'));
    }
    @Test
    public void testIdentifier(){

        assertEquals(true,Character.isJavaIdentifierPart('2'));
    }

}

