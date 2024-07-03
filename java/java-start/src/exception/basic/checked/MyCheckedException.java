package exception.basic.checked;

/**
 * Exception inherit -> become check Exception
 */
public class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message);
    }
}
