package sis.studentinfo;

import org.junit.Test;
import static org.junit.Assert.*;
import static sis.studentinfo.Student.isPalindrome;

public class StudentTest  {
//    private String name;
    private static final double GRADE_TOLERANCE = 0.5;
    private void assertGpa(Student student, double expectedGpa){
        assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
    }


    private Student createHonorsStudent(Student.Grade grade){
        Student student = createHonorsStudent();
        student.addGrade(grade);
        return student;
    }
    private Student createHonorsStudent(){
        Student student = new Student("a");
        student.setGradingStrategy(new HonorsGradingStrategy());
        return student;
    }


    @Test
    public void createStudent() {
        final String firstStudentName = "Alexandro Jesus";
        Student firstStudent = new Student(firstStudentName);
        assertEquals(firstStudentName, firstStudent.getName());
        assertEquals("Alexandro", firstStudent.getFirstName());
        assertEquals("Jesus", firstStudent.getLastName());
        assertEquals("", firstStudent.getMiddleName());
        System.out.println(firstStudentName);

        final String secondStudentName = "Pedro";
        Student secondStudent = new Student(secondStudentName);
        assertEquals("", secondStudent.getFirstName());
        assertEquals("Pedro", secondStudent.getLastName());
        assertEquals("", secondStudent.getMiddleName());
        System.out.println(secondStudentName);

        final String thirdStudentName = "Samuel David Cabral";
        Student thirdStudent = new Student(thirdStudentName);
        assertEquals("Samuel", thirdStudent.getFirstName());
        assertEquals("David", thirdStudent.getMiddleName());
        assertEquals("Cabral", thirdStudent.getLastName());
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
@Test
    public void testSwitchResults(){
        enum Score {fieldGoal, touchdown, extraPoint, twoPointConversion, safety};
        int totalPoints = 0;
        Score score = Score.touchdown;

        switch (score){
            case fieldGoal : totalPoints += 3;
            break;
            case touchdown : totalPoints += 6;
            break;
            case extraPoint : totalPoints +=1;
            break;
            case twoPointConversion :
            case safety :
                totalPoints += 2;
            break;
        }
        assertEquals(6, totalPoints);
    }
    @Test
    public void testPalindrome(){
        assertFalse(isPalindrome("abcdef"));
        assertFalse(isPalindrome("abccda"));
        assertTrue(isPalindrome("abccba"));
        assertFalse(isPalindrome("abcxba"));
        assertTrue(isPalindrome("a"));
        assertTrue(isPalindrome("aa"));
        assertFalse(isPalindrome("ab"));
        assertTrue(isPalindrome(""));
        assertTrue(isPalindrome("aaa"));
        assertTrue(isPalindrome("aba"));
        assertTrue(isPalindrome("abbba"));
        assertTrue(isPalindrome("abba"));
        assertFalse(isPalindrome("abbaa"));
        assertFalse(isPalindrome("abcda"));
    }
    @Test
    public void testForSkip(){
        StringBuilder builder = new StringBuilder();
        String string = "123456";
        for (int i = 0; i < string.length(); i += 2) {
            builder.append(string.charAt(i));
            assertEquals("135", builder.toString());
        }
    }

    public void testFibonacci(){
        assertEquals(0, fib(0));
        assertEquals(1, fib(1));
        assertEquals(1, fib(2));
        assertEquals(2, fib(3));
        assertEquals(3, fib(4));
        assertEquals(5, fib(5));
        assertEquals(8, fib(6));
        assertEquals(13, fib(7));
        assertEquals(21, fib(8));
        assertEquals(34, fib(9));
        assertEquals(55, fib(10));


    }
}
