package linkedlist;

import java.util.Arrays;

/**
 * 问 题 44  寻 找 模 结 点 ： 给 定 一 个 单 向 链 表 ， 链 表 的 结 点 编 号 i 为 [1 . . n ] ， 其 中 n 为
 * 链 表 中 元 素 的 个 数 ， 编 写 一 个 函 数 从 表 头 开 始 找 到 最 后 一 个 满 足 i ％ k == 0 条 件 的 元 素 ，
 * k为 一 个 整 数 常 量 。 例 如 ， 如 果n 为 19 ，k 为 3 ， 那 么 应 该 返 回 第 18 个 结 点 。
 *
 * @author tufei
 * @date 2018/1/3.
 */

class E44 {

    public static ListNode getLastModLinked(ListNode head, int k){
        if(k<=0){
            return null;
        }
        int i = 1;
        ListNode lastMod = null;
        while (head != null){
            if(i%k==0){
                lastMod = head;
            }
            head = head.getNext();
            i++;
        }
        return lastMod;
    }

    public static void main(String[] args){
        ListNode<Integer> head = LinkedListGenerators.fill(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        ListNode lastMod = getLastModLinked(head, 3);
        System.out.println("最后满足条件的节点："+lastMod.getData());
        ListNode<Integer> head2 = LinkedListGenerators.fill(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
        ListNode lastMod2 = getLastModLinked(head2, 7);
        System.out.println("最后满足条件的节点："+lastMod2.getData());
    }
}/*Output
最后满足条件的节点：9
最后满足条件的节点：7
*/