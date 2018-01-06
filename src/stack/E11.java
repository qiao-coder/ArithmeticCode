package stack;

import java.util.Arrays;

import linkedlist.LinkedListGenerators;
import linkedlist.ListNode;

/**
 * 问 题 11 给 定 一 个 栈 ， 如 何 只 使 用 栈 操 作 （ push 和 pop ） 逆 置 栈 中 的 内 容 ？
 *
 * @author tufei
 * @date 2018/1/6.
 */

public class E11 {
    public static <T> void reverseElement(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }
        T temp = stack.pop();
        reverseElement(stack);
        insertElement(stack, temp);
    }

    private static <T> void insertElement(Stack<T> stack, T data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        T temp = stack.pop();
        insertElement(stack, data);
        stack.push(temp);
    }

    public static void main(String[] args) {
        ListNode<Integer> listNode = LinkedListGenerators.fill(Arrays.asList(1, 2, 3, 4, 5, 6));
        Stack<Integer> stack = new Stack<>(listNode);
        reverseElement(stack);
        System.out.println(stack);
    }
}
