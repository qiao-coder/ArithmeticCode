package linkedlist;

/**
 * 问 題 41  约 瑟 夫 环 ： N 个 人 想 选 出 一 个 领 头 人 ， 他 们 排 成 一 个 环 ， 沿 着 环 每 数 到 第
 * M 个 人 就 从 环 中 排 除 该 人 ， 并 从 下 一 个 人 开 始 重 新 数 。 请 找 出 最 后 留 在 环 中 的 人 。
 *
 * @author tufei
 * @date 2018/1/2.
 */
public class E41_JosephusRing {

    public static void getLeader(int M, int N) {
        LinkedList<Integer> head = new LinkedList<>();
        head.setData(1);
        LinkedList<Integer> last = head;
        for (int i = 2; i <= N; i++) {
            last.setNext(new LinkedList<Integer>());
            if (i == N) {
                last.getNext().setNext(head);
            }
            last.getNext().setData(i);
            last = last.getNext();
        }
//        LinkedList temp = head;
        LinkedList<Integer> temp = last;
        for (int i = N; i > 1; i--) {
            //如果M为1，直接拿链表最末尾的结点
//            if (M == 1) {
//                for (int j = 1; j < N; j++) {
//                    temp = temp.getNext();
//                }
//                break;
//            } else {
            for (int k = 0; k < M - 1; k++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
//            }
        }
        System.out.println("领导是第" + temp.getData() + "个人");
    }

    public static void main(String[] args) {
        getLeader(1, 4);
        getLeader(1, 5);
        getLeader(2, 4);
        getLeader(2, 5);
        getLeader(2, 1);
        getLeader(5, 4);
    }
}/*Output:
领导是第4个人
领导是第5个人
领导是第1个人
领导是第3个人
领导是第1个人
领导是第2个人
*/