package sis.studentinfo;

import static  org.junit.Assert.assertEquals;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;

public class DateUtilTest {

    public void testCreateDate(){
        Date date = new DateUtil().createDate(2000, 1, 1);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        assertEquals (2000, calendar.get(Calendar.YEAR));
        assertEquals (Calendar.JANUARY, calendar.get(Calendar.MONTH));
        assertEquals (1, calendar.get(Calendar.DAY_OF_MONTH));
    }
}


