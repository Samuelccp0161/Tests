package sis;
import sis.SuperClassTest.SuperClassTest;
import sis.report.RosterReportTest;
import sis.studentinfo.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.summer.SummerCourseSessionTest;

@RunWith(Suite.class)
@Suite.SuiteClasses( {
        CourseSessionTest.class,
        StudentTest.class,
        RosterReportTest.class,
        DateUtilTest.class,
        BasicGradingStrategyTest.class,
        HonorsGradingStrategyTest.class,
        SummerCourseSessionTest.class,
        SuperClassTest.class,
        ScorerTest.class,
        PerformanceTest.class,
})
public class AllTests {
}