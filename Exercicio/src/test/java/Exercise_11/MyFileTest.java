package Exercise_11;

import org.junit.After;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MyFileTest {
    final String filename = "filename.txt";
    @After
    public void tearDown() throws Exception {
        File file = new File(filename);

        if (file.exists())
            assertTrue(file.delete());
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
        myFile.writer("haha\noi");
        assertEquals("haha\noi", read(filename));

    }
    @Test
    public void testRead() throws IOException {
        MyFile myFile = new MyFile(filename);

        myFile.writer("haha" + "\n" + "oi");
        assertEquals("haha" + "\n" + "oi",myFile.read());
    }
    @Test
    public void testWriterLines() throws IOException{
        MyFile myFile = new MyFile(filename);
        List<String> lines = new ArrayList<>();
        lines.add("haha");
        lines.add("oi");
        lines.add("hi");

        myFile.writerLines(lines);
        assertEquals("haha\noi\nhi", read(filename));
    }
    @Test
    public void testReadLines() throws IOException {
        MyFile myFile = new MyFile(filename);
        List<String> lines = new ArrayList<>();
        lines.add("haha");
        lines.add("oi");
        lines.add("hi");

        myFile.writerLines(lines);
        assertEquals(lines, myFile.readLines());
    }
    @Test
    public void testWriterException() throws IOException{
        MyFile myFile = new MyFile(filename);
        myFile.writer("haha\noi");
        try {
            myFile.writer("haha\noi");
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
        myFile.writerLines(lines);
        try {
            assertEquals("haha\noi\nhi", read(filename));
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
        myFile.writerLines(lines);
        try {
            assertEquals(lines, myFile.readLines());
        }catch (FileNotExistException exception){
        }
    }
    @Test
    public void testOverwrite(){
        MyFile myFile = new MyFile(filename);



    }
    //eu tenho que fazer um método para que ele escreva mesmo ja existindo um arquivo (writer);
    //eu tenho que fazer um método para que ele escreva uma lista mesmo ja existindo um arquivo (writer);

}
