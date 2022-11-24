package Exercise_11;

import org.junit.*;
import java.io.*;
import static org.junit.Assert.*;

public class TestFileText {

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
    public void testTimeBuffered() throws Exception {

        File file = new File("fofofca.txt");
        writeFile("a", "fofofca.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        Writer writer = new FileWriter("fofofca.txt");

        long timeBuffered = 0;
        long timeWriter = 0;

        for (int i = 1000; i <= 1000000; i *= 10){
            try {
                timeBuffered = escrever(bufferedWriter, i);
                timeWriter = escrever(writer, i);
                if (timeBuffered * 5 <= timeWriter) {
                    System.out.println("i: " + i);
                    break;
                }
            }finally {
                file.delete();
            }
        }

        assertTrue(timeBuffered * 5 <= timeWriter);
        System.out.println("buf: " + timeBuffered + ", wrt: " + timeWriter);
    }
    private long escrever(Writer writer, int quantidade) throws IOException {
        final long start = System.currentTimeMillis();
        for (int i = 0; i < quantidade; i++ ){
            writer.write('i');
        }
        writer.flush();
        final long end = System.currentTimeMillis();
        return end - start;
    }

}