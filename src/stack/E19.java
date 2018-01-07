package stack;

import java.util.Arrays;

import linkedlist.LinkedListGenerators;
import linkedlist.ListNode;

/**
 * 问 题 19 假 设 两 个 单 向 链 表 在 某 个 （ 结 ） 点 相 交 后 ， 成 为 一 个 单 向 链 表 。 两 个 链 表 的
 * 表 头 结 点 是 已 知 的 ， 但 是 相 交 的 结 点 未 知 。 也 就 是 说 ， 它 们 相 交 之 前 各 自 的 结 点 数 是 未
 * 知 的 ， 并 且 两 个 链 表 的 结 点 数 也 可 能 不 同 。 令 链 表 Listl 和 链 表 List2 在 相 交 前 的 结 点 数
 * 分 别 为 n和 m 那 么 m 可 能 等 于 n 或 小 于 n 也 可 能 大 于 n 。 可 以 使 用 栈 实 现 算 法 来 找 到
 * 两 个 链 表 的 相 交 点 吗 ？
 *
 * @author tufei
 * @date 2018/1/7.
 */

public class E19 {
    public static <T> ListNode<T> findMeetListNode(ListNode<T> head1, ListNode<T> head2) {
        Stack<ListNode<T>> stack1 = new Stack<>();
        Stack<ListNode<T>> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.getNext();
        }
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.getNext();
        }
        ListNode<T> temp = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode<T> listNode1 = stack1.pop();
            ListNode<T> listNode2 = stack2.pop();
            if (listNode1 != listNode2) {
                break;
            }
            temp = listNode1;
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode<Integer> listNode1 = LinkedListGenerators.fill(Arrays.asList(6, 5, 4, 3, 2, 1));
        ListNode<Integer> listNode2 = listNode1;
        for (int i = 7; i <= 10; i++) {
            ListNode<Integer> listNode = new ListNode<>();
            listNode.setNext(listNode2);
            listNode2 = listNode;
        }
        ListNode<Integer> meetListNode = findMeetListNode(listNode1, listNode2);
        System.out.println("在倒数第"+meetListNode.getData()+"个结点相交");
    }
}
