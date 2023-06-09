package Exercise_15;

import java.lang.reflect.Field;
import java.util.*;

public class ToStringer {
    public static int getOrder(Field field) {
        return field.getAnnotation(Dump.class).order();
    }
    public static String getDump(Object obj)  throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<Field> fieldsWithDump = new ArrayList<>();

        for (Field field : fields) {
            if (field.getAnnotation(Dump.class) != null)
                fieldsWithDump.add(field);
        }

        fieldsWithDump.sort((f1, f2) -> {
//            return f1  - f2;
        });
        List<String> values = new ArrayList<>();

        for (Field field : fieldsWithDump) {
            String name = field.getName();
            Object value = field.get(obj);

            values.add(name + " = " + value);
        }

        return String.join(", ", values);
    }
}
