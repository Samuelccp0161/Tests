package sis.testing.testclasses;

import java.util.*;

import static org.junit.Assert.*;

public class NotATestClass {
    public void testGatherTestClassNames() {
        SuiteBuilder builder = new SuiteBuilder();
        List<String> classes = builder.gatherTestClassNames();
        assertTrue(classes.contains("testing.SuiteBuilderTest"));
        assertFalse(classes.contains("testing.testclasses.NotATestClass"));
    }
}
