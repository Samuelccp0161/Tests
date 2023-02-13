package Exercise_12;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestObjectDumper {
    @Test
    public void testWithOneField() throws IllegalAccessException {
        ClassWithOneField one = new ClassWithOneField();
        assertEquals("name: menusculo", ObjectDumper.getDump(one));
    }
    class ClassWithOneField {
        public String name = "menusculo";
    }

    @Test
    public void testWithTwoFields() throws IllegalAccessException {
        ClassWithTwoFields one = new ClassWithTwoFields();
        final String dump = ObjectDumper.getDump(one);
        List<String> fields = dump.lines().toList();
        assertTrue("Expected: \"name1: abc\"", fields.contains("name1: abc"));
        assertTrue("Expected: \"name2: def\"", fields.contains("name2: def"));

        assertNotEquals('\n', dump.charAt(dump.length() - 1));
    }

    class ClassWithTwoFields {
        public String name1 = "abc";
        public String name2 = "def";
    }

    @Test
    public void testWithPrivateFields() throws IllegalAccessException {
        ClassWithPrivateFields one = new ClassWithPrivateFields();
        final String dump = ObjectDumper.getDump(one);
        // name1: abc"
        // name2: def"
        List<String> fields = dump.lines().toList();
//        System.out.println(fields);
        assertTrue("Expected: \"name1: abc\"", fields.contains("name1: abc"));
        assertTrue("Expected: \"name2: def\"", fields.contains("name2: def"));

        assertNotEquals('\n', dump.charAt(dump.length() - 1));
    }

    class ClassWithPrivateFields {
        public String name1 = "abc";
        private String name2 = "def";
    }
    @Test
    public void testWithStaticFields() throws IllegalAccessException {
        ClassWithStaticFields one = new ClassWithStaticFields();
        final String dump = ObjectDumper.getDump(one);
        List<String> fields = dump.lines().toList();
//        System.out.println(fields);
        assertTrue("Expected: \"name1: abc\"", fields.contains("name1: abc"));
        assertTrue("Expected: \"static name2: def\"", fields.contains("static name2: def"));

        assertNotEquals('\n', dump.charAt(dump.length() - 1));
    }

    class ClassWithStaticFields {
        private String name1 = "abc";
        private static String name2 = "def";
    }

    @Test
    public void testWithNestedFields() throws IllegalAccessException {
        ClassWithNestedFields one = new ClassWithNestedFields();
        final String dump = ObjectDumper.getDump(one);
        final var expected =
                "name: abc\ninnerField: {\n\tinnerName: def\n}";
        assertEquals(expected, dump);

        assertNotEquals('\n', dump.charAt(dump.length() - 1));
    }

    class ClassWithNestedFields {
        public String name = "abc";
        public InnerClass innerField = new InnerClass();
    }

    static class InnerClass {
        public String innerName = "def";

    }
}
