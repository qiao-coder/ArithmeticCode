package tree;

import static util.Print.print;

/**
 * AVL树：BST树。对于任意结点，其左子树高度与其右子树高度的差最多
 * 不超过1。
 *
 * @author tufei
 * @date 2018/1/22.
 */

public class AVLTreeNode<T> {
    private T data;
    private AVLTreeNode<T> left;
    private AVLTreeNode<T> right;
    private int height;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AVLTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode<T> left) {
        this.left = left;
    }

    public AVLTreeNode<T> getRight() {
        return right;
    }

    public void setRight(AVLTreeNode<T> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 寻找元素
     *
     * @param root
     * @param data
     * @return
     */
    public static AVLTreeNode<Integer> find(AVLTreeNode<Integer> root, int data) {
        if (root == null) {
            return null;
        }
        if (root.getData() > data) {
            return find(root.getLeft(), data);
        }
        if (root.getData() < data) {
            return find(root.getRight(), data);
        }
        return root;
    }

    public static AVLTreeNode<Integer> findMin(AVLTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (root.getLeft() == null) {
            return root;
        } else {
            return findMin(root.getLeft());
        }
    }

    public static AVLTreeNode<Integer> findMax(AVLTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (root.getRight() == null) {
            return root;
        } else {
            return findMax(root.getRight());
        }
    }

    public static void main(String[] args) {
        AVLTreeNode<Integer> treeNode = new AVLTreeNode<>();
        treeNode.setData(5);
        AVLTreeNode<Integer> treeNode1 = new AVLTreeNode<>();
        treeNode1.setData(2);
        AVLTreeNode<Integer> treeNode2 = new AVLTreeNode<>();
        treeNode2.setData(6);
        AVLTreeNode<Integer> treeNode3 = new AVLTreeNode<>();
        treeNode3.setData(1);
        AVLTreeNode<Integer> treeNode4 = new AVLTreeNode<>();
        treeNode4.setData(3);
        AVLTreeNode<Integer> treeNode5 = new AVLTreeNode<>();
        treeNode5.setData(7);
        treeNode.setLeft(treeNode1);
        treeNode.setRight(treeNode2);
        treeNode1.setLeft(treeNode3);
        treeNode1.setRight(treeNode4);
        treeNode2.setRight(treeNode5);


        print(treeNode3.equals(find(treeNode, 2)));
        print(treeNode4.equals(find(treeNode, 7)));
        print(treeNode5.equals(find(treeNode, 7)));
        print("---------------------------------");
        print(treeNode2.equals(findMin(treeNode)));
        print(treeNode3.equals(findMin(treeNode)));
    }
}
