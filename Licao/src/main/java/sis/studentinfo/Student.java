package sis.studentinfo;

public class Student {

    private String Name;
    private int credits;
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";
    private String state = "";

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
}


