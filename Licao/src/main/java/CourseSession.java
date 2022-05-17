import java.util.Date;
import java.util.GregorianCalendar;

public class CourseSession{
    public long getEndDate;
    private String department;
    private String number;
    private java.util.ArrayList<Student> students = new java.util.ArrayList<Student>();
    private Date startDate;

    CourseSession(String department, String number) {
        this.department = department;
        this.number = number;

    }

    CourseSession(String department, String number, Date startDate){
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }
    String getDepartment(){

        return department;
    }
    String getNumber(){

        return number;
    }
    int getNumberOfStudents(){

        return students.size();
    }
    void enroll(Student student){

        students.add(student);
    }

    Student get (int index){
        return students.get(index);
    }

    Date getEndDate(){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int numberOfDays = 16 * 7 - 3;
        calendar.add(calendar.DAY_OF_YEAR, numberOfDays);
        Date endDate = calendar.getTime();
        return endDate;
    }

    Date getStartDate(){
        return startDate;
    }

}

