package linkedlist;

/**
 * @author tufei
 * @date 2018/1/2.
 */
class LinkedList {
    private LinkedList next;
    private int data;

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
