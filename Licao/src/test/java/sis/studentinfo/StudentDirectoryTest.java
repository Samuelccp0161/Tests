package sis.studentinfo;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class StudentDirectoryTest {
    private StudentDirectory dir;
    protected void setUp(){
        dir = new StudentDirectory();
    }
    public void testStoreAndRetrieve() throws IOException{
        final int numberOfStudents = 10;
        for (int i = 0; i < numberOfStudents; i++)
            addStudent(dir, i);
//        for (int i = 0; i < numberOfStudents; i++)
//            verifyStudentLookup(dir, i);
    }
    void addStudent(StudentDirectory directory, int i)
        throws IOException{
        String id = "" + i;
        Student student = dir.findById(id);
        assertEquals(id, student.getLastName());
        assertEquals(id, student.getId());
        assertEquals(i, student.getCredits());
    }
}
