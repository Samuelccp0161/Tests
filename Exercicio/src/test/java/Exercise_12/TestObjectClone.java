package Exercise_12;

import org.junit.Test;

import javax.xml.xpath.XPathFactoryConfigurationException;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class TestObjectClone {
    @Test
    public void testObjectClone() throws Exception {
        TestClone object = new TestClone();
        TestClone cloneObject = (TestClone) CloneObject.clone(object);
        assertEquals(object.string, cloneObject.string);
    }
    static class TestClone {
        String string = "Marte";
        public TestClone(){
            this.string = "nn";
        }

    }
}
