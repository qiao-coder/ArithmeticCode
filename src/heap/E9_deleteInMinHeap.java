package heap;

import static util.Print.print;

/**
 * 问题9：给出删除最小堆中第i个元素的算法。
 * @author tufei
 * @date 2018/2/8.
 */

public class E9_deleteInMinHeap {
    public static int delete(Heap h,int i){
        if(i >=h.getCount()){
            throw new IllegalArgumentException("The argument which is 'i' can't over or be equal to the count of Heap！");
        }
        int key = h.getArray()[i];
        h.getArray()[i] = h.getArray()[h.getCount() - 1];
        h.setCount(h.getCount()-1);
        h.percolateDown(i);
        return key;
    }

    public static void main(String[] args){
        int[] ints = {1, 2, 10, 4, 5};
        Heap heap = new Heap(5, Heap.Type.MIN);
        Heap.buildHeap(heap,ints,5);
        int deleteNum = delete(heap, 3);
        print(deleteNum);
    }
}
