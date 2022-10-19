package sis.db;

import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.RandomAccess;

public class DataFile {
    public static final String DATA_EXT = ".db";
    public static final String KEY_EXT = ".idx";
    private String dataFilename;
    private String KeyFilename;
    private RandomAccess db;
    private KeyFile Keys;

    public static DataFile create(String filebase) throws IOException{
        return new DataFile(filebase, true);
    }
    public static DataFile open(String filebase) throws IOException{
        return new DataFile(filebase, false);
    }
    public void add(String key, Object object) throws IOException{
        long position = db.length();

        byte[] bytes = getBytes(object);
        db.seek(position);
        db.write(bytes, 0, bytes.length);
        keys.add(key, position, bytes.length);
    }
    public Object findBy(String id) throws IOException{
        if(!keys.containsKey(id))
            return null;

        long position = keys.getPosition(id);
        db.seek(position);

        int length = keys.getLenght(id);
        return read(length);
    }
    public int size(){
        return keys.size();
    }
    public void close() throws IOException{
        keys.close();
        db.close();
    }
    public void deleteFiles(){
        IOUtil.delete(dataFilename, keyFilename);
    }
    private Object read(int length) throws IOException{
        byte[] bytes = new byte[length];
        db.readFully(bytes);
        return readObject(bytes);
    }
    private Object readObject(byte[] bytes) throws IOException{
        ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(bytes));
        try {
            try {
                return input.readObject();
            }
            catch (ClassNotFoundException unlikely){
                return null;
            }
        }finally {
            input.close();
        }
    }
    private void openFiles() throws IOException{
        keys = new KeyFile(keyFilename);
        db = new RandomAccessFile(new File(dataFilename), "rw");
    }
    private byte[] getBytes(Object object) throws IOException{
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectInputStream outputStream = new ObjectInputStream(byteStream);
        outputStream.writeObject(object);
        outputStream.flush();
        return  byteStream.toByteArray();
    }

}
