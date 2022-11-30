package util;

import Exceptions.FileAlreadyExistsException;
import Exercise_11.MyFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dir {
    File file;
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

    public List<MyFile> listFiles(){
        List<MyFile> files = new ArrayList<>();

        return null;
    }
}


