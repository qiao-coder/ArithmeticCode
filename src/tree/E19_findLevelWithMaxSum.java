package tree;

import java.util.Arrays;

import queue.Queue;

import static util.Print.print;

/**
 * 问题19：找出二叉树中同一层结点数据之和最大的层
 *
 * @author tufei
 * @date 2018/1/28.
 */

public class E19_findLevelWithMaxSum {
    public static int findLevelWithMaxSum(BinaryTreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int level = 1;
        int max;
        int maxLevel;
        int sum = 0;
        Queue<BinaryTreeNode<Integer>> queue = new Queue<>();
        queue.enQueue(treeNode);
        queue.enQueue(null);
        max = treeNode.getData();
        maxLevel = 1;
        BinaryTreeNode<Integer> root;
        while (!queue.isEmpty()) {
            root = queue.deQueue();
            if (root == null) {
                level++;
                if (sum > max) {
                    max = sum;
                    maxLevel = level;
                }
                if (!queue.isEmpty()) {
                    sum = 0;
                    queue.enQueue(null);
                }
            } else {
                if (root.getLeft() != null) {
                    queue.enQueue(root.getLeft());
                    sum = sum + root.getLeft().getData();
                }
                if (root.getRight() != null) {
                    queue.enQueue(root.getRight());
                    sum = sum + root.getRight().getData();
                }
            }

        }
        return maxLevel;
    }

    public static void main(String[] args){
        BinaryTreeNode<Integer> treeNode1 = TreeNodeGenerators.fill(3);
        print(findLevelWithMaxSum(treeNode1));
        BinaryTreeNode<Integer> treeNode2 = TreeNodeGenerators.fill(9);
        print(findLevelWithMaxSum(treeNode2));
        BinaryTreeNode<Integer> treeNode3 = TreeNodeGenerators.fill(Arrays.asList(1, 21, 22, 4, 5, 6, 7));
        print(findLevelWithMaxSum(treeNode3));
    }
}
