package tree;

import queue.Queue;
import stack.Stack;

import static util.Print.print;

/**
 * 问题9：给出算法，逆向逐层输出树中元素
 *
 * @author tufei
 * @date 2018/1/25.
 */

public class E9_levelOrderReversePrint {
    public static <T> void levelOrderReversePrint(BinaryTreeNode<T> treeNode) {
        if (treeNode == null) {
            print(null);
            return;
        }
        Queue<BinaryTreeNode<T>> queue = new Queue<>();
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        queue.enQueue(treeNode);
        stack.push(treeNode);
        BinaryTreeNode<T> temp;
        while (!queue.isEmpty()) {
            temp = queue.deQueue();
            if (temp.getRight() != null) {
                queue.enQueue(temp.getRight());
                stack.push(temp.getRight());
            }
            if (temp.getLeft() != null) {
                queue.enQueue(temp.getLeft());
                stack.push(temp.getLeft());
            }
        }
        while (!stack.isEmpty()){
            BinaryTreeNode<T> node = stack.pop();
            print(node.getData());
        }
    }
    
    public static void main(String[] args){
        BinaryTreeNode<Integer> treeNode = TreeNodeGenerators.fill(7);
        levelOrderReversePrint(treeNode);
    }
}
