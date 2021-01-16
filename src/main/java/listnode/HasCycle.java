package listnode;

/**
 * <a href="https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">判断链表中是否有环</a>
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null|| head.next.next == null) return false;
        ListNode fast = head ;
        ListNode slow = head ;
        while(fast != null && fast.next != null) {
            fast = fast.next.next ;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
