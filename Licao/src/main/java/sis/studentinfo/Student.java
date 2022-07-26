package sis.studentinfo;
import java.util.*;
public class Student {

    private ArrayList<Grade> grades = new ArrayList<Grade>();
    private String Name;
    private String firstName =  "";
    private String lastName;
    private String middleName = "";
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
    }
    private List<String> tokenize(String string){
        List<String> results = new ArrayList<String>();

        StringBuffer word = new StringBuffer();
        int index = 0;
        while (index < string.length()){
            char ch = string.charAt(index);
            if (ch != ' ')
                word.append(ch);
            else
                if (word.length() > 0){
                    results.add(word.toString());
                    word = new StringBuffer();
                }
                index++;
        }
        if (word.length() > 0)
            results.add(word.toString());
        return results;
    }

    private List<String> split(String name){
        List<String> results = new ArrayList<String>();
        StringBuffer word = new StringBuffer();
        for (int index = 0; index < name.length(); index++) {
            char ch = name.charAt(index);
            if(!Character.isWhitespace(ch))
                word.append(ch);
            else
                if (word.length() > 0){
                    results.add(word.toString());
                    word = new StringBuffer();
                }
        }
        if (word.length() > 0)
            results.add(word.toString());
        return results;
    }
    public static boolean isPalindrome(String string){
        for (int forward = 0, backward = string.length() -1;
             forward < string.length();
             forward++, backward--)
          if (string.charAt(forward) != string.charAt(backward))
            return false;
        return true;
    }
    private int fib(int x){
        if(x==0) return 0;
        if(x==1) return 1;

        int fib = 0;
        int nextFib = 1;
        int index = 0;
        int temp;

        do{
            temp = fib+nextFib;
            fib = nextFib;
            nextFib = temp;
        } while (++index < x);
        return fib;
    }


//    public static int countChars(String input, char ch){
//       int count;
//        for (int i = 0, count = 0; i < input.length(); i++)
//            if (input.charAt(i) == ch)
//                count++;
//        return count;
//    }
    public Student(String fullName){
    this.Name = fullName;
    credits = 0;
    List<String> nameParts = split(fullName);
    setName(nameParts);
    }

    private void setName(List<String> nameParts){

        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);

        if(nameParts.isEmpty())
            this.firstName = name;
        else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }
    private String removeLast(List<String> list){
        if(list.isEmpty())
            return "";
        return list.remove(list.size() -1);
    }

    public String getName(){
    return Name;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getMiddleName(){
        return middleName;
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


