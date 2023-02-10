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

            if (isFromJavaOrJavax(field))
                valor.append(field.getName()).append(": ").append(field.get(obj));
            else {
                valor.append(field.getName()).append(": ").append("{\n").append("\t" + getDump(field.get(obj))).append("\n}");
            }

            if (i != fields.length -1){
                valor.append("\n");
            }
        }
        return valor.toString();
    }

    private static boolean isFromJavaOrJavax(Field field) throws IllegalAccessException {
        Class<?> klass = field.getType();
        return klass.getPackage().getName().startsWith("java");
    }

    public static boolean isStatic(Field field){
        return Modifier.isStatic(field.getModifiers());
    }
//    public static boolean isJavaOrJavax(Field field){
//        return field.getClass().equals("java") || field.getClass().equals("javax")
//    }
}
