package sis.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListUtilTest {
    @Test
    public void testPad() {
        final int count = 5;
        List<Date> list = new ArrayList<>();
        final Date element = new Date();
        ListUtil.pad(list,element, count);
        assertEquals(count, list.size());
        for (int i = 0; i < count; i++)
            assertEquals("unexpected element at " + i, element, list.get(i));
    }
}
