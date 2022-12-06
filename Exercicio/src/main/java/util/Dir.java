package util;

import Exceptions.FileAlreadyExistsException;
import Exercise_11.MyFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Dir {
    File directory;

    public Dir(String path)  {
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
}


