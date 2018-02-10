package heap;


import static util.Print.print;

/**
 * 问题15：给出在最小堆中找到第k个最小元素的算法。
 * @author tufei
 * @date 2018/2/10.
 */

public class E15_findKthLeastElement {
    public static int findKthLeastElement(Heap h,int k){
        for(int i=0;i<k-1;i++){
            h.deleteMin();
        }
        return h.deleteMin();
    }

    public static void main(String[] args){
        Heap heap = new Heap(5, Heap.Type.MIN);
        Heap.buildHeap(heap,new int[]{1,2,3,5,4},5);
        int element = findKthLeastElement(heap, 4);
        print(element);
    }
}
