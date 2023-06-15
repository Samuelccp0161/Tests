package Exercise_15;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ToStringer  {
    public static String getRepresentationValueMethod(Field field,Object obj) throws Exception {
        return obj.getClass().getDeclaredMethod(field.getAnnotation(Dump.class).outputMethod()).invoke(obj).toString();
    }
    public static String getDump(Object obj)  throws Exception {
        List<Field> fieldsWithDump = getFields(obj);
        fieldsWithDump.sort((f1, f2) -> {
            return Integer.compare(
                    f2.getAnnotation(Dump.class).order(),
                    f1.getAnnotation(Dump.class).order()
            );
        });

        List<String> values = getStrings(obj, fieldsWithDump);

        return String.join(", ", values);
    }

    private static List<Field> getFields(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<Field> fieldsWithDump = new ArrayList<>();

        for (Field field : fields) {
            if (field.getAnnotation(Dump.class) != null)
                fieldsWithDump.add(field);
        }
        return fieldsWithDump;
    }

    private static List<String> getStrings(Object obj, List<Field> fieldsWithDump) throws Exception {
        List<String> values = new ArrayList<>();
        for (Field field : fieldsWithDump) {
            String fieldRepresentation = field.getName() + " = ";
            String value = field.get(obj).toString();

            if (!field.getAnnotation(Dump.class).outputMethod().equals("toString")){
                value = getRepresentationValueMethod(field, obj);
            }

            if (field.getAnnotation(Dump.class).quote())
                value = "\"" + value + "\"";

            values.add(fieldRepresentation + value);
        }
        return values;
    }


}
