package sis.studentinfo;

import static org.junit.Assert.*;

public class CourseTest {
    public void testCreate(){
        Course course = new Course("CMSC", "120");
        assertEquals("CMSC", course.getDepartment());
        assertEquals("120", course.getNumber());
    }
}
