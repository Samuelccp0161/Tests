package sis.report;
import sis.studentinfo.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import sis.studentinfo.CourseSession;
import sis.studentinfo.DateUtil;
import sis.studentinfo.Student;
import static sis.report.ReportConstant.NEWLINE;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class RosterReportTest {
    private CourseSession session;
    private Date startDate;
///    @Before
///    public void setUp() throws Exception {
//        session = new CourseSession("ENGL", "101", startDate);
//    }

    @Test
    public void testRosterReport(){

        CourseSession session = CourseSession.create("ENGL", "101", DateUtil.createDate(2003,1,6));
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));

        String rosterReport = new RosterReport(session).getReport();
        System.out.println(rosterReport);

        assertEquals(RosterReport.ROSTER_REPORT_HEADER +
                "A" + NEWLINE +
                "B" + NEWLINE +
                RosterReport.ROSTER_REPORT_FOOTER + "2" + NEWLINE, rosterReport);
    }

}
