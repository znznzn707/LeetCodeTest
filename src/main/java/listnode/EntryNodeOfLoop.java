package listnode;

import java.util.HashSet;
/**
 * <a href="https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&&tqId=11208&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">链表中环的入口节点</a>
 */
public class EntryNodeOfLoop {
    //1. Hash
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode cur = pHead;
        while (cur != null) {
            if (!set.contains(cur)) set.add(cur);
            else return cur;
            cur = cur.next;
        }
        return null;
    }
    //2. 双指针
    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        ListNode fast = pHead;
        ListNode low = pHead;
        while(fast != null && fast.next != null ) {
            fast = fast.next.next;
            low = low.next ;
            if(low == fast) break;
        }
        if(fast == null || fast.next == null) return null ;
        fast = pHead ;
        while(fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return fast;
    }
}
