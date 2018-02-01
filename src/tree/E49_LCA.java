package tree;

/**
 * 问题49：已知二叉搜索树中指向两个结点的指针，寻找它们之间的最近公共祖先(LCA)
 * ,假定这两个值已经在这棵树中。
 *
 * @author tufei
 * @date 2018/2/1.
 */

public class E49_LCA {
    public static BinarySearchTreeNode<Integer> findLCA(BinarySearchTreeNode<Integer> root,
                                                        BinarySearchTreeNode<Integer> a,
                                                        BinarySearchTreeNode<Integer> b) {
        while (true) {
            if ((a.getData() < root.getData() && b.getData() > root.getData()) ||
                    (a.getData() > root.getData() && b.getData() < root.getData())) {
                return root;
            }
            if (a.getData() < root.getData()) {
                root = root.getLeft();
            } else {
                root = root.getRight();
            }
        }
    }
}


