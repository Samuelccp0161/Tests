package Exercise_11.Files;

public class FileNotExistException extends RuntimeException {
    
    public FileNotExistException(String message){
        super(message);
    }
}
