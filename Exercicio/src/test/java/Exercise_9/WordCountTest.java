package Exercise_9;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordCountTest {

    @Test
    public void testLiteralString(){

        String create = "Create a String literal using the first two sentences of this exercise.You will create a WordCount class to parse through the text and count the number of instances of each word";
        WordCount word = new WordCount(create);
        assertEquals(2, word.getCount("create"));
    }
/*    @Test
    public void testName(){
        String one = "Samuel";
        one += " David";
        String two = "func";

        assertEquals("Samuel David", one);

        assertTrue(one.equals(two));
        assertFalse(one == two);


    }
    preciso mudar o código de lugar
    preciso ajeitar o código na classe Equals, preciso deixar o método funcional
    preciso também mudar o nome da classe.
 */
}
