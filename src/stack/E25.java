package stack;

import java.util.Arrays;

import linkedlist.LinkedListGenerators;
import linkedlist.ListNode;

/**
 * 问 题 25 设 计 一 个 可 以 把 栈 中 元 素 按 照 升 序 排 列 的 排 序 算 法 ， 并 且 算 法 不 能 对 栈 的
 * 具 体 实 现 方 式 有 限 定 。
 *
 * @author tufei
 * @date 2018/1/9.
 */

public class E25 {
    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> sortStack = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!sortStack.isEmpty() && sortStack.top() > temp) {
                stack.push(sortStack.pop());
            }
            sortStack.push(temp);
        }
        return sortStack;
    }

    public static void main(String[] args) {
        ListNode<Integer> listNode = LinkedListGenerators.fill(Arrays.asList(5, 6, 2, 5, 7, 9, 2, 10, 11));
        Stack<Integer> stack = new Stack<>(listNode);
        Stack<Integer> sort = sort(stack);
        System.out.println(sort);
    }
}
