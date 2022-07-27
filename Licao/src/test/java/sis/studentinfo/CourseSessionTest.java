package sis.studentinfo;

import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static sis.studentinfo.DateUtil.createDate;



public class CourseSessionTest extends SessionTest {
    @Test
    public void testComparable(){
        final Date date = new Date();
        CourseSession sessionA = CourseSession.create("CMSC", "101", date);
        CourseSession sessionB = CourseSession.create("ENGL", "101", date);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);

        CourseSession sessionC = CourseSession.create("CMSC", "101", date);
        assertEquals(0, sessionA.compareTo(sessionC));

        CourseSession sessionD = CourseSession.create("CMSC", "210", date);
        assertTrue(sessionA.compareTo(sessionD) < 0);
        assertTrue(sessionB.compareTo(sessionC) > 0);
    }
    @Test
    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }
    @Test
    public void testCourseDates(){
        Date startDate = DateUtil.createDate(2003, 1, 6);
        Session session = createSession("ENGL", "200", startDate);
        Date sixteenWeeksOut = createDate(2003,4,25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }
    @Test
    public void testCount(){
        CourseSession.resetCount();
        createSession("", "", new Date());
        assertEquals(1, CourseSession.getCount());
        createSession("", "", new Date());
        assertEquals(2, CourseSession.getCount());
    }

    @Override
    protected Session createSession(String department, String number, Date startDate) {
        return CourseSession.create(department, number, startDate);
    }
}