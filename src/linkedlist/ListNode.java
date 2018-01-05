package linkedlist;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        List<T> list = new ArrayList<>();
        ListNode<T> listNode = this;
        while (listNode != null) {
            list.add(listNode.getData());
            listNode = listNode.getNext();
        }
        return list.size() <= 0 ? null : list.toString();
    }

    public static void main(String[] args) {
        ListNode<Integer> listNode = new ListNode<>();
        listNode.setData(1);
        ListNode<Integer> head = listNode;
        for(int i = 2;i<6;i++){
            head.setNext(new ListNode<>());
            head.getNext().setData(i);
            head = head.getNext();
        }
        System.out.println(listNode);
    }
}/*Output
[1, 2, 3, 4, 5]
*/
