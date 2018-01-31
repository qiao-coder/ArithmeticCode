package tree;

import static util.Print.print;

/**
 * 二叉搜索树：和一般二叉树没区别，区别在于数据，而不是结构
 *
 * @author tufei
 * @date 2018/1/22.
 */

public class BinarySearchTreeNode<T> {
    private T data;
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;
    private int size;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinarySearchTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode<T> left) {
        this.left = left;
    }

    public BinarySearchTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode<T> right) {
        this.right = right;
    }

    /**
     * 寻找元素
     *
     * @param root
     * @param data
     * @return
     */
    public static BinarySearchTreeNode<Integer> find(BinarySearchTreeNode<Integer> root, int data) {
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

    public static BinarySearchTreeNode<Integer> findMin(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (root.getLeft() == null) {
            return root;
        } else {
            return findMin(root.getLeft());
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeNode<Integer> treeNode = new BinarySearchTreeNode<>();
        treeNode.setData(5);
        BinarySearchTreeNode<Integer> treeNode1 = new BinarySearchTreeNode<>();
        treeNode1.setData(4);
        BinarySearchTreeNode<Integer> treeNode2 = new BinarySearchTreeNode<>();
        treeNode2.setData(6);
        BinarySearchTreeNode<Integer> treeNode3 = new BinarySearchTreeNode<>();
        treeNode3.setData(2);
        BinarySearchTreeNode<Integer> treeNode4 = new BinarySearchTreeNode<>();
        treeNode4.setData(3);
        BinarySearchTreeNode<Integer> treeNode5 = new BinarySearchTreeNode<>();
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
