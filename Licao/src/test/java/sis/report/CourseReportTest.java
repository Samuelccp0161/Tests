package sis.report;

import java.util.*;

import org.junit.Test;
import sis.studentinfo.*;
import static org.junit.Assert.assertEquals;
import static sis.report.ReportConstant.NEWLINE;

public class CourseReportTest {
    @Test
    public void testReport(){
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(create("ENGL", "101", date));
        report.add(create("CZEC", "200", date));
        report.add(create("ITAL", "410", date));
        report.add(create("CZEC", "220", date));
        report.add(create("ITAL","330", date));

        assertEquals(
                "ENGL101" + NEWLINE +
                "CZEC200" + NEWLINE +
                "ITAL410" + NEWLINE +
                "CZEC220" + NEWLINE +
                "ITAL330" + NEWLINE ,
                report.text());
    }
    private Session create(String name, String number, Date date){
        return CourseSession.create(new Course(name, number), date);
    }
}
