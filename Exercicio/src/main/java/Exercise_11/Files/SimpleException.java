package Exercise_11.Files;

public class SimpleException extends RuntimeException {
    public SimpleException(Exception e) {
        super(e);
    }
    public SimpleException(String message){
        super(message);
    }
}
