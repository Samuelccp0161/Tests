package sis;
import sis.report.RosterReportTest;
import sis.studentinfo.CourseSessionTest;
import sis.studentinfo.DateUtilTest;
import sis.studentinfo.StudentTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( {
        CourseSessionTest.class,
        StudentTest.class,
        RosterReportTest.class,
        DateUtilTest.class
})
public class AllTests {
}