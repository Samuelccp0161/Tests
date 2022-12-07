package Exercise_11;

import Exceptions.FileAlreadyExistsException;
import Exceptions.Format;
import Exceptions.SimpleException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Dir;

import java.io.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class TestDir {
    final String filename = "filename";
    Dir dir;

    @Before
    public void setUp() throws Exception {
        dir = new Dir(filename);
    }
    @After
    public void deleteFiles() {
        dir.delete();
    }

    @Test
    public void dirTest() throws IOException {
        final File directory = new File(filename);
        assertFalse(directory.exists());

        dir.ensureExists();

        assertTrue(directory.exists());
        assertTrue(directory.isDirectory());

        dir.ensureExists();

        assertTrue(directory.exists());
        assertTrue(directory.isDirectory());
    }

    @Test
    public void dirException() throws IOException {
        File file = new File(filename);
        assertTrue(file.createNewFile());

        try {
            dir.ensureExists();
            fail();
        } catch (FileAlreadyExistsException ignore) {
        }
    }

    @Test
    public void testListFilesOneFile() throws IOException {
        final String filename1 = filename + "/file";

        dir.ensureExists();

        MyFile file = new MyFile(filename1);
        file.write("123456");

        List<MyFile> files = dir.listFiles();

        assertEquals(1, files.size());
        assertEquals(file.read(), files.get(0).read());
    }

    @Test
    public void testListFiles() throws IOException {
        final String[] filenames = {filename + "/file1", filename + "/file2", filename + "/file3"};
        dir.ensureExists();

        assertEquals(0, dir.listFiles().size());

        for (String path : filenames) {
            MyFile file = new MyFile(path);
            file.write(path);
        }

        List<MyFile> files = dir.listFiles();

        assertEquals(filenames.length, files.size());
        for (int i = 0; i < files.size(); i++) {
            assertEquals(filenames[i], files.get(i).read());
        }
    }

    @Test
    public void testDelete() throws IOException {
        final String[] filenames = {filename + "/file1", filename + "/file2", filename + "/file3"};
        dir.ensureExists();

        for (String path : filenames) {
            MyFile file = new MyFile(path);
            file.write(path);
        }

        dir.delete();

        assertFalse(new File(filename).exists());
    }

}
