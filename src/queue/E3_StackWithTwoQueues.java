package queue;

/**
 * 问题3 如何使用两个队列来高效地实现一个栈,并分析该栈基本操作的时间复杂度 。
 * @author tufei
 * @date 2018/1/16.
 */

public class E3_StackWithTwoQueues<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;
    private int size;

    public E3_StackWithTwoQueues() {
        queue1 = new Queue<>();
        queue2 = new Queue<>();
    }

    public void push(T data) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.enQueue(data);
        } else if (!queue1.isEmpty()) {
            queue1.enQueue(data);
        } else {
            queue2.enQueue(data);
        }
        size++;
    }

    public T pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new EmptyQueueException();
        } else if (!queue1.isEmpty()) {
            while (queue1.size() != 1) {
                queue2.enQueue(queue1.deQueue());
            }
            size--;
            return queue1.deQueue();
        } else {
            while (queue2.size() != 1) {
                queue1.enQueue(queue2.deQueue());
            }
            size--;
            return queue2.deQueue();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        E3_StackWithTwoQueues<Integer> stack = new E3_StackWithTwoQueues<>();
        for (int i = 1; i < 6; i++) {
            stack.push(i);
            System.out.println(i + "入栈了");
        }
        System.out.println("stack :" + stack);
        for (int i = 1; i < 6; i++) {
            int data = stack.pop();
            System.out.println(data + "出栈了");
        }
        System.out.println("stack:" + stack);
        try {
            stack.pop();
        } catch (Exception e) {
            //要加System.out，不然，不能按顺序在控制台打印异常
            e.printStackTrace(System.out);
        }
    }
}
