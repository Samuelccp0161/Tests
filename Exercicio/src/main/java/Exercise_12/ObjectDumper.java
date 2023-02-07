package Exercise_12;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ObjectDumper {
    public static String getDump(Object obj) throws IllegalAccessException {

        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder valor = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (isStatic(field))
                valor.append("static ");

            valor.append(field.getName()).append(": ").append(field.get(obj));

            if (i != fields.length -1){
                valor.append("\n");
            }
        }
        return valor.toString();
    }
    public static boolean isStatic(Field field){
        return Modifier.isStatic(field.getModifiers());
    }
}
