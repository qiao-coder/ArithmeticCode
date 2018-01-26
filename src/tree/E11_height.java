package tree;

import java.util.Arrays;

import queue.Queue;

import static util.Print.print;

/**
 * 问题11：利用非递归解决问题10
 *
 * @author tufei
 * @date 2018/1/26.
 */

public class E11_height {
    public static <T> int getHeight(BinaryTreeNode<T> treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int height = 0;
        Queue<BinaryTreeNode<T>> queue = new Queue<>();
        queue.enQueue(treeNode);
        queue.enQueue(null);
        BinaryTreeNode<T> temp;
        while (!queue.isEmpty()) {
            temp = queue.deQueue();
            if (temp == null) {
                if (!queue.isEmpty()) {
                    queue.enQueue(null);
                }
                height++;
            } else {
                if (temp.getLeft() != null) {
                    queue.enQueue(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.enQueue(temp.getRight());
                }
            }
        }
        return height;
    }

    public static void main(String[] args){
        BinaryTreeNode<Integer> treeNode1 = TreeNodeGenerators.fill(7);
        print(getHeight(treeNode1));
        BinaryTreeNode<Integer> treeNode2 = TreeNodeGenerators.fill(10);
        print(getHeight(treeNode2));
        BinaryTreeNode<String> treeNode3 = TreeNodeGenerators.fill(Arrays.asList("a", "b", "c"));
        print(getHeight(treeNode3));
    }
}
