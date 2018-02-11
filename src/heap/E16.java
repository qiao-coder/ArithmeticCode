package heap;

import static util.Print.print;

/**
 * 问题16：对于问题15，能否降低其时间复杂度
 *
 * @author tufei
 * @date 2018/2/11.
 */

public class E16 {
    public static int findKthLeastElement(Heap h, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("The 'k' must be more than 0!");
        }
        if (h.getCount() <= 0) {
            throw new IllegalArgumentException("The size of Heap must be more than 0!");
        }
        if (k == 1) {
            return h.getArray()[0];
        }
        Heap temp = new Heap(h.getCount(), Heap.Type.MIN);
        int heapElement;
        int count = 1;
        temp.insert(h.deleteMin());
        while (true) {
            heapElement = h.deleteMin();
            if (++count == k) {
                return heapElement;
            } else {
                if (h.leftChild(count - 1) != -1) {
                    temp.insert(h.getArray()[h.leftChild(count - 1)]);
                }
                if (h.rightChild(count - 1) != -1) {
                    temp.insert(h.getArray()[h.rightChild(count - 1)]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(5, Heap.Type.MIN);
        Heap.buildHeap(heap, new int[]{1, 2, 3, 5, 4}, 5);
        int element = findKthLeastElement(heap, 4);
        print(element);
    }
}
