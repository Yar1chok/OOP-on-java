package oop5;

/**
 * This class throw exception, if param is empty
 */
public class EmptyException extends Exception{
    /**
     * Default constructor with description of error
     * @param message - description of error
     */
    public EmptyException(String message) {
        super(message);
    }

    /**
     * Default constructor
     */
    public EmptyException() {
    }
}
