package sis.studentinfo;


import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
//import java.util.Calendar;
//import java.util.*;
//import java.util.ArrayList;

public class CourseSession extends Session  {
//    public long getEndDate;

    public Date startDate;
    public static final String NEWLINE = System.getProperty("line.separator");

    public int compareTo(CourseSession that) {
        int compare =
            this.getDepartment().compareTo(that.getDepartment());
        if (compare == 0)
            compare =
            this.getNumber().compareTo(that.getNumber());
        return compare;
    }
     private static int count;

    public static CourseSession create(
        String department,
        String number,
        Date startDate) {
        incrementCount();
        return new CourseSession(department, number, startDate);
    }

    public CourseSession(String department, String number, Date startDate){
       super(department, number, startDate);
    }
    protected int getSessionLength(){
        return 16; }

    private static void incrementCount(){
        ++count;
    }

    public Date getEndDate(){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getStartDate());
        final int sessionLength = 16;
        final int daysInWeek = 7;
        final int daysFromFridayToMonday =  3;
        int numberOfDays = getSessionLength() * daysInWeek    - daysFromFridayToMonday;
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

    static int getCount(){
        return count;
    }

    static void resetCount(){
        count = 0;
    }


}

