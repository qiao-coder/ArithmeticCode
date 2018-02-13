package adt;

/**
 * 并查集ADT：快速UNION实现(慢FIND)
 *
 * @author tufei
 * @date 2018/2/13.
 */

public class DisjoinSet {
    public int[] s;
    public int size;

    public void makeset(int size) {
        s = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            s[i] = i;
        }
    }

    /**
     * 查找树的根结点
     * 书中的是写法就是这样，明显有误
     */
    public int find(int x) {
        throw new IllegalArgumentException();
//        if(!(x>=0&&x<size)){
//            throw new IllegalArgumentException();
//        }
//        if(s[x] == x){
//            return x;
//        }else {
//            return find(s,s[x])
//        }
    }

    public void union(int root1, int root2) {
        if (find(root1) == find(root2)) {
            return;
        }
        if (!((root1 >= 0 && root1 < size) && (root1 >= 0 && root1 < size))) {
            return;
        }
        s[root1] = root2;
    }
}
