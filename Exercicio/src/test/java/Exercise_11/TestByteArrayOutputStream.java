package Exercise_11;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertTrue;

public class TestByteArrayOutputStream {
    @Test
    public void testByteArrayOne() throws IOException {
        try {
            blowup();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            ByteArrayOutputStream capturedTrace = getTrace(e);

            String st = capturedTrace.toString();

            for (var trace : stackTrace) {
                assertTrue(st.contains(trace.toString()));
            }
        }
    }
    @Test
    public void testByteArrayCharacter() throws IOException {
        try {
            blowup();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            ByteArrayOutputStream capturedTrace = getTraceCharacter(e);

            String st = capturedTrace.toString();

            for (var trace : stackTrace) {
                assertTrue(st.contains(trace.toString()));
            }
        }
    }
    private ByteArrayOutputStream getTrace(Exception e) throws IOException {
        StackTraceElement[] stack = e.getStackTrace();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedOutputStream writer = new BufferedOutputStream(outputStream);

        for (StackTraceElement s : stack)
            writer.write(s.toString().getBytes());

        writer.flush();

        return  outputStream;
    }
    private ByteArrayOutputStream getTraceCharacter(Exception e) throws IOException {
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        for (StackTraceElement s : stackTraceElements){
            writer.write(s.toString());
            writer.flush();
        }
        return outputStream;
    }
    private void blowup() {
        throw new NullPointerException();
    }
}
