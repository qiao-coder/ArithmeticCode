package heap;

import static util.Print.print;

/**
 * 问题7：给定一个最小堆，给出查找最大元素的算法。
 *
 * @author tufei
 * @date 2018/2/7.
 */

public class E7_maxInMinHeap {
    /**
     * 最后一个结点：h.count - 1
     * 最后一个结点的双亲结点是：(h.count-1-1)/2，即h.count/2 - 1
     * 最后一个结点的双亲结点的下一个节点，就是第一个叶子节点，即h.count/2
     */
    public static int findMaxInMinHeap(Heap h) {
        if (h == null) {
            return -1;
        }
        int max = -1;
        for (int i = h.getCount() / 2; i < h.getCount(); i++) {
            print(h.getArray()[i]);
            if (h.getArray()[i] > max) {
                max = h.getArray()[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] ints = {1, 2, 10, 4, 5};
        Heap heap = new Heap(5, Heap.Type.MIN);
        Heap.buildHeap(heap,ints,5);
        print(findMaxInMinHeap(heap));
    }
}
