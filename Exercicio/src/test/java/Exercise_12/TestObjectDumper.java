package Exercise_12;

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
        // name1: abc"
        // name2: def"
        List<String> fields = dump.lines().toList();
        System.out.println(fields);
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
        System.out.println(fields);
        assertTrue("Expected: \"name1: abc\"", fields.contains("name1: abc"));
        assertTrue("Expected: \"name2: def\"", fields.contains("name2: def"));

        assertNotEquals('\n', dump.charAt(dump.length() - 1));
    }

    class ClassWithPrivateFields {
        public String name1 = "abc";
        private String name2 = "def";
    }
}
