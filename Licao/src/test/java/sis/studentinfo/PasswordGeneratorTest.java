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

/*
BigDecimal a = new BigDecimal("1")
BigDecimal b = new BigDecimal("2")

BigDecimal c = a.add(b)

a == 1
b == 2
c == 3
 */