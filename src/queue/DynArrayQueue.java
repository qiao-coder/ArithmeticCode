package queue;

import java.lang.reflect.Array;

/**
 * 队列：动态循环数组的实现
 *
 * @author tufei
 * @date 2018/1/10.
 */

public class DynArrayQueue<T> {

    private final Class<T> kind;
    private int capacity;
    private T[] array;
    private int front = -1;
    private int end = -1;

    @SuppressWarnings("unchecked")
    private DynArrayQueue(Class<T> kind, int size) {
        this.capacity = size;
        this.kind = kind;
        array = (T[]) Array.newInstance(kind, size);
    }

    public static <T> DynArrayQueue<T> create(Class<T> kind, int size) {
        if (kind == null) {
            throw new IllegalArgumentException("kind can't be null!");
        }
        if (size == 0) {
            throw new IllegalArgumentException("size can't be zero!");
        }
        return new DynArrayQueue<>(kind, size);
    }

    public void enQueue(T data) {
        if (isFull()) {
            resizeQueue();
        }
        end = (end + 1) % capacity;
        array[end] = data;
        if (front == -1) {
            front = end;
        }
    }

    public T deQueue() {

        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            T data = array[front];
            //不需要
            //array[front] = null;
            if (front == end) {
                //不能直接赋值为-1
                //front = -1;
                front = end = -1;
            } else {
                front = (front + 1) % capacity;
            }
            return data;
        }
    }

    public T front() {
        return isEmpty() ? null : array[front];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (end + 1) % capacity == front;
    }

    public int size() {
        //两种情况：一种end在front前面  一种end在front后面（所以加capacity）
        if (isEmpty()) {
            return 0;
        }
        if (isFull()) {
            return capacity;
        }
        return (end - front + 1 + capacity) % capacity;
    }

    @SuppressWarnings("unchecked")
    private void resizeQueue() {
        int newCapacity = capacity * 2;
        T[] newArray = (T[]) Array.newInstance(kind, newCapacity);
        int cursor = front;
        for (; cursor < capacity; cursor++) {
            newArray[cursor] = array[cursor];
        }
        if (front > end) {
            for (int newCursor = 0; newCursor <= end; newCursor++) {
                cursor++;
                newArray[cursor] = array[newCursor];
            }
        }
        capacity = newCapacity;
        //必须减1，因为游标最后会移动多一位
        end = cursor - 1;
        array = newArray;
    }

    public static void main(String[] args) {
        DynArrayQueue<String> stringArrayQueue = DynArrayQueue.create(String.class, 1);
        stringArrayQueue.enQueue("a");
        System.out.println("入队：a,队首元素现在是：" + stringArrayQueue.front() + "，队列长度是：" + stringArrayQueue.size());
        stringArrayQueue.enQueue("b");
        System.out.println("入队：b,队首元素现在是：" + stringArrayQueue.front() + "，队列长度是：" + stringArrayQueue.size());
        stringArrayQueue.enQueue("c");
        System.out.println("入队：c,队首元素现在是：" + stringArrayQueue.front() + "，队列长度是：" + stringArrayQueue.size());
        System.out.println("出队：" + stringArrayQueue.deQueue() + ",队首元素现在是：" + stringArrayQueue.front() + "，队列长度是：" + stringArrayQueue.size());
        System.out.println("出队：" + stringArrayQueue.deQueue() + ",队首元素现在是：" + stringArrayQueue.front() + "，队列长度是：" + stringArrayQueue.size());
        stringArrayQueue.enQueue("d");
        stringArrayQueue.enQueue("e");
        stringArrayQueue.enQueue("f");
        stringArrayQueue.enQueue("g");
        System.out.println("入队：d、e、f、g,队首元素现在是：" + stringArrayQueue.front() + "，队列长度是：" + stringArrayQueue.size());

    }
}
