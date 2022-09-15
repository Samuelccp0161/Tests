package sis.studentinfo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordGeneratorTest {
    @Test
    public void testGeneratePassword() {
        PasswordGenerator generator = new PasswordGenerator();
        generator.setRandom(new MockRandom('A'));
        assertEquals("ABCDEFGH", generator.generatePassword());
        generator.setRandom(new MockRandom('C'));
        assertEquals("CDEFGHIJ", generator.generatePassword());
    }

}
