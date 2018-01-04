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
    public static ListNode fill(int length) {
        if (length <= 0) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode last = head;
        for (int i = 0; i < length - 1; i++) {
            last.setNext(new ListNode());
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
    public static <T> ListNode<T> fill(List<T> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ListNode<T> head = new ListNode<>();
        head.setData(list.get(0));
        ListNode<T> last = head;
        for (int i = 1; i < list.size(); i++) {
            last.setNext(new ListNode<>());
            last.getNext().setData(list.get(i));
            last = last.getNext();
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = LinkedListGenerators.fill(0);
        System.out.println("生成的链表linkedList1的长度为：" + CountingLinkedList.getLength(listNode1));
        ListNode listNode2 = LinkedListGenerators.fill(10);
        System.out.println("生成的链表linkedList2的长度为：" + CountingLinkedList.getLength(listNode2));
        ListNode<Object> listNode3 = LinkedListGenerators.fill(Collections.emptyList());
        System.out.println("生成的链表linkedList3的长度为：" + CountingLinkedList.getLength(listNode3));
        ListNode<Integer> listNode4 = LinkedListGenerators.fill(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("生成的链表linkedList4的长度为：" + CountingLinkedList.getLength(listNode4));
    }
}
