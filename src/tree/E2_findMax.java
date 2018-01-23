package tree;

import queue.Queue;

/**
 * 问题2：用非递归的方法实现查找二叉树中最大元素
 *
 * @author tufei
 * @date 2018/1/23.
 */

public class E2_findMax {
    public static int findMax(BinaryTreeNode<Integer> treeNode) {
        Queue<BinaryTreeNode<Integer>> queue = new Queue<>();
        if (treeNode == null) {
            throw new EmptyTreeException();
        }
        int max = Integer.MIN_VALUE;
        queue.enQueue(treeNode);
        BinaryTreeNode<Integer> temp;
        while (!queue.isEmpty()) {
            temp = queue.deQueue();
            if (temp.getData() > max) {
                max = temp.getData();
            }
            if (temp.getLeft() != null) {
                queue.enQueue(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.enQueue(temp.getRight());
            }
        }
        return max;
    }

    public static void main(String[] args){
        BinaryTreeNode<Integer> treeNode = TreeNodeGenerators.fill(10);
        int max = findMax(treeNode);
        System.out.println(max);
    }
}
