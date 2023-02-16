package Exercise_12;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class TestObjectProxyDumper {
    // tenho que pegar um objeto e ver os metodos que tem dentro dele.

    ToString object;
    ObjectProxyDumper proxyDumper;
    String toStringMethodMessage = "toString";
    String methodsMessage = "methodsCalled";
    static boolean toStringMethodCalled;
    static boolean methodsCalled;

    @Before
    public void setUp() throws Exception {
        object = new TestToString();
        proxyDumper = new ObjectProxyDumper(object, methodsMessage);
    }

    @Test
    public void testOtherMethods() throws Throwable {
        Method method = object.getClass().getDeclaredMethod(methodsMessage);
        proxyDumper.invoke(proxyDumper, method, new Object[]{});
        assertTrue(methodsCalled);
    }

    @Test
    public void testToStringToDumper() throws Throwable{
        Method methodToString = ToString.class.getDeclaredMethod("toString");

        String dump = (String) proxyDumper.invoke(proxyDumper, methodToString, new Object[]{});
        assertEquals(ObjectDumper.getDump(object), dump);
    }

    static class TestToString implements ToString {
        int number = 101;
        public void toStringCalled() {
            toStringMethodCalled = true;
        }
        public void methodsCalled(){
            methodsCalled = true;
        }
    }
}
