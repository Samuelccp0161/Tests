package Exercise_12;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ObjectProxyDumper implements InvocationHandler {
    List<String> toStringMethodCalled;
    Object target;
    public ObjectProxyDumper(Object target, String... toStringMethodCalled) {
        this.target =  target;
        this.toStringMethodCalled = Arrays.asList(toStringMethodCalled);

    }
    public Object invoke(Object proxyDumper, Method method, Object[] args) throws Throwable {
        try {
            if (isToStringMethod(method))
                return ObjectDumper.getDump(target);
            return method.invoke(target, args);
        }catch (InvocationTargetException e){
            throw e.getTargetException();
        }
    }
    private  boolean isToStringMethod(Method method){
        return "toString".equals(method.getName());
    }
}
