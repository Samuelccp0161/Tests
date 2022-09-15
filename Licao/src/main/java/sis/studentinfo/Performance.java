package sis.studentinfo;

public class Performance {
    private int[] tests = {};
    public void set(int testNumber, int score){
        tests[testNumber] = score;
    }
    public int get(int testNumber){
        return tests[testNumber];
    }
    public double average(){
        if (tests.length == 0) {
            return 0.0;
        }
        int total = 0;
        for (int test : tests)
            total += test;
        return (double) total / tests.length;
    }
    public void setNumberOfTests(int numberOfTests){
        tests = new int[numberOfTests];
    }
    public void setScore(int... tests){
        this.tests = tests;
    }
}
