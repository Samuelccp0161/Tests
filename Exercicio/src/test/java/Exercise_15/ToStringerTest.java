package Exercise_15;

import org.junit.Test;

import static org.junit.Assert.*;

public class ToStringerTest {
    @Test
    public void testEmptyDump() throws Exception {
        //vou passsar uma objeto(qualquer objeto) aonde nao tenha nenhuma anotação @dump.
        EmptyDump emptyDump = new EmptyDump();
        String dump = ToStringer.getDump(emptyDump);
        assertEquals("", dump);
    }

    @Test
    public void testOneDump() throws Exception {
        OneDump oneDump = new OneDump();
        String dump = ToStringer.getDump(oneDump);
        assertEquals("str = 1", dump);

    }

    static class EmptyDump{
        String str = "1";
    }
    static class OneDump{
        @Dump
        String str = "1";
    }
}