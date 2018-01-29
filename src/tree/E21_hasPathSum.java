package tree;

import static util.Print.print;

/**
 * 问题21：给出一个算法，判断是否存在路径的数据和等于给定值。也就是说，判断是否
 * 存在一条从根结点到任意结点的路径，其所经过结点的数据和为给定值。
 *
 * @author tufei
 * @date 2018/1/29.
 */

public class E21_hasPathSum {
    public static boolean hasPathSum(BinaryTreeNode<Integer> root, int sum) {
        if (sum == 0) {
            return true;
        }
        if (root == null) {
            return (sum == 0);
        } else {
            int subSum = sum - root.getData();
            return (hasPathSum(root.getLeft(), subSum) || hasPathSum(root.getRight(), subSum));
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> treeNode1 = TreeNodeGenerators.fill(10);
        print(hasPathSum(treeNode1, 3));
        print(hasPathSum(treeNode1, 4));
        print(hasPathSum(treeNode1, 7));
        print(hasPathSum(treeNode1, 9));

    }
}
