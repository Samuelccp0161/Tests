package sis.testing;

import java.util.*;

public class SuiteBuilder {
    public List<String> gatherTestClassNames(){
        TestCollector collector = new ClassPathTestCollector(){
            protected boolean isTestClass(String classFileName){
                if (!super.isTestClass(classFileName))
                    return false;
                String className = classNameFromFile(classFileName);
                class klass = createClass(className);
                return TestCase.class.isAssignableFrom(klass);
            }
        };
        return Collections.list(collector.collectTest());
    }
    private Class createClass(String name){
        try {
            return Class.forName(name);
        }catch (ClassNotFoundException e){
            return null;
        }
    }

}
