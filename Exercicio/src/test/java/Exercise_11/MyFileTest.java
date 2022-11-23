package Exercise_11;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyFileTest {
    @Test
    public void testWriter() throws IOException {
        String fileName = "filename.txt";
        MyFile myFile = new MyFile(fileName);
        try {
            myFile.writer("haha\noi");
            assertEquals("haha\noi", read(fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            File file = new File(fileName);
            file.delete();
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
    public void testWriterLines() {
        String fileName = "filename.txt";
        MyFile myFile = new MyFile(fileName);
        List<String> lines = new ArrayList<>();
        lines.add("haha");
        lines.add("oi");
        lines.add("hi");
        try {
            myFile.writerLines(lines);
            assertEquals("haha\noi\nhi", read(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            File file = new File(fileName);
            file.delete();
        }
    }
    @Test
    public void readTestLines() throws IOException {
        String fileName = "filename.txt";
        MyFile myFile = new MyFile(fileName);
        List<String> lines = new ArrayList<>();
        lines.add("haha");
        lines.add("oi");
        lines.add("hi");
        try {
            myFile.writerLines(lines);
            assertEquals(lines, myFile.readLines());
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            File file = new File(fileName);
            file.delete();
        }
    }
    //ele quer que eu jogue uma exceção se o arquivo ja existir (writer)
    //ele quer que eu jogue uma exceção se o arquio não existir (read)

}
