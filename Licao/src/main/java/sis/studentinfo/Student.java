package sis.studentinfo;

import java.util.*;
import java.util.logging.Logger;

public class Student {
    private final ArrayList<Grade> grades = new ArrayList<>();
    private final String Name;
    private int settings = 0x0;
    private String id;
    private String firstName =  "";
    private String lastName;
    private String middleName = "";
    private int credits;
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";
    private String state = "";
    static final int MAX_NAME_PARTS = 3;
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    static final String TOO_MANY_NAME_PARTS_MSG = "Student name '%s' contains more than %d parts";
    void setGradingStrategy(GradingStrategy gradingStrategy){
        this.gradingStrategy = gradingStrategy;
    }
    void addGrade(Grade grade){
        grades.add(grade);
    }
    public enum Grade{
        A(4),
        B(3),
        C(2),
        D(1),
        F(0);
        private final int points;
        Grade(int points) {
                this.points = points;
            }
            int getPoints(){
                return points;
        }
    }
    private List<String> tokenize(String string){
        List<String> results = new ArrayList<>();

        StringBuilder word = new StringBuilder();
        int index = 0;
        while (index < string.length()){
            char ch = string.charAt(index);
            if (ch != ' ')
                word.append(ch);
            else
                if (word.length() > 0){
                    results.add(word.toString());
                    word = new StringBuilder();
                }
                index++;
        }
        if (word.length() > 0)
            results.add(word.toString());
        return results;
    }
    private List<String> split(String fullName){
        List<String> results = new ArrayList<>(List.of(fullName.split(" ")));
        return results;
    }
    public static boolean isPalindrome(String string){
        if(string.length() == 0)
            return true;
        int limit = string.length() / 2;
        for (int forward = 0, backward = string.length() -1;
             forward < limit;
             forward++, backward--)
          if (string.charAt(forward) != string.charAt(backward))
            return false;
        return true;
    }
    public static int fib(int x){
        if(x==0) return 0;
        if(x==1) return 1;
        return fib(x - 1) + fib(x - 2);
    }
    public Student(String fullName){
    this.Name = fullName;
    credits = 0;
    List<String> nameParts = split(fullName);
    final int maximumNumberOfNameParts = 3;
    if (nameParts.size() > maximumNumberOfNameParts){
        String message = String.format(Student.TOO_MANY_NAME_PARTS_MSG, fullName, MAX_NAME_PARTS);
        Student.logger.info(message);
        throw new StudentNameFormatExeption(message);

    }
    setName(nameParts);
    }
    final static Logger logger = Logger.getLogger(Student.class.getName());
    private void log(String message){
        Logger logger = Logger.getLogger(getClass().getName());
        logger.info(message);
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
        Student.logger.fine("begin getGpa " + System.currentTimeMillis());
        if (grades.isEmpty())
            return 0.0;
        double total = 0.0;

        for (Grade grade: grades)
            total += gradingStrategy.getGradePointsFor(grade);
        Student.logger.fine("end getGpa " + System.currentTimeMillis());
        return total / grades.size();
    }
    public static String sequenceUsingDo(int start, int stop){
        StringBuilder builder = new StringBuilder();
        int i = start;
        do{
            if(i > start)
                builder.append(',');
            builder.append(i);
        } while (++i <= stop);
        return builder.toString();
    }
    public static String sequenceUsingFor(int start, int stop){
        StringBuilder builder = new StringBuilder();
        int i = start;
        while (i <= stop){
            if(i > start)
                builder.append(',');
            builder.append(i);
            i++;
        }
        return builder.toString();
    }
    public static String sequenceUsingWhile(int start, int stop){
        StringBuilder builder= new StringBuilder();
        int i = start;
        while (i <= stop){
            if(i > start)
                builder.append(',');
            builder.append(i);
            i++;
        }
        return builder.toString();
    }
    public static String endTrim(String source){
        int i = source.length();
        while (--i >= 0)
            if(source.charAt(i) != ' ')
                break;
        return source.substring(0, i + 1);
    }
    public String getId(){
        return id;
    }
    public enum Flag {
        ON_CAMPUS(1),
        TAX_EXEMPT(2),
        MINOR(4),
        TROUBLEMAKER(8);
        private int mask;Flag(int mask) {
            this.mask = mask;
        }
    }
    public void set(Flag... flags) {
        for (Flag flag: flags)
            settings |= flag.mask;
    }
    public void unset(Flag... flags) {
        for (Flag flag: flags)
            settings &= ~flag.mask;
    }
    public boolean isOn(Flag flag) {
        return (settings & flag.mask) == flag.mask;
    }
    public boolean isOff(Flag flag) {
        return !isOn(flag);
    }
}