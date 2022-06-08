package sis.studentinfo;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest  {
    private String name;

    @Test
    public void createStudent() {
        final String firstStudentName = "Alexandro Jesus";
        Student student = new Student(firstStudentName);
        assertEquals(firstStudentName, student.getName());
        System.out.println(firstStudentName);

        final String secondStudentName = "Silva Pedro";
        Student secondStudent = new Student(secondStudentName);
        assertEquals("Silva Pedro", secondStudent.getName());
        System.out.println(secondStudentName);
    }
    @Test
    public void testFullTime() {
        Student student = new Student("a");
        assertFalse(student.isFullTime());
    }

    @Test
    public void testCredits(){
     Student student = new Student("a");
     assertEquals(0, student.getCredits());
     student.addCredits(3);
     assertEquals(3, student.getCredits());
     student.addCredits(4);
     assertEquals(7, student.getCredits());
    }

    @Test
    public void testStudentStatus(){
        Student student = new Student("a");
            assertEquals(0,student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(3);
        assertEquals(3, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(4);
        assertEquals(7, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(5);
        assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
        assertTrue(student.isFullTime());
    }

    @Test
    public void testInState(){
        Student student = new Student("a");
        assertFalse(student.isInState());
        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());
        student.setState("MD");
        assertFalse(student.isInState());
    }


}
