package linkedlist;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 建立辅助的散列表  帮助解决问题2
 *
 * @author tufei
 * @date 2018/1/4.
 */

public class E3 {
    public static ListNode getConformListNode(ListNode head, int n) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        for (int i = 1; head != null; i++) {
            map.put(i, head);
            head = head.getNext();
        }
        int m = map.size() - n + 1;
        return map.get(m);
    }

    public static void main(String[] args) {
        ListNode<Integer> listNode = LinkedListGenerators.fill(Arrays.asList(1, 2, 3, 4, 5, 6));

        ListNode linked1 = getConformListNode(listNode, 4);
        System.out.println("获取到的结点是：" + linked1.getData());
        ListNode linked2 = getConformListNode(listNode, 6);
        System.out.println("获取到的结点是：" + linked2.getData());
        ListNode linked3 = getConformListNode(listNode, 7);
        System.out.println("获取到的结点是：" + linked3);

    }
}/*Output
获取到的结点是：3
获取到的结点是：1
获取到的结点是：null
*/
