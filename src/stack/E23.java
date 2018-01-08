package stack;

/**
 * 问题23 针对问题22，能否给出性能更优的方法
 *
 * @author tufei
 * @date 2018/1/8.
 */

public class E23 {
    /**
     * 时 间 复 杂 度 ： 数 组 中 的 每 个 下 标 入 栈 一 次 ， 并 且 最 多 出 栈 一 次 。所以 循 环 中 的 语 句 最 多
     * 执 行 n  次 。 尽 管 这 个 算 法 有 嵌 套 循 环 ， 但 算 法 在 整 个 执 行 过 程 中 内 层 循 环 只 执 行 n 次 ， 因
     * 此 算 法 的 时 间 复 杂 度 为 O( n )（ 可 跟 踪 一 个 例 子 来 统 计 内 层 循 环 成 功 执 行 了 多 少 次 ） 。 空 间
     * 复 杂 度 为  O( n )， 用 于 栈 空 间 开 销 。
     *
     * @param inputArray
     * @return
     */
    public static int[] findSpans(int[] inputArray) {
        int[] spansArray = new int[inputArray.length];
        Stack<Integer> stack = new Stack<>();
        int p;
        for (int i = 0; i < inputArray.length; i++) {
            while (!stack.isEmpty() && inputArray[i] > inputArray[stack.top()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                p = -1;
            } else {
                p = stack.top();
            }
            spansArray[i] = i - p;
            stack.push(i);
        }

        return spansArray;
    }

    public static void main(String[] args) {
        int[] spans = findSpans(new int[]{1, 3, 6, 3, 7, 5});
        for (int i = 0; i < spans.length; i++) {
            System.out.println(spans[i]);
        }
    }
}
