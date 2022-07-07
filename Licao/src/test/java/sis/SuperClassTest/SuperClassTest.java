package sis.SuperClassTest;

import org.junit.Test;
import sis.SuperClass.SubClass;
import sis.SuperClass.SuperClass;

import static org.junit.Assert.assertTrue;

public class SuperClassTest {
    @Test
    public void testConstructorCalls(){
        SuperClass superClass = new SubClass("parm");
        assertTrue(SuperClass.constructorWasCalled);
    }
}
