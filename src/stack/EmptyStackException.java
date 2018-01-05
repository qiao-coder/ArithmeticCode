package stack;

/**
 * @author tufei
 * @date 2018/1/5.
 */

public class EmptyStackException extends RuntimeException {
    public EmptyStackException() {
        this("Stack is empty!");
    }

    public EmptyStackException(String message) {
        super(message);
    }
}
