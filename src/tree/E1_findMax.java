package tree;

import java.util.Arrays;

/**
 * 问题1：给出查找二叉树中最大元素的算法
 *
 * @author tufei
 * @date 2018/1/22.
 */

public class E1_findMax {
    public static int findMax(BinaryTreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int data = treeNode.getData();
        int left = findMax(treeNode.getLeft());
        int right = findMax(treeNode.getRight());
        int temp = Math.max(data, left);
        int max = Math.max(temp, right);
        return max;
    }

    public static void main(String[] args){
        BinaryTreeNode binaryTreeNode = TreeNodeGenerators.fill(10);
        int max = findMax(binaryTreeNode);
        System.out.println(max);

        BinaryTreeNode<Integer> treeNode = TreeNodeGenerators.fill(Arrays.asList(1, 3, 6, 5, 7, 10, 11, 99, 100, 7));
        int max2 = findMax(treeNode);
        System.out.println(max2);
    }
}
