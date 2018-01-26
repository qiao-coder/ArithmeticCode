package tree;

import java.util.Arrays;

import static util.Print.print;

/**
 * 问题10：求已知二叉树高度（深度）的算法。
 *
 * @author tufei
 * @date 2018/1/26.
 */

public class E10_height {
    public static <T> int getHeight(BinaryTreeNode<T> treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int tempLeft;
        int tempRight;
        tempLeft = getHeight(treeNode.getLeft()) + 1;
        tempRight = getHeight(treeNode.getRight()) + 1;
        int max = Math.max(tempLeft, tempRight);
        return max;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> treeNode1 = TreeNodeGenerators.fill(7);
        print(getHeight(treeNode1));
        BinaryTreeNode<Integer> treeNode2 = TreeNodeGenerators.fill(10);
        print(getHeight(treeNode2));
        BinaryTreeNode<String> treeNode3 = TreeNodeGenerators.fill(Arrays.asList("a", "b", "c"));
        print(getHeight(treeNode3));
    }
}
