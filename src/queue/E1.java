package queue;

import stack.Stack;

/**
 * 问题1：设计一个逆置队列元素的算法。要求算法在访问队列元素时，只能使用队列抽象数据类型中的操作。
 *
 * @author tufei
 * @date 2018/1/15.
 */

public class E1 {
    public static <T> void reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.deQueue());
        }
        while (!stack.isEmpty()) {
            queue.enQueue(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 1; i < 10; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);
        reverseQueue(queue);
        System.out.println(queue);
    }
}
