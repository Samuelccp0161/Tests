package sis.studentinfo;

import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import static sis.studentinfo.DateUtil.createDate;

abstract public class SessionTest {
    protected Session session;
    protected Date startDate;
    public static final int CREDITS = 3;
    @Before
    public void setUp(){
        startDate = createDate(2003,1,6);
        session = createSession(new Course("ENGL", "101"), startDate);
        session.setNumberOfCredits(CREDITS);
    }
    abstract protected Session createSession(
            Course course, Date startDate);
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
        Session sessionA = createSession(new Course("CMSC", "101"), date);
        Session sessionB = createSession(new Course("ENGL", "101"), date);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);
}
    @Test
    public void testSessionLength() {
        Session session = createSession(new Course("", ""), startDate);
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
    public static Student createFullTimeStudent(){
        Student student = new Student("a");
        student.addCredits(Student.CREDITS_REQUIRED_FOR_FULL_TIME);
        return student;
    }
    @Test
    public void testLabeledBreak(){
        List<List<String>> table = new ArrayList<List<String>>();

        List<String> row1 = new ArrayList<String>();
        row1 = new ArrayList<String>();
        row1.add("5");
        row1.add("2");
        List<String> row2 = new ArrayList<String>();
        row2.add("3");
        row2.add("4");

        table.add(row1);
        table.add(row2);
        assertTrue(found(table, "3"));
        assertFalse(found(table, "8"));
    }
    private boolean found(List<List<String>> table, String target){
        boolean found = false;
        search:
        for (List<String> row: table){
            for (String value: row){
                if(value.equals(target)){
                    found = true;
                    break search;
                }
            }
        }
        return found;
    }
    @Test
    public void testIterate(){
        enrollStudents(session);

        List<Student> results = new ArrayList<Student>();
        for (Student student: session)
            results.add(student);

        assertEquals(session.getAllStudents(), results);
    }
    private void enrollStudents(Session session){
        session.enroll(new Student("1"));
        session.enroll(new Student("2"));
        session.enroll(new Student("3"));
    }
    @Test
    public void testSessionUrl() throws SessionException {
        final String url = "http://course.langrsoft.com/cmsc300";
        session.setUrl(url);
        assertEquals(url, session.getUrl().toString());
    }
    @Test
    public void testInvalidSessionUrl(){
        final String url = "httsp://course.langrsoft.com/cmsc300";
        try {
            session.setUrl(url);
        }
        catch (SessionException expectedException){
            Throwable cause = expectedException.getCause();
            assertEquals(MalformedURLException.class, cause.getClass());
        }
    }
}
