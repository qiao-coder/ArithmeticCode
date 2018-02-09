package heap;

import java.util.ArrayList;
import java.util.List;

import static util.Print.print;


/**
 * 问题11：给出在二叉堆中找出所有小于值k的元素的算法
 *
 * @author tufei
 * @date 2018/2/9.
 */

public class E11_findElementsLessthanK {

    public static List<Integer> findElementsLessthanK(Heap heap, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] heapArray = heap.getArray();
        for (int i : heapArray) {
            if (i < k) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args){
        Heap heap = new Heap(5, Heap.Type.MIN);
        Heap.buildHeap(heap,new int[]{1,2,3,4,5},5);
        List<Integer> list = findElementsLessthanK(heap, 3);
        print(list);
    }
}
