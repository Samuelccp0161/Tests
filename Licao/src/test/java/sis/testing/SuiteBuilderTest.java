package sis.testing;

import java.util.List;

import static org.junit.Assert.*;

public class SuiteBuilderTest {
    public void testGatherTestClassNames(){
        SuiteBuilderTest builderTest = new SuiteBuilderTest();
        List<String> classes = builderTest.gatherTestClassNames();
        assertTrue(classes.contains("testing.SuiteBuilderTest"));
    }
}
