package sis;
import sis.report.RosterReportTest;
import sis.studentinfo.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( {
        CourseSessionTest.class,
        StudentTest.class,
        RosterReportTest.class,
        DateUtilTest.class,
        BasicGradingStrategyTest.class,
        HonorsGradingStrategyTest.class
})
public class AllTests {
}