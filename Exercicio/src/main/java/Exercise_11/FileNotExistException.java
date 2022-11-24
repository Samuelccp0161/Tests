package Exercise_11;

public class FileNotExistException extends RuntimeException {
    
    public FileNotExistException(String message){
        super(message);
    }
}
