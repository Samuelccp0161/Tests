package sis.studentinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CourseSession extends Session  {
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
        final int daysInWeek = 7;
        final int daysFromFridayToMonday =  3;
        int numberOfDays = getSessionLength() * daysInWeek    - daysFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
//        Date endDate = calendar.getTime();
        return calendar.getTime();
    }
    static int getCount(){
        return count;
    }
    static void resetCount(){
        count = 0;
    }


}

