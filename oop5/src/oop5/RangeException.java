package oop5;

/**
 * This class throw exception, if going beyond the edges
 */
public class RangeException extends Exception{
    /**
     * Default constructor with description of error
     * @param message - description of error
     */
    public RangeException(String message) {
        super(message);
    }

    /**
     * Default constructor
     */
    public RangeException() {
    }
}
