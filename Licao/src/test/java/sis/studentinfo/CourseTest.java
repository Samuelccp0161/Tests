package sis.studentinfo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CourseTest {
    @Test
    public void testCreate(){
        Course course = new Course("CMSC", "120");
        assertEquals("CMSC", course.getDepartment());
        assertEquals("120", course.getNumber());
    }
    @Test
    public void testEquality(){
        Course courseA = new Course("NURS", "201");
        Course courseAPrime = new Course("NURS", "201");
        assertEquals(courseA,courseAPrime);

        Course courseB = new Course("ARTH", "330");
        assertFalse(courseA.equals(courseB));
        // reflexivity
        assertEquals(courseA, courseA);
        // transitivity
        Course courseAPrime2 = new Course("NURS", "201");
        assertEquals(courseAPrime,courseAPrime2);
        assertEquals(courseA, courseAPrime2);
        // symmetry
        assertEquals(courseAPrime, courseA);
        // consistency
        assertEquals(courseA, courseAPrime);
        // comparison to null
        assertFalse(courseA.equals(null));
        // containment
        List<Course> list = new ArrayList<Course>();
        list.add(courseA);
        assertTrue(list.contains(courseAPrime));
//        or
        Map<Course, String> map = new HashMap<Course, String>();
        map.put(courseA, "");
        assertTrue(map.containsKey(courseAPrime));

    }
    @Test
    public void testHashCode(){
        Course courseA = new Course("NURS","201");
        Course courseAPrime = new Course("NURS", "201");

        assertEquals(courseA.hashCode(), courseAPrime.hashCode());
        //consistency
        assertEquals(courseA.hashCode(), courseA.hashCode());
    }
    @Test
    public void testHashCodePerformance(){
        final int count = 10000;
        long start = System.currentTimeMillis();
        Map<Course, String> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            Course course = new Course("C" + i, ""+ i);
            map.put(course, "");
        }
        long stop = System.currentTimeMillis();
        long elapsed = stop - start;
        final long arbitraryThreshold = 200;
        assertTrue("elapsed time = " + elapsed, elapsed < arbitraryThreshold);
    }
}
