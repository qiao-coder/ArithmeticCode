package tree;

import static util.Print.print;

/**
 * 问题8：实现删除树的算法
 *
 * @author tufei
 * @date 2018/1/25.
 */

public class E8_delete {
    /**
     * 书中就是这样写
     *
     * @param treeNode
     * @param <T>
     */
    public static <T> void delete(BinaryTreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        delete(treeNode.getLeft());
        delete(treeNode.getRight());
        //书里说什么，将由java垃圾回收器进行清理
        //但是，传递进方法里的，只是一个拷贝的引用啊，外面还是存在引用指向那个实例
        // 这样子根本不算删除，由测试方法的输出结果可以看出来

        //如果加上屏蔽掉的代码，也只能删除到只剩一个根结点
//        if (treeNode.getLeft() != null) {
//            treeNode.setLeft(null);
//        }
//        if (treeNode.getRight() != null) {
//            treeNode.setRight(null);
//        }

        treeNode = null;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> treeNode = TreeNodeGenerators.fill(10);
        delete(treeNode);
        print(treeNode);
    }
}
