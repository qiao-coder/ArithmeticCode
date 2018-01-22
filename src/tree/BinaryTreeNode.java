package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tufei
 * @date 2018/1/22.
 */

public class BinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    private int size;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public int size() {
        size = 0;
        return preOrder(this);
    }

    private int preOrder(BinaryTreeNode<T> treeNode) {
        if (treeNode != null) {
            size++;
            preOrder(treeNode.getLeft());
            preOrder(treeNode.getRight());
        }
        return size;
    }

    private void preOrder(BinaryTreeNode<T> treeNode, List<T> list) {
        if (treeNode != null) {
            list.add(treeNode.getData());
            preOrder(treeNode.getLeft(), list);
            preOrder(treeNode.getRight(), list);
        }
    }

    @Override
    public String toString() {
        ArrayList<T> list = new ArrayList<>();
        preOrder(this, list);
        return list.toString();
    }
}
