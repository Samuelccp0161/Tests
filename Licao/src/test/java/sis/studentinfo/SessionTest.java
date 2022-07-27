package sis.studentinfo;

import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static sis.studentinfo.DateUtil.createDate;
import static sis.studentinfo.Session.*;

abstract public class SessionTest {
    protected Session session;
    protected Date startDate;
    public static final int CREDITS = 3;
    @Before
    public void setUp(){
        startDate = createDate(2003,1,6);
        session = createSession("ENGL","101", startDate);
        session.setNumberOfCredits(CREDITS);
    }

    abstract protected Session createSession(
            String department, String number, Date startDate);

    @Test
    public void testCreate(){
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0,session.getNumberOfStudents());
        assertEquals(startDate,  session.getStartDate());
    }
    @Test
    public void testEnrollStudent(){
        Student student1 = new Student("Alexandro Pedro");
        session.enroll(student1);
        assertEquals(CREDITS, student1.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        System.out.println(student1.getCredits());

        Student student2 = new Student("Jesus Silva");
        session.enroll(student2);
        assertEquals(CREDITS, student2.getCredits());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
        System.out.println(student2.getName());
    }
    @Test
    public void testComparable(){
        final Date date = new Date();
        Session sessionA = createSession("CMSC", "101", date);
        Session sessionB = createSession("ENGL", "101", date);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);
}
    @Test
    public void testSessionLength() {
        Session session = createSession("","", startDate);
        assertTrue(session.getSessionLength() > 0);
    }
    @Test
    public void testAverageGpaForPartTimeStudents(){
        session.enroll(createFullTimeStudent());

        Student partTimer1 = new Student("1");
        partTimer1.addGrade(Student.Grade.A);
        session.enroll(partTimer1);

        session.enroll(createFullTimeStudent());

        Student partTimer2 = new Student("1");
        partTimer2.addGrade(Student.Grade.B);
        session.enroll(partTimer2);
        assertEquals(3.5, session.averageGpaForPartTimeStudents(), 0.05);
    }

}
