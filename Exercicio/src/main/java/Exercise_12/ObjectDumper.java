package Exercise_12;

import java.io.*;
import java.lang.ref.Cleaner;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ObjectDumper {
    public static String getDump(Object obj) throws IllegalAccessException {

        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder valor = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (isStatic(field)) {
                valor.append("static ");
            }

            final Object fieldValue = field.get(obj);
            final String fieldName = field.getName();

            if (isFromJavaOrJavax(fieldValue))
                valor.append(fieldName).append(": ").append(fieldValue);
            else {
                valor.append(fieldName).append(": ").append("{\n").append("\t").append(getDump(fieldValue)).append("\n}");
            }

            if (i != fields.length -1){
                valor.append("\n");
            }
        }
        return valor.toString();
    }

    private static boolean isFromJavaOrJavax(Object obj) throws IllegalAccessException {
        Class<?> klass = obj.getClass();
        return klass.getName().startsWith("java");
    }

    public static boolean isStatic(Field field){
        return Modifier.isStatic(field.getModifiers());
    }

}
