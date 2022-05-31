package sis.report;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import sis.studentinfo.CourseSession;
import sis.studentinfo.DateUtil;
import sis.studentinfo.Student;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class RosterReportTest {
    private CourseSession session;
    private Date startDate;
//    @Before
//    public void setUp() throws Exception {
//        session = new CourseSession("ENGL", "101", startDate);
//    }

    @Test
    public void testRosterReport(){

        CourseSession session = new CourseSession("ENGL", "101", new DateUtil().createDate(2003,1,6));
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));

        String rosterReport = new RosterReport(session).getReport();
        assertEquals(RosterReport.ROSTER_REPORT_HEADER +
                "A" + RosterReport.NEWLINE +
                "B" + RosterReport.NEWLINE +
                RosterReport.ROSTER_REPORT_FOOTER + "2" + RosterReport.NEWLINE, rosterReport);
    }

}
