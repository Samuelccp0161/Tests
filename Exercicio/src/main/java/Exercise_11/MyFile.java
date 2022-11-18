package Exercise_11;

import java.io.*;
import java.util.List;

public class MyFile {
    File file;
    public MyFile(String filename){
        this.file = new File(filename);
    }
    public String read() throws IOException {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
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
    public void writer(String talvez) throws IOException {
        Writer writer = new FileWriter(file);
        writer.write(talvez);
        writer.flush();
    }


    public void writer(List<String> lines) {
    }
}
