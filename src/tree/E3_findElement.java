package tree;

import java.util.Arrays;

import static util.Print.print;

/**
 * 问题3：给出在二叉树中搜索某个元素的算法
 *
 * @author tufei
 * @date 2018/1/24.
 */

public class E3_findElement {

    public static <T> boolean findElement(BinaryTreeNode<T> treeNode, T t) {
        boolean temp;
        if (treeNode == null) {
            return false;
        }
        T data = treeNode.getData();
        if (data.equals(t)) {
            return true;
        } else {
            temp = findElement(treeNode.getLeft(), t);
            if (temp) {
                return true;
            } else {
                return findElement(treeNode.getRight(), t);
            }
        }
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
