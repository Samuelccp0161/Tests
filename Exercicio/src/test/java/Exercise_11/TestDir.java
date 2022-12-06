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
    File file;

    @After
    public void deleteFiles() {
        File file = new File(filename);
        if (file.exists()) {
            assertTrue(file.delete());
        }
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
    public void testListFilesOneFile() throws IOException {
        final String filename1 = filename + "/file";
        try {
            Dir dir = new Dir(filename);
            dir.ensureExists();

            MyFile file = new MyFile(filename1);
            file.write("123456");

            List<MyFile> files = dir.listFiles();
//        System.out.println(files.get(0).read());

            assertEquals(1, files.size());
            assertEquals(file.read(), files.get(0).read());
        } finally {
            final File file = new File(filename1);
            if (file.exists())
                assertTrue(file.delete());

        }
    }

    @Test
    public void testListFiles() throws IOException {
        final String[] filenames = {filename + "/file1", filename + "/file2", filename + "/file3"};
        try {
            Dir dir = new Dir(filename);
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
        } finally {
            for (String filename : filenames) {
                File file = new File(filename);
                if (file.exists())
                    assertTrue(file.delete());
            }

        }
    }

    @Test
    public void testDelete() throws IOException {
        final String[] filenames = {filename + "/file1", filename + "/file2", filename + "/file3"};
        try {
            Dir dir = new Dir(filename);
            dir.ensureExists();

            for (String path : filenames) {
                MyFile file = new MyFile(path);
                file.write(path);
            }

            dir.delete();

            assertFalse(new File(filename).exists());
        } finally {

        }
    }
}
