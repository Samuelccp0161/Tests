package Exercise_11;

import Exceptions.BlowsUpTest;
import org.junit.After;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class TestFileText {

    @After
    public void tearDown() throws Exception {

    }

    public void writeFile(String text, String filename) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename);
            writer.write(text);
            writer.flush();
        } finally {
            if (writer != null)
                writer.close();
        }
    }

    public String read(String filename) throws IOException {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(filename));
            while (true) {
                int ch = reader.read();
                if (ch == -1) {
                    break;
                }
                builder.append((char) ch);
            }
            return builder.toString();
        } finally {
            if (reader != null)
                reader.close();

        }
    }

    @Test
    public void testFileText() throws IOException {
        String filename = "text.txt";
        String text = "1. Create a test to write the text of this exercise to the file system. The test should read the\n" +
                "fiteFile(String ile back in and make assertions about the content. Ensure that you can run the test\n" +
                "multiple times and have it pass. Finally, make sure that there are no leftover files when the\n" +
                "test finishes, even if an exception is thrown.";
        try {
            writeFile(text, filename);
            assertEquals(text, read(filename));
        } finally {
            File file = new File(filename);
            file.delete();
        }

    }
    @Test
    public void testTimeBuffered() throws Exception {

        File file = new File("fofofca.txt");
        writeFile("a", "fofofca.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        Writer writer = new FileWriter("fofofca.txt");

        for (int i = 0; i <= 3000; i++){
            escrever(bufferedWriter);
            escrever(writer);
        }

        assertNotEquals(bufferedWriter, writer);
    }
    private String escrever(Writer writer) throws IOException {
        for (int i = 0; i <= 10; i++ ){
            writer.write("a");
        }
        return writer.toString();
    }
}