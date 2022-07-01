package sis.studentinfo;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest  {
//    private String name;
    private static final double GRADE_TOLERANCE = 0.5;
    private void assertGpa(Student student, double expectedGpa){
        assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
    }


    private Student createHonorsStudent(Student.Grade grade){
        Student student = new Student("a");
        student.setGradingStrategy(new HonorsGradingStrategy());
        return student;
    }
    private Student createHonorsStudent(){
        Student student = new Student("a");
        student.setHonors();
        return student;
    }


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

///    @Test
///    public void testCalculateGpa() {
//        Student student = new Student("a");
//        assertGpa(student, 0.0);
//        student.addGrade(Student.Grade.A);
//        assertGpa(student, 4.0);
//        student.addGrade(Student.Grade.B);
//        assertGpa(student, 3.5);
//        student.addGrade(Student.Grade.C);
//        assertGpa(student, 3.0);
//        student.addGrade(Student.Grade.D);
//        assertGpa(student, 2.5);
//        student.addGrade(Student.Grade.F);
//        assertGpa(student, 2.0);
//    }

    @Test
    public void testCalculateHonorsStudentGpa(){
        assertGpa(createHonorsStudent(), 0.0);
        assertGpa(createHonorsStudent(Student.Grade.A), 5.0);
        assertGpa(createHonorsStudent(Student.Grade.B), 4.0);
        assertGpa(createHonorsStudent(Student.Grade.C), 3.0);
        assertGpa(createHonorsStudent(Student.Grade.D), 2.0);
        assertGpa(createHonorsStudent(Student.Grade.F), 0.0);

    }


}
