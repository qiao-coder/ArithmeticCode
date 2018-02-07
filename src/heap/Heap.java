package heap;

/**
 * 堆
 *
 * @author tufei
 * @date 2018/2/6.
 */

public class Heap {
    private int[] array;
    private int count;
    private int capacity;
    private Type type;

    enum Type {
        MAX, MIN
    }

    public Heap(int capacity, Type type) {
        this.capacity = capacity;
        this.type = type;
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
        int l, r, down, temp;
        l = leftChild(i);
        r = rightChild(i);
        if (l == -1 && r == -1) {
            return;
        }
        if (type == Type.MAX) {
            if (l != -1 && this.array[l] > this.array[i]) {
                down = l;
            } else {
                down = i;
            }
        } else {
            if (l != -1 && this.array[l] < this.array[i]) {
                down = l;
            } else {
                down = i;
            }
        }
        if(type == Type.MAX){
            if (r != -1 && this.array[r] > this.array[down]) {
                down = r;
            }
        }else {
            if (r != -1 && this.array[r] < this.array[down]) {
                down = r;
            }
        }

        if (down != i) {
            //交换
            temp = this.array[i];
            this.array[i] = this.array[down];
            this.array[down] = temp;
            percolateDown(down);
        }

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
     * @param arrayLength
     */
    public static void buildHeap(Heap h, int[] a, int arrayLength) {
        if (h == null) {
            return;
        }
        while (arrayLength > h.capacity) {
            h.resizeHeap();
        }
        for (int i = 0; i < arrayLength; i++) {
            h.array[i] = a[i];
        }
        h.count = arrayLength;
        for (int i = (arrayLength - 1) / 2; i >= 0; i--) {
            h.percolateDown(i);
        }
    }

    public static void heapSort(int[] a, int n) {
        Heap h = new Heap(n, Type.MIN);
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
