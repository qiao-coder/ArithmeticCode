package linkedlist;

import java.util.Arrays;

/**
 * 解决问题2的另一种方法：一个指针先走n步，另一个指针才开始跟着一起走。
 *
 * @author tufei
 */

public class E5 {
    /**
     * 我的写法(有点蠢)
     */
    public static ListNode getConformListNode(ListNode listNode, int n) {
        //没意识到这里，其实算是一步
        ListNode quickPoint = listNode;
        ListNode slowPoint = null;
        int m = 0;
        //快的指针先走n步
        for (int i = 0; i < n; i++) {
            //但有可能链表的长度只有m，只能走m步
            if (quickPoint != null) {
                quickPoint = quickPoint.getNext();
                m++;
            }
        }
        //如果链表的长度大于或等于n,走完剩下的步数
        if (m >= n) {
            //没意识到这里，其实算slowPoint走第一步
            slowPoint = listNode;
            while (quickPoint != null) {
                slowPoint = slowPoint.getNext();
                quickPoint = quickPoint.getNext();
            }
        }

        return slowPoint;
    }

    /**
     * 作者的写法(更恰当，更简洁)
     */
    static ListNode NthNodeFromEnd(ListNode head, int NthNode) {
        //将head赋值给pTemp，算走了第一步
        ListNode pTemp = head, pNthNode = null;
        //然后走完剩下几步
        for (int count = 1; count < NthNode; count++) {
            if (pTemp != null) {
                pTemp = pTemp.getNext();
            }
        }
        while (pTemp != null) {
            //如果pNthNode走的是第一步，将head赋值给它
            if (pNthNode == null) {
                pNthNode = head;
            } else {
                pNthNode = pNthNode.getNext();
            }
            pTemp = pTemp.getNext();
        }
        return pNthNode;
    }

    public static void main(String[] args) {
        ListNode<Integer> listNode = LinkedListGenerators.fill(Arrays.asList(1, 2, 3, 4, 5, 6));

        ListNode listNode1 = getConformListNode(listNode, 2);
        System.out.println("获取到的结点是：" + listNode1.getData());
        ListNode listNode2 = getConformListNode(listNode, 6);
        System.out.println("获取到的结点是：" + listNode2.getData());
        ListNode listNode3 = getConformListNode(listNode, 7);
        System.out.println("获取到的结点是：" + listNode3);

        System.out.println("-------------------------------------");

        ListNode listNode4 = NthNodeFromEnd(listNode, 2);
        System.out.println("获取到的结点是：" + listNode4.getData());
        ListNode listNode5 = NthNodeFromEnd(listNode, 6);
        System.out.println("获取到的结点是：" + listNode5.getData());
        ListNode listNode6 = NthNodeFromEnd(listNode, 7);
        System.out.println("获取到的结点是：" + listNode6);
    }
}/*Output
获取到的结点是：5
获取到的结点是：1
获取到的结点是：null
-------------------------------------
获取到的结点是：5
获取到的结点是：1
获取到的结点是：null
*/
