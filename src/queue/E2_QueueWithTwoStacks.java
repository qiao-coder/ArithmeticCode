package queue;

import java.util.ArrayList;
import java.util.Collections;

import stack.Stack;

/**
 * 问题2：如何使用两个栈来实现队列
 *
 * @author tufei
 * @date 2018/1/15.
 */

public class E2_QueueWithTwoStacks<T> {
    Stack<T> stack1;
    Stack<T> stack2;

    public E2_QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enQueue(T data) {
        stack1.push(data);
    }

    public T deQueue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new EmptyQueueException();
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }

    @Override
    public String toString() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return null;
        }
        ArrayList<T> list1 = new ArrayList<>();
        while (!stack1.isEmpty()) {
            T t = stack1.pop();
            list1.add(t);
        }
        for (int i = list1.size() - 1; i >= 0; i--) {
            stack1.push(list1.get(i));
        }
        ArrayList<T> list2 = new ArrayList<>();
        while (!stack2.isEmpty()) {
            T t = stack2.pop();
            list2.add(t);
        }
        Collections.reverse(list2);
        for (int i = 0; i < list2.size(); i++) {
            stack2.push(list2.get(i));
        }
        list1.addAll(list2);
        return list1.toString();
    }

    public static void main(String[] args) {
        E2_QueueWithTwoStacks<Integer> queue = new E2_QueueWithTwoStacks<>();
        for (int i = 9; i > 0; i--) {
            queue.enQueue(i);
        }
        System.out.println(queue);
        for (int i = 0; i < 3; i++) {
            queue.deQueue();
        }
        System.out.println(queue);
        for (int i = 10; i > 6; i--) {
            queue.enQueue(i);
        }
        System.out.println(queue);
    }
}
