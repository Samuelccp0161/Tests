package Exercise_11;

import java.io.*;

public class CloneObject {


    public static Object cloneObject(Object object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        ObjectOutputStream writer = new ObjectOutputStream(output);
        writer.writeObject(object);

        ObjectInputStream reader = new ObjectInputStream(new ByteArrayInputStream(output.toByteArray()));
        return reader.readObject();
    }
}
