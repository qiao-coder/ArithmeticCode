package queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import linkedlist.LinkedListGenerators;
import stack.Stack;

/**
 * 问题8：给定一个整数栈，如何检查栈中每对相邻数字是否是连续的。每对数字的
 * 值可以是递增或递减的。如果栈中元素的个数是奇数，那么组对时忽略栈顶元素。
 * 例如，假设栈中元素为[4，5，-2，-3，11，10，5，6，20],那么算法应该输出为真，
 * 因为每对二元组（4，5）、（-2，-3）、（11，10）和（5，6）都是连续的数字。
 *
 * @author tufei
 * @date 2018/1/17.
 */

public class E8 {
    public static boolean checkStackPairwise(Stack<Integer> stack) {
        Queue<Integer> queue = new Queue<>();
        while (!stack.isEmpty()) {
            queue.enQueue(stack.pop());
        }
        while (!queue.isEmpty()) {
            stack.push(queue.deQueue());
        }
        boolean isPairWise = false;
        while (!stack.isEmpty()) {
            Integer m = stack.pop();
            queue.enQueue(m);
            if (!stack.isEmpty()) {
                Integer n = stack.pop();
                queue.enQueue(n);
                if (Math.abs(m - n) == 1) {
                    isPairWise = true;
                } else {
                    isPairWise = false;
                }
            }
        }
        while (!queue.isEmpty()) {
            stack.push(queue.deQueue());
        }
        return isPairWise;
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        boolean a = checkStackPairwise(stack1);
        System.out.println("stack1结果为：" + a);

        List<Integer> list = Arrays.asList(4, 5, -2, -3, 11, 10, 5, 6);
        Stack<Integer> stack2 = new Stack<>(LinkedListGenerators.fill(list));
        boolean b = checkStackPairwise(stack2);
        System.out.println("stack2结果为：" + b);

        list = Arrays.asList(4, 5, -2, -3, 11, 10, 5, 6, 20);
        Stack<Integer> stack3 = new Stack<>(LinkedListGenerators.fill(list));
        boolean c = checkStackPairwise(stack3);
        System.out.println("stack2结果为：" + c);

        Collections.reverse(list);
        Stack<Integer> stack4 = new Stack<>(LinkedListGenerators.fill(list));
        boolean d = checkStackPairwise(stack4);
        System.out.println("stack2结果为：" + d);
    }
}
