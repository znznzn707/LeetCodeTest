package listnode;

import util.Builder;
import util.ListNodeBuilder;

/**
 * <a href="https://www.nowcoder.com/practice/1dc1036be38f45f19000e48abe00b12f?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">划分链表</a>
 */
public class Partition {
    /**
     *
     * @param head ListNode类
     * @param x int整型
     * @return ListNode类
     */
    public static ListNode partition (ListNode head, int x) {
        // write code here
        ListNode lowTail = new ListNode(-1);
        ListNode highTail = new ListNode(-1);
        ListNode cur = head;
        ListNode lowHead = lowTail;
        ListNode highHead = highTail;
        while (cur != null) {
            if(cur.val < x) {
                lowTail.next = cur;
                lowTail = cur;
            }else  {
                highTail.next = cur;
                highTail = cur;
            }
            cur = cur.next;
        }
        lowTail.next = highHead.next;
        highTail.next = null;
        return lowHead.next;
    }
    public static void main(String[] args) {
        Builder<ListNode> builder = new ListNodeBuilder();
        ListNode head = builder.deserialize("1,4,3,2,5,2");
        int x = 3;
        ListNode res = partition(head, x);
        System.out.println(builder.serialize(res)) ;
    }
}
