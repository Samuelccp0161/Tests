package sis.superClassTest;

import org.junit.Test;
import sis.superClass.SubClass;
import sis.superClass.SuperClass;

import static org.junit.Assert.assertTrue;

public class SuperClassTest {
    @Test
    public void testConstructorCalls(){
        SuperClass superClass = new SubClass();
        assertTrue(SuperClass.constructorWasCalled);
    }
}
