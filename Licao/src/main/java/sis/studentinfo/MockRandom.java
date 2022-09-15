package sis.studentinfo;

import java.util.Random;

public class MockRandom extends Random {
    private int i;
    MockRandom(char startCharValue) {
        i = startCharValue - PasswordGenerator.LOW_END_PASSWORD_CHAR;
    }
    protected int next(int bits) {
        return i++;
    }
}

