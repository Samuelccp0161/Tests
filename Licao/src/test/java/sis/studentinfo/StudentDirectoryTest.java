package sis.studentinfo;

import java.io.*;
import static org.junit.Assert.assertEquals;

public class StudentDirectoryTest {
    private StudentDirectory dir;
    protected void setUp() throws IOException{
        dir = new StudentDirectory();
    }
    protected  void tearDown() throws  IOException{
        dir.close();
        dir.remove();
    }
    public void testRandomAccess() throws IOException{
        final int numberOfStudents = 10;
        for (int i = 0; i < numberOfStudents; i++)
            addStudent(dir, i);
        dir.close();

        dir = new StudentDirectory();
        for (int i = 0; i < numberOfStudents; i++)
            verifyStudentLookup(dir, i);
    }
    void addStudent(StudentDirectory directory, int i) throws IOException{
        String id = "" + i;
        Student student = dir.findById(id);
        assertEquals(id, student.getLastName());
        assertEquals(id, student.getId());
        assertEquals(i, student.getCredits());
    }

    void verifyStudentLookup(StudentDirectory directory, int i) throws IOException{
        String id = "" + i;
        Student student = dir.findById(id);
        assertEquals(id, student.getLastName());
        assertEquals(id, student.getId());
        assertEquals(i, student.getCredits());
    }
}
