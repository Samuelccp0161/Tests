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

    @Test
    public void testMultipleDump() throws Exception {
        MultipleDump multipleDump = new MultipleDump();
        String dump = ToStringer.getDump(multipleDump);
        assertEquals("str1 = 1, str2 = 2", dump);
    }

    @Test
    public void testOrderDump() throws Exception {
        OrderDump orderDump = new OrderDump();
        String dump = ToStringer.getDump(orderDump);
        assertEquals("str3 = 3, str2 = 2, str1 = 1", dump);
    }

    @Test
    public void testQuote() throws Exception {
        QuoteDump quoteDump = new QuoteDump();
        String dump = ToStringer.getDump(quoteDump);
        assertEquals("str = \"1\"", dump);
    }

    @Test
    public void testOutputMethod() throws Exception {
        OutputDump outputDump = new OutputDump();
        String dump = ToStringer.getDump(outputDump);
        assertEquals("str = 1, str2 = 2", dump);
    }


    static class EmptyDump{
        String str = "2";
    }
    static class OneDump{
        @Dump
        String str = "1";
    }
    static class MultipleDump{
        @Dump
        String str1 = "1";
        @Dump
        String str2 = "2";
        String str3 = "3";
    }static class OrderDump{
        @Dump
        String str1 = "1";
        @Dump(order = 2)
        String str3 = "3";
        @Dump(order = 1)
        String str2 = "2";
    }
    static class QuoteDump{
        @Dump(quote = true)
        String str = "1";

    }
    static class OutputDump{
        @Dump(outputMethod = "print")
        String str1 = "isso sera ignorado";

        @Dump
        String str2 = "2";

        String print() {
            return "1";
        }
    }
}