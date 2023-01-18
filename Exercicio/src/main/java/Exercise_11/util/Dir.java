package Exercise_11.util;

import Exercise_11.Files.FileAlreadyExistsException;
import Exercise_11.Files.MyFile;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dir {
    File directory;
    String path;
    public Dir(String path)  {
        this.path = path;
        this.directory = new File(path);
    }
    public void ensureExists()  {
        if (!directory.exists()) {
            directory.mkdir();
        } else if (directory.isFile())  {
            throw new FileAlreadyExistsException();
        }
    }

    public List<MyFile> listFiles() throws IOException{
        List<MyFile> listFiles = new ArrayList<>();
        File[] files = directory.listFiles();

        for (File file : files) {
            MyFile myFile = new MyFile(file.getPath());
            listFiles.add(myFile);
        }
        return listFiles;
    }
    public void delete(){
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                file.delete();
            }
        }
        directory.delete();
    }

    public Attributes attributes(Dir dir){
        Attributes atr = new Attributes(dir);
        return atr;
    }
    public static class Attributes {
        private final boolean isReadOnly;
        private final boolean isHidden;
        public boolean isReadOnly(){
            return isReadOnly;
        }
        public boolean isHidden() {
            return isHidden;
        }
        private Attributes(Dir dir){
            isReadOnly = !dir.directory.canWrite() && dir.directory.canRead();
            isHidden = dir.directory.isHidden();
        }
    }

}


