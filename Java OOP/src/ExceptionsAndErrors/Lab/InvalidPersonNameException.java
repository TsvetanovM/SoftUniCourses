package ExceptionsAndErrors.Lab;

public class InvalidPersonNameException extends RuntimeException{
    public InvalidPersonNameException(String message) {
        super(message);
    }
}
