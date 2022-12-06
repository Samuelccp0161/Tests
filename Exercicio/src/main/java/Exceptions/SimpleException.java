package Exceptions;

public class SimpleException extends RuntimeException {
    public SimpleException(Exception e) {
        super(e);
    }
    public SimpleException(String message){
        super(message);
    }
}
