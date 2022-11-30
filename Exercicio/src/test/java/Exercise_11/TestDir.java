package Exercise_11;

import Exceptions.FileAlreadyExistsException;
import org.junit.After;
import org.junit.Test;
import util.Dir;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class TestDir {
    final String filename = "filename";

    @After
    public void deleteFiles() {
        File file = new File(filename);
        if (file.exists())
            assertTrue(file.delete());
    }

    @Test
    public void dirTest() throws IOException {
        final File directory = new File(filename);
        assertFalse(directory.exists());

        Dir dir = new Dir(filename);
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

        Dir dir = new Dir(filename);
        try {
            dir.ensureExists();
            fail();
        } catch (FileAlreadyExistsException ignore) {
        }
    }

    @Test
    public void testListFiles() throws IOException {
        Dir dir = new Dir(filename);
        dir.ensureExists();

        MyFile file = new MyFile(filename + "/file");
        file.write("123456");

        List<MyFile> files = dir.listFiles();

        assertEquals(1, files.size());
        assertEquals(file.read(), files.get(0).read());
    }
}
