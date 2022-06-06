package sis.studentinfo;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
//import java.util.Calendar;
import java.util.Date;
//import java.util.GregorianCalendar;
import static sis.studentinfo.DateUtil.createDate;
//import studentinf.Student;

public class CourseSessionTest extends TestCase {

    private CourseSession session;
    private Date startDate;

    @Before
    public void setUp() {

        startDate = createDate(2003, 1,6);
        session = new CourseSession("ENGL", "101", startDate);

    }

    @Test
    public void testCreate() {

        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }

    public void testEnrollStudents() {

        CourseSession session = new CourseSession("ENGL", "101");
        Student student1 = new Student("Alexandro Pedro");
        session.enroll(student1);
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        System.out.println(student1.getName());

        Student student2 = new Student("Jesus Silva");
        session.enroll(student2);
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
        System.out.println(student2.getName());
    }

    public void testCourseDates(){
        Date sixteenWeeksOut = createDate(2003,4,25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }

    public void testCount(){
        CourseSession.resetCount();
        createCourseSession();
        assertEquals(1, CourseSession.getCount());
        createCourseSession();
        assertEquals(2, CourseSession.getCount());
    }

    private CourseSession createCourseSession(){
        return new CourseSession("ENGL", "101",startDate);
    }
}