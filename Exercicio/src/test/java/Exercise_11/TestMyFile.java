package Exercise_11;

import org.junit.After;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestMyFile {
    final String filename = "filename.txt";
    @After
    public void tearDown() throws Exception {

    }
    private String read(String filename) throws IOException {
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
    public void testWriter() throws IOException, FileExistException {
        MyFile myFile = new MyFile(filename);
        myFile.write("haha\noi");
        assertEquals("haha\noi", read(filename));

    }
    @Test
    public void testRead() throws IOException {
        MyFile myFile = new MyFile(filename);

        myFile.write("haha" + "\n" + "oi");
        assertEquals("haha" + "\n" + "oi",myFile.read());
    }
    @Test
    public void testWriterLines() throws IOException{
        MyFile myFile = new MyFile(filename);
        List<String> lines = new ArrayList<>();
        lines.add("haha");
        lines.add("oi");
        lines.add("hi");

        myFile.writeLines(lines);
        assertEquals("haha\noi\nhi", read(filename));
    }
    @Test
    public void testReadLines() throws IOException {
        MyFile myFile = new MyFile(filename);
        List<String> lines = new ArrayList<>();
        lines.add("haha");
        lines.add("oi");
        lines.add("hi");

        myFile.writeLines(lines);
        assertEquals(lines, myFile.readLines());
    }
    @Test
    public void testWriterException() throws IOException{
        MyFile myFile = new MyFile(filename);
        myFile.write("haha\noi");
        try {
            myFile.write("haha\noi");
            fail();
        } catch (FileExistException exception) {
        }
    }
    @Test
    public void testReadException() throws IOException{
        MyFile myFile = new MyFile(filename);
        try {
            myFile.read();
            fail();
        }catch (FileNotExistException exception){
        }
    }
    @Test
    public void testWriterLinesException() throws IOException{
        MyFile myFile = new MyFile(filename);
        List<String> lines = new ArrayList<>();
        lines.add("haha");
        lines.add("oi");
        lines.add("hi");
        myFile.writeLines(lines);
        try {
            assertEquals("haha\noi\nhi", read(filename));
            System.out.println(read(filename));
        }catch (FileExistException exception){
        }
    }
    @Test
    public void testReadLinesException() throws IOException{
        MyFile myFile = new MyFile(filename);
        List<String> lines = new ArrayList<>();
        lines.add("haha");
        lines.add("oi");
        lines.add("hi");
        myFile.writeLines(lines);
        try {
            assertEquals(lines, myFile.readLines());
        }catch (FileNotExistException exception){
        }
    }
    @Test
    public void testOverwrite() throws IOException {
        MyFile myFile = new MyFile(filename);

        myFile.write("asd\nfgh");
        myFile.overwrite("ssd\nyuou");

        assertEquals("ssd\nyuou", myFile.read());
    }
    @Test
    public void testOverwriteLines() throws IOException {
        MyFile myFile = new MyFile(filename);
        List<String> lines = new ArrayList<>();

        lines.add("Alexandre");
        lines.add("Jesus");
        myFile.writeLines(lines);

        lines.add("Samuel");
        lines.add("Cabral");
        myFile.overwriteLines(lines);

        assertEquals(lines, myFile.readLines());

    }

    @Test
    public void testDelete() throws IOException {
        MyFile myFile = new MyFile(filename);
        myFile.write("12345");

        myFile.delete();

        assertFalse(new File(filename).exists());
    }
}
