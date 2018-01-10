package queue;

/**
 * @author tufei
 * @date 2018/1/10.
 */

public class EmptyQueueException extends RuntimeException{
    public EmptyQueueException(){
        super("Queue Empty!");
    }
}
