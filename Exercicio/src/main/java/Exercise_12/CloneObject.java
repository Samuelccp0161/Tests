package Exercise_12;

import javax.management.ObjectName;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class CloneObject {
    public static Object clone(Object object) throws Exception {
        Constructor<?> nn = object.getClass().getConstructor();
        Object yy = (Object) nn.newInstance();

        Field[] fields = object.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            field.set(yy, field.get(object));
        }
        return yy;
    }
}
