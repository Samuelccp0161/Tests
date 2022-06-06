package sis.studentinfo;


import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
//import java.util.Calendar;
//import java.util.*;
//import java.util.ArrayList;

public class CourseSession{
//    public long getEndDate;
    private String department;
    private String number;
    private java.util.ArrayList<Student> students = new java.util.ArrayList<Student>();
    private Date startDate;
    public static final String NEWLINE = System.getProperty("line.separator");
    private static void incrementCount(){
        ++count;
    }

     private static int count;

    public CourseSession(String department, String number) {
        this.department = department;
        this.number = number;
    }

    public CourseSession(String department, String number, Date startDate){
        this.department = department;
        this.number = number;
        this.startDate = startDate;
        CourseSession.incrementCount();
    }
    public String getDepartment(){
        return department;
    }
    public String getNumber(){
        return number;
    }
    public int getNumberOfStudents(){
        return students.size();
    }
    public void enroll(Student student){
        students.add(student);
    }

    public Student get (int index){
        return students.get(index);
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    private static void incrementCount(){
        count = count + 1;
    }

    public Date getEndDate(){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        final int sessionLength = 16;
        final int daysInWeek = 7;
        final int daysFromFridayToMonday =  3;
        int numberOfDays = sessionLength * daysInWeek    - daysFromFridayToMonday;
        calendar.add(calendar.DAY_OF_YEAR, numberOfDays);
//        Date endDate = calendar.getTime();
        return calendar.getTime();
    }

//    String getRosterReport() {
//        StringBuilder buffer = new StringBuilder();
//        buffer.append(ROSTER_REPORT_HEADER);
//
//        for (Student student : students){
//            buffer.append(student.getName());
//            buffer.append(NEWLINE);
//    }
//
//        buffer.append(ROSTER_REPORT_FOOTER + students.size() + NEWLINE);
//        return buffer.toString();
//    }

    public Date getStartDate(){
        return startDate;
    }

    static int getCount(){
        return count;
    }

    static void resetCount(){
        count = 0;
    }


}

