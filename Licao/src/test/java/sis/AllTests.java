package sis;

import sis.superClassTest.SuperClassTest;
import sis.report.RosterReportTest;
import sis.studentinfo.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.summer.SummerCourseSessionTest;
import sis.util.DateUtilTest;

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