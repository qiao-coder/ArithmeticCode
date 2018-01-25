package tree;

import java.util.Arrays;

import static util.Print.print;

/**
 * 问题6：给出获取二叉树结点个数的算法
 * @author tufei
 * @date 2018/1/25.
 */

public class E6_size {
    public static <T> int getSize(BinaryTreeNode<T> treeNode){
        if(treeNode == null){
            return 0;
        }
        return getSize(treeNode.getLeft())+1+getSize(treeNode.getRight());
    }

    public static void main(String[] args){
        BinaryTreeNode<Integer> treeNode = TreeNodeGenerators.fill(10);
        print(getSize(treeNode));
        BinaryTreeNode<String> treeNode1 = TreeNodeGenerators.fill(Arrays.asList("a", "b", "c", "d", "e"));
        print(getSize(treeNode1));
    }
}
