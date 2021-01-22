package listnode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solution/">remove-duplicates-from-sorted-list-ii</a>
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head); //Figure 1. The list head is to be removed.
        ListNode pred = sentinel;
        while(head != null) {
            if(head.next != null && head.next.val == head.val){
                while(head.next != null && head.next.val == head.val) {head = head.next; }
                pred.next = head.next;
            }else pred = pred.next;
            head = head.next;
        }
        return sentinel.next;
    }
}
