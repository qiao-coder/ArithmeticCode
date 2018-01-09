package stack;


import java.util.Arrays;

/**
 * 问 题 27 删 除 所 有 相 邻 的 重 复 元 素 ： 给 定 一 个 数 字 数 组 ， 删 除 相 邻 的 重 复 数 字 ， 结
 * 果 数 组 中 不 能 有 任 何 相 邻 的 重 复 数 字 。
 *
 * @author tufei
 * @date 2018/1/9.
 */

public class E27 {

    private static int index;

    //自己写的
    public static int[] filterArray(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int length = 0;
        Integer lastPop = null;
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            while (!stack.isEmpty() && (stack.top() == temp)) {
                lastPop = stack.pop();
                length--;
            }
            if (lastPop != null && lastPop == temp) {
                continue;
            }
            length++;
            lastPop = null;
            stack.push(temp);
        }

        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[length - i - 1] = stack.pop();
        }
        return newArray;
    }

    //书中的
    public static int[] removeAdjacentDuplicates(int[] A) {
        index = remove(A);
        int[] newArray = new int[index + 1];
        for (int i = 0; i <= index; i++) {
            newArray[i] = A[i];
        }
        return newArray;
    }

    private static int remove(int[] A) {
        int stkptr = -1;
        int i = 0;
        while (i < A.length) {
            if (stkptr == -1 || A[stkptr] != A[i]) {
                stkptr++;
                A[stkptr] = A[i];
                i++;
            } else {
                while (i < A.length && A[stkptr] == A[i]) {
                    i++;
                }
                stkptr--;
            }
        }
        return stkptr;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 3, 3, 4, 5, 4, 6, 6};

        //解法一：
        int[] filterArray = filterArray(array);
        System.out.println(Arrays.toString(filterArray));

        //解法二
        int[] array1 = removeAdjacentDuplicates(array);
        System.out.println(Arrays.toString(array1));

        int[] A = {1, 5, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5};

        //解法一：
        int[] filterArray2 = filterArray(A);
        System.out.println(Arrays.toString(filterArray2));

        //解法二
        int[] array2 = removeAdjacentDuplicates(A);
        System.out.println(Arrays.toString(array2));

        //打印数组的方式，应该使用Arrays.toString(arg)
//        int[] arrays = {1, 2, 2, 3};
//        System.out.println("arrays:"+Arrays.asList(arrays));
//        System.out.println("arrays:"+Arrays.toString(arrays));
//
//        String[] names = { "Georgianna", "Tenn", "Simon", "Tom" };
//        System.out.println("names:"+Arrays.asList(names));
//        System.out.println("names:"+Arrays.toString(names));
    }
}
