package listnode;

/**
 * <a href="https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">反转链表</a>
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode cur = null;
        ListNode pre = null;
        while(head != null) {
            pre = head.next ;
            head.next = cur;
            cur = head;
            head = pre;
        }
        return cur;
    }
}
