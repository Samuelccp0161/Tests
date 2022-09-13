package Exercise_9;

import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class WordCountTest {

    @Test
    public void testLiteralString(){

        String create = "Create a String literal using the first two sentences of this exercise.You will create a WordCount class to parse through the text and count the number of instances of each word";
        WordCount word = new WordCount(create);
        assertEquals(2, word.getCount("create"));
    }
    @Test
    public void testName(){
        Name one = new Name("samuel");
        Name two = new Name("samuel");
        Name three = new Name("diff");

        //reflexivity
        assertEquals(one, two);
        assertNotEquals(one, three);
        //symmetry
        assertEquals(two, one);
        //consistency
        assertEquals(one, two);
    }
    @Test
    public void testFoo(){
        Name foo = new Name("Foo");
        Set<Name> nasde = new HashSet<>();

        nasde.add(foo);

        assertTrue(nasde.contains(new Name("Foo")));
        assertTrue(nasde.contains(foo));

    }

}
