package sis.studentinfo;
import java.util.*;
public class Student {

    private ArrayList<Grade> grades = new ArrayList<Grade>();
    private String Name;
    private int credits;
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";
    private String state = "";
    private boolean isHonors = false;
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();

    void setGradingStrategy(GradingStrategy gradingStrategy){
        this.gradingStrategy = gradingStrategy;
    }

    void setHonors(){
        isHonors = true;
    }

    void addGrade(Grade grade){
        grades.add(grade);
    }
    public static enum Grade{
        A(4),
        B(3),
        C(2),
        D(1),
        F(0);
        private int points;
        Grade(int points) {
                this.points = points;
            }
            int getPoints(){
                return points;
        }
    };
     public Student(String Name){
        this.Name = Name;
    }

     public String getName(){
        return Name;
    }

    boolean isFullTime(){
         return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    int getCredits(){
         return credits;
    }
    void addCredits(int credits){
         this.credits += credits;
    }

    void setState(String state){
         this.state = state;
    }
    boolean isInState(){
         return state.equals(Student.IN_STATE);
    }

    double getGpa(){
        if (grades.isEmpty())
            return 0.0;
        double total = 0.0;

        for (Grade grade: grades)
        total += gradingStrategy.getGradePointsFor(grade);
        return total / grades.size();
    }
//    int gradePointsFor(Grade grade) {
//        return gradingStrategy.getGradePointsFor(grade);
//    }
//    private int basicGradePointsFor(Grade grade){
//        if (grade == Student.Grade.A) return 4;
//        if (grade == Student.Grade.B) return 3;
//        if (grade == Student.Grade.C) return 2;
//        if (grade == Student.Grade.D) return 1;
//        return 0;
//    }
//    double gradePointsFor(Grade grade){
//         if(isSenatorsSon){
//             if (grade == Grade.A) return 4;
//             if (grade == Grade.B) return 4;
//             if (grade == Grade.C) return 4;
//             if (grade == Grade.D) return 4;
//             return 3;
//         }
//         else {
//             double points = basicGradePointsFor(grade);
//             if (isHonors)
//                 if(points > 0)
//                     points += 1;
//             return points;
//         }
//    }


}


