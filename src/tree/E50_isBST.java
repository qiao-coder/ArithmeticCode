package tree;

import static util.Print.print;

/**
 * 问题50：给出算法，判断一个给出的二叉树是否是BST树。
 *
 * @author tufei
 * @date 2018/2/1.
 */

public class E50_isBST {
    public static boolean isBST(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        if (root.getLeft() != null && root.getRight() != null) {
            if (root.getData() <= BinarySearchTreeNode.findMax(root.getLeft()).getData()
                    || root.getData() >= BinarySearchTreeNode.findMin(root.getRight()).getData()){
                return false;
            }
            return isBST(root.getLeft()) && isBST(root.getRight());
        }
        if (root.getLeft() != null) {
            if (root.getData() <= BinarySearchTreeNode.findMax(root.getLeft()).getData()) {
                return false;
            }
            return isBST(root.getLeft());
        }
        if (root.getRight() != null) {
            if (root.getData() >= BinarySearchTreeNode.findMin(root.getRight()).getData()) {
                return false;
            }
            return isBST(root.getRight());
        }
        return true;
    }

    public static void main(String[] args) {
        BinarySearchTreeNode<Integer> treeNode1 = TreeNodeGenerators.fillSearchTree(10);
        print(isBST(treeNode1));
        BinarySearchTreeNode<Integer> treeNode2 = TreeNodeGenerators.generator();
        print(isBST(treeNode2));
    }
}
