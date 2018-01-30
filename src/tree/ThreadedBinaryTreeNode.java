package tree;

import static util.Print.print;

/**
 * 线索二叉树
 * @author tufei
 * @date 2018/1/30.
 */

public class ThreadedBinaryTreeNode<T> {
    private T data;
    private ThreadedBinaryTreeNode<T> left;
    private ThreadedBinaryTreeNode<T> right;
    private int LTag;
    private int RTag;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ThreadedBinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(ThreadedBinaryTreeNode<T> left) {
        this.left = left;
    }

    public ThreadedBinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(ThreadedBinaryTreeNode<T> right) {
        this.right = right;
    }


    public int getLTag() {
        return LTag;
    }

    public void setLTag(int LTag) {
        this.LTag = LTag;
    }

    public int getRTag() {
        return RTag;
    }

    public void setRTag(int RTag) {
        this.RTag = RTag;
    }

    /**
     * 中序线索二叉树的中序遍历
     *
     * @param root
     */
    public void inorderTraversal(ThreadedBinaryTreeNode<T> root) {
        ThreadedBinaryTreeNode<T> p = inorderSuccessor(root);
        while (p != root) {
            p = inorderSuccessor(p);
            print(p.getData());
        }
    }

    /**
     * 另一种实现方式
     *
     * @param root
     */
    public void inorderTraversal_2(ThreadedBinaryTreeNode<T> root) {
        ThreadedBinaryTreeNode<T> p = root;
        while (true) {
            p = inorderSuccessor(p);
            if (p == root) {
                return;
            }
            print(p.getData());
        }
    }

    /**
     * 在中序线索二叉树中查找中序后继
     *
     * @param p
     * @param <T>
     * @return
     */
    private static <T> ThreadedBinaryTreeNode<T> inorderSuccessor(ThreadedBinaryTreeNode<T> p) {
        ThreadedBinaryTreeNode<T> postion;
        if (p.getRTag() == 0) {
            return p.getRight();
        } else {
            postion = p.getRight();
            while (postion.getLTag() == 1) {
                postion = postion.getLeft();
            }
            return postion;
        }
    }


    /**
     * 中序线索二叉树的前序遍历
     *
     * @param root
     * @param <T>
     */
    public static <T> void preorderTraversal(ThreadedBinaryTreeNode<T> root) {
        ThreadedBinaryTreeNode<T> p;
        p = preorderSuccessor(root);
        while (p != root) {
            p = preorderSuccessor(p);
            print(p.getData());
        }
    }

    /**
     * 另一种实现方式
     *
     * @param root
     * @param <T>
     */
    public static <T> void preorderTraversal_2(ThreadedBinaryTreeNode<T> root) {
        ThreadedBinaryTreeNode<T> p = root;
        while (true) {
            p = preorderSuccessor(p);
            if (p == root) {
                return;
            }
            print(p.getData());
        }
    }


    /**
     * 中序线索二叉树中查找前序后继
     *
     * @param p
     * @param <T>
     * @return
     */
    private static <T> ThreadedBinaryTreeNode<T> preorderSuccessor(ThreadedBinaryTreeNode<T> p) {
        ThreadedBinaryTreeNode<T> position;
        if (p.getLTag() == 1) {
            return p.getLeft();
        } else {
            position = p;
            while (position.getRTag() == 0) {
                position = position.getRight();
            }
            return position.getRight();
        }
    }

    /**
     * 在中序线索二叉树中插入结点
     *
     * @param p
     * @param q
     * @param <T>
     */
    public static <T> void insertRightInInorderTBT(ThreadedBinaryTreeNode<T> p, ThreadedBinaryTreeNode<T> q) {
        ThreadedBinaryTreeNode<T> temp;
        q.setRight(p.getRight());
        q.setRTag(p.getRTag());
        q.setLeft(p);
        q.setLTag(0);
        p.setRight(q);
        p.setRTag(1);
        //第二种情况
        if (q.getRTag() == 1) {
            temp = q.getRight();
            while (temp.getLTag() == 1) {
                temp = temp.getLeft();
            }
            temp.setLeft(q);
        }
    }
}
