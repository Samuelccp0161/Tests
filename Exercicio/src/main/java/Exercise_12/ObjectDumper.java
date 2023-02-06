package Exercise_12;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ObjectDumper {
    public static String getDump(Object obj) throws IllegalAccessException {

        StringBuilder builder = new StringBuilder();
        Field[] fields = obj.getClass().getDeclaredFields();
        String results = "" ;
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            results += field.getName() + ": " + field.get(obj);
            if (i != fields.length -1){
                results += "\n";
            }
            if  (isPublic(field)){

            }
        }
        return results;
    }
    public static boolean isPublic(Field field){
        return Modifier.isPublic(field.getModifiers());
    }
    public boolean isPrivate(Field field){
        return Modifier.isPrivate(field.getModifiers());
    }
}
