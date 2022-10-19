package sis.studentinfo;

import java.io.IOException;
import java.util.*;

public class StudentDirectory {
    private static final String DIR_BASENAME = "studentDir";
    private DataFile db;
    private Map<String, Student> students = new HashMap<String, Student>();
    public StudentDirectory() throws IOException{
        db = DataFile.open(DIR_BASENAME);
    }
    public void add(Student student){
        db.add(student.getId(), student);
    }
    public Student findById(String id){
        return (Student)db.findBy(id);
    }
    public void remove(){
        db.deleteFiles();
    }
}
