package queue;

/**
 * @author tufei
 * @date 2018/1/10.
 */

public class QueueOverflowException extends RuntimeException{
    public QueueOverflowException(){
        super("Queue Overflow!");
    }
}
