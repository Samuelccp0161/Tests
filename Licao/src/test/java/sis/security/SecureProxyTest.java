package sis.security;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.security.Security;

import static org.junit.Assert.*;

public class SecureProxyTest {
    private static final String secureMethodName = "secure";
    private static final String insecureMethodName = "insecure";
    private  Object object;
    private SecureProxy proxy;
    private boolean secureMethodCalled;
    private boolean insecureMethodCalled;

    @Before
    public void setUp() {
        object = new Object() {
            public void secure(){
                secureMethodCalled = true;
            }
            public void insecure(){
                insecureMethodCalled = true;
            }
        };
        proxy = new SecureProxy(object, secureMethodName);
    }

    @Test
    public void testInsecureMethod() throws Throwable {
        Method insecureMethod = object.getClass().getDeclaredMethod(insecureMethodName);
        proxy.invoke(proxy, insecureMethod, new Object[]{});
        assertTrue(insecureMethodCalled);
    }

    @Test
    public void testSecureMethod() throws Throwable {
        Method secureMethod = object.getClass().getDeclaredMethod(secureMethodName);
        try {
            proxy.invoke(proxy, secureMethod, new Object[]{});
            fail("expected PermissionException");
        }
        catch (PermissionException exception){
            assertFalse(secureMethodCalled);
        }

    }
}
