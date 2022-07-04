package sis.summer;

import org.junit.Test;
import sis.studentinfo.SubClass;
import sis.studentinfo.SuperClass;

import static org.junit.Assert.assertTrue;

public class SuperClassTest {
    @Test
    public void testConstructorCalls(){
        SuperClass superClass = new SubClass("parm");
        assertTrue(SuperClass.constructorWasCalled);
    }
}
