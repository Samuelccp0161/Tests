package Exercise_15;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToStringer {

    public static String getDump(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<Field> fieldsWithDump = new ArrayList<>();

        for (Field field : fields){
            if (field.getAnnotation(Dump.class) != null)
                fieldsWithDump.add(field);
        }

        for (int i = 0; i < fieldsWithDump.size(); i++){
        // estudar collections.sort que é algo que eu posso usar para ordenar.
        }

        List<String> values = new ArrayList<>();

        for (Field field : fieldsWithDump) {
            String name = field.getName();
            Object value = field.get(obj);

            values.add(name + " = " + value);
        }

        return String.join(", ", values);
    }
}
