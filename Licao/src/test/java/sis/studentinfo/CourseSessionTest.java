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
        Session sessionA = CourseSession.create(new Course("CMSC", "101"), date);
        Session sessionB = CourseSession.create(new Course("ENGL", "101"), date);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);

        Session sessionC = CourseSession.create(new Course("CMSC", "101"), date);
        assertEquals(0, sessionA.compareTo(sessionC));

        Session sessionD = CourseSession.create(new Course("CMSC", "210"), date);
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
        Session session = createSession(createCourse(), startDate);
        Date sixteenWeeksOut = createDate(2003,4,25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }
    @Test
    public void testCount(){
        CourseSession.resetCount();
        createSession(createCourse(), new Date());
        assertEquals(1, CourseSession.getCount());
        createSession(createCourse(), new Date());
        assertEquals(2, CourseSession.getCount());
    }
    private Course createCourse(){
        return new Course("ENGL", "101");
    }
    @Override
    protected Session createSession(Course course, Date date) {
        return CourseSession.create(course, date);
    }
}