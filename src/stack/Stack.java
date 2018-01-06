package stack;

import linkedlist.ListNode;

/**
 * 栈：基于链表的实现
 *
 * @author tufei
 * @date 2018/1/5.
 */

public class Stack<T> {
    private ListNode<T> top;

    public Stack() {

    }

    public Stack(ListNode<T> listNode) {
        top = listNode;
    }

    public void push(T data) {
        if (top == null) {
            top = new ListNode<>();
            top.setData(data);
        } else {
            ListNode<T> newTop = new ListNode<>();
            newTop.setNext(top);
            newTop.setData(data);
            top = newTop;
        }
    }

    public T pop() {
        if (top != null && top.getData() != null) {
            ListNode<T> oldTop = top;
            top = oldTop.getNext();
            return oldTop.getData();
        } else {
            throw new EmptyStackException();
        }
    }

    public T top() {
        return top == null ? null : top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void deleteStack() {
        top = null;
    }

    @Override
    public String toString() {
        return top == null ? null : top.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < 6; i++) {
            stack.push(i);
            Integer top = stack.top();
            System.out.println(i + "入栈了,栈顶元素是：" + top);
        }
        System.out.println("stack :" + stack);
        for (int i = 1; i < 6; i++) {
            int data = stack.pop();
            //这里不能用int，不然栈顶没有元素时，会报空指针
            Integer top = stack.top();
            System.out.println(data + "出栈了,栈顶元素是：" + top);
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
