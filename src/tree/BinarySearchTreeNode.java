package tree;

import java.util.ArrayList;
import java.util.List;

import queue.Queue;

/**
 * 二叉搜索树：和一般二叉树没区别，区别在于数据，而不是结构
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

    public int size() {
        size = 0;
        return preOrder(this);
    }

    private int preOrder(BinarySearchTreeNode<T> treeNode) {
        if (treeNode != null) {
            size++;
            preOrder(treeNode.getLeft());
            preOrder(treeNode.getRight());
        }
        return size;
    }

    private void levelOrder(BinarySearchTreeNode<T> treeNode, List<T> list) {
        if (treeNode != null) {
            Queue<BinarySearchTreeNode<T>> queue = new Queue<>();
            queue.enQueue(treeNode);
            BinarySearchTreeNode<T> temp;
            while (!queue.isEmpty()) {
                temp = queue.deQueue();
                list.add(temp.getData());
                if (temp.getLeft() != null) {
                    queue.enQueue(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.enQueue(temp.getRight());
                }
            }
        }
    }

    @Override
    public String toString() {
        List<T> list = new ArrayList<>();
        levelOrder(this, list);
        return list.toString();
    }
}
