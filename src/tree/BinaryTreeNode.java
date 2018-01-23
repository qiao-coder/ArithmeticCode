package tree;

import java.util.ArrayList;
import java.util.List;

import queue.Queue;

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

    private void levelOrder(BinaryTreeNode<T> treeNode, List<T> list) {
        if (treeNode != null) {
            Queue<BinaryTreeNode<T>> queue = new Queue<>();
            queue.enQueue(treeNode);
            BinaryTreeNode<T> temp;
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
