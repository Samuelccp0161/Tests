package Exercise_12;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CloneObject {
    public static Object clone(Object object) throws Exception {
        Constructor<?> nn = object.getClass().getConstructor();
        Object yy = (Object) nn.newInstance();

        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            field.set(yy, field.get(object));
        }
        return yy;
    }
}
