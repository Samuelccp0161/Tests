package Exercise_15;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Dump {

    int order() default 0;
    boolean quote() default false;
    String[] outputMethods() default { };
    String separator() default " ";
}
