package linkedlist;

/**
 * 约瑟夫环
 *
 * @author tufei
 * @date 2018/1/2.
 */
class E41_JosephusRing {

    public static void getLeader(int M, int N) {
        LinkedList head = new LinkedList();
        head.setData(1);
        LinkedList last = head;
        for (int i = 2; i <= N; i++) {
            last.setNext(new LinkedList());
            if (i == N) {
                last.getNext().setNext(head);
            }
            last.getNext().setData(i);
            last = last.getNext();
        }
//        LinkedList temp = head;
        LinkedList temp = last;
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
        getLeader(2,1);
        getLeader(5,4);
    }
}/*Output:
领导是第4个人
领导是第5个人
领导是第1个人
领导是第3个人
领导是第1个人
领导是第2个人
*/