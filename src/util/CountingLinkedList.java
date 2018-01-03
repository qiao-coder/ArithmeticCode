package util;


import linkedlist.LinkedList;

/**
 * @author tufei
 * @date 2018/1/3.
 */

public class CountingLinkedList {

    /**
     * 计算非循环链表的长度
     *
     * @param linkedList
     * @return
     */
    public static int getLength(LinkedList linkedList) {
        int i = 0;
        if (linkedList == null) {
            return i;
        }
        i++;
        while (linkedList.getNext() != null) {
            linkedList = linkedList.getNext();
            i++;
        }
        return i;
    }
}
