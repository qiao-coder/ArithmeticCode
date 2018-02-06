package heap;

/**
 * 最大堆
 *
 * @author tufei
 * @date 2018/2/6.
 */

public class Heap {
    private int[] array;
    private int count;
    private int capacity;
    private int heap_type;

    public Heap(int capacity, int heap_type) {
        this.capacity = capacity;
        this.heap_type = heap_type;
        this.count = 0;
        this.array = new int[capacity];
    }

    public int parent(int i) {
        if (i <= 0 || i >= this.count) {
            return -1;
        }
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        int left = 2 * i + 1;
        if (left >= this.count) {
            return -1;
        }
        return left;
    }

    public int rightChild(int i) {
        int right = 2 * i + 2;
        if (right >= this.count) {
            return -1;
        }
        return right;
    }

    public int getMax() {
        if (this.count == 0) {
            return -1;
        }
        return this.array[0];
    }

    /**
     * 堆化当前元素
     *
     * @param i
     */
    public void percolateDown(int i) {
        int l, r, max, temp;
        l = leftChild(i);
        r = rightChild(i);
        if (l != -1 && this.array[l] > this.array[i]) {
            max = 1;
        } else {
            max = i;
        }
        if (r != -1 && this.array[r] > this.array[max]) {
            max = r;
        }
        if (max != i) {
            //交换
            temp = this.array[i];
            this.array[i] = this.array[max];
            this.array[max] = temp;
        }
        percolateDown(max);
    }

    public int deleteMax() {
        if (this.count == 0) {
            return -1;
        }
        int data = this.array[0];
        this.array[0] = this.array[this.count - 1];
        this.count--;
        percolateDown(0);
        return data;
    }

    public void insert(int data) {
        int i;
        if (this.count == this.capacity) {
            resizeHeap();
        }
        this.count++;
        i = this.count - 1;
        while ((i >= 0 && data > this.array[(i - 1) / 2])) {
            this.array[i] = this.array[(i - 1) / 2];
            i = (i - 1) / 2;
        }
        this.array[i] = data;
    }

    private void resizeHeap() {
        int[] array_old = new int[this.capacity];
        System.arraycopy(this.array, 0, array_old, 0, this.count - 1);
        this.array = new int[this.capacity * 2];
        for (int i = 0; i < this.capacity; i++) {
            this.array[i] = array_old[i];
        }
        this.capacity *= 2;
    }

    public void destroyHeap() {
        this.count = 0;
        this.array = null;
    }

    /**
     * 数组建堆
     *
     * @param h
     * @param a
     * @param n
     */
    public static void buildHeap(Heap h, int[] a, int n) {
        if (h == null) {
            return;
        }
        while (n > h.capacity) {
            h.resizeHeap();
        }
        for (int i = 0; i < n; i++) {
            h.array[i] = a[i];
        }
        h.count = n;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            h.percolateDown(i);
        }
    }

    public static void heapSort(int[] a, int n) {
        Heap h = new Heap(n, 0);
        buildHeap(h, a, n);
        for (int i = n - 1; i > 0; i--) {
            h.array[0] = h.array[h.count - 1];
            h.count--;
            h.percolateDown(i);
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getHeap_type() {
        return heap_type;
    }

    public void setHeap_type(int heap_type) {
        this.heap_type = heap_type;
    }
}
