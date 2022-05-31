package sis.studentinfo;

import org.junit.Test;
import junit.framework.TestCase;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
///import studentinf.CourseSession;
//import studentinf.Student;

public class CourseSessionTest extends TestCase {

    private CourseSession session;
    private Date startDate;

    public void setUp() {
        startDate = new DateUtil().createDate(2003, 1,6);
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

        Student student2 = new Student("Jesus Silva");
        session.enroll(student2);
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
    }

    public void testCourseDates(){
        Date sixteenWeeksOut = new DateUtil().createDate(2003,4,24);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }
}