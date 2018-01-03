package linkedlist;

/**
 * @author tufei
 * @date 2018/1/2.
 */
public class LinkedList<T> {
    private LinkedList<T> next;
    private T data;

    public LinkedList<T> getNext() {
        return next;
    }

    public void setNext(LinkedList<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
