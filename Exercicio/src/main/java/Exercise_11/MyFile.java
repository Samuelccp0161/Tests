package Exercise_11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFile {
    File file;
    public MyFile(String filename){
        this.file = new File(filename);
    }
    public String writer(String talvez) throws FileExistException, IOException {
        Writer writer = null;

        if (file.exists())
            throw new FileExistException("Arquivo já existe");
        try {
            writer = new FileWriter(file);
            writer.write(talvez);
            writer.flush();

            return talvez;
        }
        finally {
            if (writer != null)
                writer.close();
        }
    }
    public String read() throws IOException {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();

        if (!file.exists())
            throw new FileNotExistException("Arquivo não existe");
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
    public void writerLines(List<String> lines) throws IOException {
        Writer writer = null;
        if (file.exists())
            throw new FileExistException("Arquivo já existe");
        try {
            writer = new FileWriter(file);
            writer.write(lines.get(0));
            for (int i = 1; i < lines.size(); i++) {
                writer.write("\n" + lines.get(i));
                writer.flush();
            }
        }finally {
            if (writer != null)
                writer.close();
        }
    }
    public List<String> readLines() throws IOException {
        BufferedReader reader = null;
        List<String> lines = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null){
                lines.add(line);
                line = reader.readLine();
            }
            return lines;
        }finally {
            if (reader != null)
                reader.close();
        }
    }
}
