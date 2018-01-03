package linkedlist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import util.CountingLinkedList;

/**
 * @author tufei
 * @date 2018/1/3.
 */

public class LinkedListGenerators {
    /**
     * 生成指定长度的链表
     *
     * @param length
     * @return
     */
    public static LinkedList fill(int length) {
        if (length <= 0) {
            return null;
        }
        LinkedList head = new LinkedList();
        LinkedList last = head;
        for (int i = 0; i < length - 1; i++) {
            last.setNext(new LinkedList());
            last = last.getNext();
        }
        return head;
    }

    /**
     * 按给定的数据集合，生成一个恰好能存储这些数据的链表
     * @param list
     * @param <T>
     * @return
     */
    public static <T> LinkedList<T> fill(List<T> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        LinkedList<T> head = new LinkedList<>();
        head.setData(list.get(0));
        LinkedList<T> last = head;
        for (int i = 1; i < list.size(); i++) {
            last.setNext(new LinkedList<>());
            last.getNext().setData(list.get(i));
            last = last.getNext();
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList linkedList1 = LinkedListGenerators.fill(0);
        System.out.println("生成的链表linkedList1的长度为：" + CountingLinkedList.getLength(linkedList1));
        LinkedList linkedList2 = LinkedListGenerators.fill(10);
        System.out.println("生成的链表linkedList2的长度为：" + CountingLinkedList.getLength(linkedList2));
        LinkedList<Object> linkedList3 = LinkedListGenerators.fill(Collections.emptyList());
        System.out.println("生成的链表linkedList3的长度为：" + CountingLinkedList.getLength(linkedList3));
        LinkedList<Integer> linkedList4 = LinkedListGenerators.fill(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("生成的链表linkedList4的长度为：" + CountingLinkedList.getLength(linkedList4));
    }
}
