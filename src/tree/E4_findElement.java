package tree;

import java.util.Arrays;

import queue.Queue;

import static util.Print.print;

/**
 * 问题4：利用非递归算法来搜索二叉树中的某个元素
 *
 * @author tufei
 * @date 2018/1/24.
 */

public class E4_findElement {
    public static <T> boolean findElement(BinaryTreeNode<T> treeNode, T t) {
        if (treeNode == null) {
            return false;
        }
        Queue<BinaryTreeNode<T>> queue = new Queue<>();
        queue.enQueue(treeNode);
        BinaryTreeNode<T> temp;
        while (!queue.isEmpty()) {
            temp = queue.deQueue();
            if (temp.getData().equals(t)) {
                return true;
            }
            if (temp.getLeft() != null) {
                queue.enQueue(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.enQueue(temp.getRight());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> treeNode1 = TreeNodeGenerators.fill(10);
        print(findElement(treeNode1, 2));
        print(findElement(treeNode1, 11));
        BinaryTreeNode<String> treeNode2 = TreeNodeGenerators.fill(Arrays.asList("a", "b", "c", "d"));
        print(findElement(treeNode2, "d"));
        print(findElement(treeNode2, "e"));
    }
}
