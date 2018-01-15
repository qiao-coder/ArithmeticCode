package queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import linkedlist.ListNode;

/**
 * 队列：基于链表的实现
 *
 * @author tufei
 * @date 2018/1/10.
 */

public class Queue<T> {

    private int size = 0;
    private ListNode<T> head;
    private ListNode<T> end;

    public void enQueue(T data) {
        ListNode<T> newEnd = new ListNode<>();
        newEnd.setData(data);
        if (isEmpty()) {
            head = end = newEnd;
        } else {
            end.setNext(newEnd);
            end = newEnd;
        }
        size++;
    }

    public T deQueue() {
        T temp = null;
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            temp = head.getData();
            if (size == 1) {
                head = end = null;
            } else {
                ListNode<T> next = head.getNext();
                head = next;
            }
            size--;
        }
        return temp;
    }

    public T front() {
        if (isEmpty()) {
            return null;
        }
        return head.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return null;
        }
        List<T> list = new ArrayList<>();
        ListNode<T> listNode = head;
        while (listNode != null) {
            list.add(listNode.getData());
            listNode = listNode.getNext();
        }
        Collections.reverse(list);
        return list.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> integerQueue = new Queue<>();
        integerQueue.enQueue(1);
        System.out.println("入队：1,队首元素现在是：" + integerQueue.front() + "，队列长度是：" + integerQueue.size());
        integerQueue.enQueue(2);
        System.out.println("入队：2,队首元素现在是：" + integerQueue.front() + "，队列长度是：" + integerQueue.size());
        System.out.println("出队：" + integerQueue.deQueue() + ",队首元素现在是：" + integerQueue.front() + "，队列长度是：" + integerQueue.size());
        System.out.println("出队：" + integerQueue.deQueue() + ",队首元素现在是：" + integerQueue.front() + "，队列长度是：" + integerQueue.size());
        System.out.println("---------------------------------------------");
        Queue<String> stringQueue = new Queue<>();
        stringQueue.enQueue("a");
        System.out.println("入队：a,队首元素现在是：" + stringQueue.front() + "，队列长度是：" + stringQueue.size());
        stringQueue.enQueue("b");
        System.out.println("入队：b,队首元素现在是：" + stringQueue.front() + "，队列长度是：" + stringQueue.size());
        System.out.println("出队：" + stringQueue.deQueue() + ",队首元素现在是：" + stringQueue.front() + "，队列长度是：" + stringQueue.size());
        System.out.println("出队：" + stringQueue.deQueue() + ",队首元素现在是：" + stringQueue.front() + "，队列长度是：" + stringQueue.size());
        try {
            stringQueue.deQueue();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }
}
