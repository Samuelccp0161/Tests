package Exercise_11;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
        }finally {
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
    public void testWriterLines(){
        String fileName = "filename.txt";
        MyFile myFile = new MyFile(fileName);
        List<String> lines = new ArrayList<>();
        lines.add("haha");
        lines.add("oi");
        lines.add("hi");
        try {
            myFile.writer(lines);
            assertEquals("haha\noi\nhi", read(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            File file = new File(fileName);
            file.delete();
        }
    }
}
