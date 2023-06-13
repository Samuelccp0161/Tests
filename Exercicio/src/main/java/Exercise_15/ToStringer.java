package Exercise_15;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ToStringer  {
    public static String getOutput(Field field) {
        return field.getAnnotation(Dump.class).outputMethod();
    }
    public static String getDump(Object obj)  throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<Field> fieldsWithDump = new ArrayList<>();

        for (Field field : fields) {
            if (field.getAnnotation(Dump.class) != null)
                fieldsWithDump.add(field);
        }
        fieldsWithDump.sort((f1, f2) -> {
            return Integer.compare(
                    f2.getAnnotation(Dump.class).order(),
                    f1.getAnnotation(Dump.class).order()
            );
        });
        List<String> values = new ArrayList<>();
        for (Field field : fieldsWithDump) {
            String name = field.getName();
            Object value = field.get(obj);

            if (field.getAnnotation(Dump.class).quote())
                values.add(name + " = " + "\"" + value + "\"");
//            else if (field.getAnnotation(Dump.class).outputMethod()!= null) {
//                values.add(name + " = " + getOutput(field).);
//            }
            else
                values.add(name + " = " + value);
        }

        return String.join(", ", values);
    }


}
