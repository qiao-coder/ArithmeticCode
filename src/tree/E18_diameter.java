package tree;

import static util.Print.print;

/**
 * 问题18：求二叉树直径的算法。树的直径（有时也叫作树的宽度）就是树中两个叶子
 * 结点之间的最长路径中的结点个数。
 * 参考：https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 *
 * @author tufei
 * @date 2018/1/28.
 */

public class E18_diameter {

    static class Height {
        int h;
    }

    //解法一：
    public static <T> int diameter(BinaryTreeNode<T> treeNode) {
        return diameter(treeNode, new Height());
    }

    private static <T> int diameter(BinaryTreeNode<T> treeNode, Height height) {
        if (treeNode == null) {
            height.h = 0;
            return 0;
        }
        Height lh = new Height(), rh = new Height();
         /* ldiameter  --> diameter of left subtree
           rdiameter  --> Diameter of right subtree */
        /* Get the heights of left and right subtrees in lh and rh
         And store the returned values in ldiameter and ldiameter */
        lh.h++;     rh.h++;
        int ldiameter = diameter(treeNode.getLeft(), lh);
        int rdiameter = diameter(treeNode.getRight(), rh);
         /* Height of current node is max of heights of left and
         right subtrees plus 1*/
        height.h = Math.max(lh.h, rh.h) + 1;
        return Math.max(lh.h + rh.h, Math.max(ldiameter, rdiameter));
    }

    //解法二：
    static int diameter = 0;
    public static <T> int diameterOfBinaryTree(BinaryTreeNode<T> root){
        diameter = 0;
        getDiameter(root);
        return diameter;
    }

    private static <T> int getDiameter(BinaryTreeNode<T> root) {
        if(root == null){
            return 0;
        }
        int left = getDiameter(root.getLeft());
        int right = getDiameter(root.getRight());
        diameter = Math.max(diameter,left+right);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> treeNode1 = TreeNodeGenerators.fill(11);
        print(diameter(treeNode1));
        print(diameterOfBinaryTree(treeNode1));
        BinaryTreeNode<Integer> treeNode2 = TreeNodeGenerators.fill(12);
        print(diameter(treeNode2));
        print(diameterOfBinaryTree(treeNode2));
    }
}
