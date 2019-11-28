package src.exceptions;

public class NodeNotFoundException extends RuntimeException {

    public NodeNotFoundException() {
    }
    
    public NodeNotFoundException(String message) {
        super(message);
    }    
}
