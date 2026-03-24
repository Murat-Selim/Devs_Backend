package kodlamaio.Devs.core.exceptions;

/**
 * Base exception class for all custom exceptions.
 * Follows Open/Closed Principle - extend for specific exceptions instead of modifying.
 */
public abstract class BaseException extends RuntimeException {
    
    public BaseException(String message) {
        super(message);
    }
    
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}