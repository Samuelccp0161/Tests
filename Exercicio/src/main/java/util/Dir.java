package util;

import Exceptions.FileAlreadyExistsException;
import Exercise_11.FileNotExistException;
import Exercise_11.MyFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dir {
    File file;
    final String filename = "file";

    public Dir(String path)  {
        this.file = new File(path);
    }
    public void ensureExists()  {
        if (!file.exists()) {
            file.mkdir();
        } else if (file.isFile())  {
            throw new FileAlreadyExistsException();
        }
    }

    public List<MyFile> listFiles() throws IOException{
        List<MyFile> listFiles = new ArrayList<>();


//        listFiles.add(myFile);
            MyFile myFile = new MyFile(filename);
            listFiles.add(myFile);



        return listFiles;
    }
}


