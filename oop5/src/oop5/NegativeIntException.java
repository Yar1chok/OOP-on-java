package oop5;

/**
 * This class throw exception, if param less 0
 */
public class NegativeIntException extends Exception{
    /**
     * Default constructor with description of error
     * @param message - description of error
     */
    public NegativeIntException(String message) {
        super(message);
    }

    /**
     * Default constructor
     */
    public NegativeIntException() {
    }
}
