package util;


import linkedlist.ListNode;

/**
 * @author tufei
 * @date 2018/1/3.
 */

public class CountingLinkedList {

    /**
     * 计算非循环链表的长度
     *
     * @param listNode
     * @return
     */
    public static int getLength(ListNode listNode) {
        int i = 0;
        if (listNode == null) {
            return i;
        }
        i++;
        while (listNode.getNext() != null) {
            listNode = listNode.getNext();
            i++;
        }
        return i;
    }
}
