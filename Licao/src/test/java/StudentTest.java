import org.junit.Test;
import static  org.junit.Assert.assertEquals;

public class StudentTest extends junit.framework.TestCase {
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




}
