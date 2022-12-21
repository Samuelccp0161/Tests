package Exercise_11;

import org.junit.Test;

import java.io.*;

public class TestSerializeObject {

    @Test
    public void testSerializeObject() throws IOException {
        File file = new File("filename");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject();
    }
}
