package sis.SuperClass;

public class SuperClass {
    public static boolean constructorWasCalled = false;
    SuperClass(String parm){
        constructorWasCalled = true;
    }
}
