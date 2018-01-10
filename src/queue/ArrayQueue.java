package queue;

import java.lang.reflect.Array;

/**
 * 队列：简单循环数组的实现
 *
 * @author tufei
 * @date 2018/1/10.
 */

public class ArrayQueue<T> {

    private final int capacity;
    private final T[] array;
    private int front = -1;
    private int end = -1;

    @SuppressWarnings("unchecked")
    private ArrayQueue(Class<T> kind, int size) {
        this.capacity = size;
        array = (T[]) Array.newInstance(kind, size);
    }

    public static <T> ArrayQueue<T> create(Class<T> kind, int size) {
        return new ArrayQueue<>(kind, size);
    }

    public void enQueue(T data) {
        if (isFull()) {
            throw new QueueOverflowException();
        } else {
            end = (end + 1) % capacity;
            array[end] = data;
            if (front == -1) {
                front = end;
            }
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
        return (end - front + 1 + capacity) % capacity;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> integerArrayQueue = ArrayQueue.create(Integer.class, 6);
        integerArrayQueue.enQueue(1);
        System.out.println("入队：1,队首元素现在是：" + integerArrayQueue.front() + "，队列长度是：" + integerArrayQueue.size());
        integerArrayQueue.enQueue(2);
        System.out.println("入队：2,队首元素现在是：" + integerArrayQueue.front() + "，队列长度是：" + integerArrayQueue.size());
        System.out.println("出队：" + integerArrayQueue.deQueue() + ",队首元素现在是：" + integerArrayQueue.front() + "，队列长度是：" + integerArrayQueue.size());
        System.out.println("出队：" + integerArrayQueue.deQueue() + ",队首元素现在是：" + integerArrayQueue.front() + "，队列长度是：" + integerArrayQueue.size());
        System.out.println("---------------------------------------------");
        ArrayQueue<String> stringArrayQueue = ArrayQueue.create(String.class, 6);
        stringArrayQueue.enQueue("a");
        System.out.println("入队：a,队首元素现在是：" + stringArrayQueue.front() + "，队列长度是：" + stringArrayQueue.size());
        stringArrayQueue.enQueue("b");
        System.out.println("入队：b,队首元素现在是：" + stringArrayQueue.front() + "，队列长度是：" + stringArrayQueue.size());
        System.out.println("出队：" + stringArrayQueue.deQueue() + ",队首元素现在是：" + stringArrayQueue.front() + "，队列长度是：" + stringArrayQueue.size());
        System.out.println("出队：" + stringArrayQueue.deQueue() + ",队首元素现在是：" + stringArrayQueue.front() + "，队列长度是：" + stringArrayQueue.size());
    }
}
