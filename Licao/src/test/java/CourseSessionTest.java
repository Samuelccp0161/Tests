import org.junit.Test;
import junit.framework.TestCase;
import java.util.Date;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
///import java.util.ArrayList;
//import static org.junit.Assert.assertEquals;

public class CourseSessionTest extends TestCase {

    private CourseSession session;
    private Date startDate;

    public void setUp() {
        int year = 130;
        int month = 0;
        int date = 6;
        startDate = new Date(year, month, date);
        session = new CourseSession("ENG", "101", startDate);
    }

    @Test
    public void testCreate() {

        assertEquals("ENG", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }

    public void testEnrollStudents() {
        CourseSession session = new CourseSession("ENG", "101");

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

    public void testCourseDates() {
        int year = 103;
        int month = 0;
        int date = 6;
        Date startDate = new Date(year, month, date);

        CourseSession session = new CourseSession("ABCD", "200", startDate);
        year = 103;
        month = 3;
        date = 25;
        Date sixteenWeeksOut = new Date(year, month, date);
        assertEquals(sixteenWeeksOut, session.getEndDate);

    }
}


