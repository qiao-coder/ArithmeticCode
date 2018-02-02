package tree;

import static util.Print.print;

/**
 * 问题53：降低问题50的复杂度
 *
 * @author tufei
 * @date 2018/2/2.
 */

public class E53_isBST {
    static int pre = Integer.MIN_VALUE;

    public static boolean isBST(BinarySearchTreeNode<Integer> root) {
        pre = Integer.MIN_VALUE;
        return checkBST(root);
    }

    /**
     * 中序遍历产生有序表
     * @param root
     * @return
     */
    private static boolean checkBST(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        if (!checkBST(root.getLeft())) {
            return false;
        }
        if (root.getData() <= pre) {
            return false;
        }
        pre = root.getData();
        return checkBST(root.getRight());
    }

    public static void main(String[] args){
        BinarySearchTreeNode<Integer> treeNode = TreeNodeGenerators.generator();
        print(isBST(treeNode));
    }
}
