package tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import queue.Queue;

import static util.Print.print;

/**
 * @author tufei
 * @date 2018/1/3.
 */

public class TreeNodeGenerators {
    /**
     * 生成指定长度的二叉树
     *
     * @param length
     * @return
     */
    public static BinaryTreeNode<Integer> fill(int length) {
        if (length <= 0) {
            return null;
        }
        Queue<BinaryTreeNode<Integer>> queue = new Queue<>();
        BinaryTreeNode<Integer> head = new BinaryTreeNode<>();
        head.setData(1);
        queue.enQueue(head);
        for (int i = 2; i < length + 1; i++) {
            BinaryTreeNode<Integer> treeNode = new BinaryTreeNode<>();
            treeNode.setData(i);
            BinaryTreeNode<Integer> front = queue.front();
            if (front.getLeft() == null) {
                front.setLeft(treeNode);
            } else {
                front.setRight(treeNode);
                queue.deQueue();
            }
            queue.enQueue(treeNode);
        }
        return head;
    }

    /**
     * 按给定的数据集合，生成一个恰好能存储这些数据的链表
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> BinaryTreeNode<T> fill(List<T> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        Queue<BinaryTreeNode<T>> queue = new Queue<>();
        BinaryTreeNode<T> head = new BinaryTreeNode<>();
        head.setData(list.get(0));
        queue.enQueue(head);
        for (int i = 1; i < list.size(); i++) {
            BinaryTreeNode<T> treeNode = new BinaryTreeNode<>();
            treeNode.setData(list.get(i));
            BinaryTreeNode<T> front = queue.front();
            if (front.getLeft() == null) {
                front.setLeft(treeNode);
            } else {
                front.setRight(treeNode);
                queue.deQueue();
            }
            queue.enQueue(treeNode);
        }
        return head;
    }

    /**
     * 生成指定长度的二叉树
     *
     * @param length
     * @return
     */
    public static BinarySearchTreeNode<Integer> fillSearchTree(int length) {
        if (length <= 0) {
            return null;
        }
        Queue<BinarySearchTreeNode<Integer>> queue = new Queue<>();
        BinarySearchTreeNode<Integer> head = new BinarySearchTreeNode<>();
        head.setData(1);
        queue.enQueue(head);
        for (int i = 2; i < length + 1; i++) {
            BinarySearchTreeNode<Integer> treeNode = new BinarySearchTreeNode<>();
            treeNode.setData(i);
            BinarySearchTreeNode<Integer> front = queue.front();
            if (front.getLeft() == null) {
                front.setLeft(treeNode);
            } else {
                front.setRight(treeNode);
                queue.deQueue();
            }
            queue.enQueue(treeNode);
        }
        return head;
    }

    /**
     * 生成一个简单的BST树，用于测试
     * @return
     */
    public static BinarySearchTreeNode<Integer> generator() {
        BinarySearchTreeNode<Integer> treeNode = new BinarySearchTreeNode<>();
        treeNode.setData(5);
        BinarySearchTreeNode<Integer> treeNode1 = new BinarySearchTreeNode<>();
        treeNode1.setData(2);
        BinarySearchTreeNode<Integer> treeNode2 = new BinarySearchTreeNode<>();
        treeNode2.setData(6);
        BinarySearchTreeNode<Integer> treeNode3 = new BinarySearchTreeNode<>();
        treeNode3.setData(1);
        BinarySearchTreeNode<Integer> treeNode4 = new BinarySearchTreeNode<>();
        treeNode4.setData(3);
        BinarySearchTreeNode<Integer> treeNode5 = new BinarySearchTreeNode<>();
        treeNode5.setData(7);
        treeNode.setLeft(treeNode1);
        treeNode.setRight(treeNode2);
        treeNode1.setLeft(treeNode3);
        treeNode1.setRight(treeNode4);
        treeNode2.setRight(treeNode5);
        return treeNode;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> treeNode1 = TreeNodeGenerators.fill(0);
        print("生成的二叉树treeNode1的长度为：" + (treeNode1 == null ? 0 : treeNode1.size()));
        print(treeNode1);
        BinaryTreeNode<Integer> treeNode2 = TreeNodeGenerators.fill(10);
        print("生成的二叉树treeNode2的长度为：" + (treeNode2 == null ? 0 : treeNode2.size()));
        print(treeNode2);
        BinaryTreeNode<Object> treeNode3 = TreeNodeGenerators.fill(Collections.emptyList());
        print("生成的二叉树treeNode3的长度为：" + (treeNode3 == null ? 0 : treeNode3.size()));
        print(treeNode3);
        BinaryTreeNode<Integer> treeNode4 = TreeNodeGenerators.fill(Arrays.asList(1, 2, 3, 4, 5));
        print("生成的二叉树treeNode4的长度为：" + (treeNode4 == null ? 0 : treeNode4.size()));
        print(treeNode4);
    }
}
