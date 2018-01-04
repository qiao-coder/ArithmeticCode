package linkedlist;

/**
 * @author tufei
 * @date 2018/1/2.
 */
public class ListNode<T> {
    private ListNode<T> next;
    private T data;

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
