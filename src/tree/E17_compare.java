package tree;

import java.util.Arrays;

import static util.Print.print;

/**
 * 问题17：给定两棵树，判断它们结构是否相同，如果相同就返回true
 *
 * @author tufei
 * @date 2018/1/27.
 */

public class E17_compare {
    public static <T> boolean compare(BinaryTreeNode<T> treeNode1, BinaryTreeNode<T> treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        return (treeNode1.getData() == treeNode2.getData()) &&
                compare(treeNode1.getLeft(), treeNode2.getLeft()) &&
                compare(treeNode1.getRight(), treeNode2.getRight());
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> treeNode = TreeNodeGenerators.fill(10);
        print(compare(treeNode, treeNode));
        BinaryTreeNode<String> treeNode1 = TreeNodeGenerators.fill(Arrays.asList("a", "b", "c", "d"));
        BinaryTreeNode<String> treeNode2 = TreeNodeGenerators.fill(Arrays.asList("a", "b", "c", "d", "e"));
        print(compare(treeNode1, treeNode2));
    }
}
