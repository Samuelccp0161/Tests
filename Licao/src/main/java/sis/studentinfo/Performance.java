package sis.studentinfo;

public class Performance {
    private int[] tests;
    public void set(int testNumber, int score){
        tests[testNumber] = score;
    }
    public int get(int testNumber){
        return tests[testNumber];
    }

    public double average(){
        double total = 0.0;
        for(int i =0; i < tests.length; i++)
            total += tests[i];
        return total / tests.length;
    }
    public void setNumberOfTests(int numberOfTests){
        tests = new int[numberOfTests];
    }
    public void setScore(int... tests){
        this.tests = tests;
    }


}
