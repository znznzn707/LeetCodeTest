package listnode;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/09/24 19:22
 * <a href="https://www.nowcoder.com/practice/f95dcdafbde44b22a6d741baf71653f6?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">删除链表的倒数第n个节点</a>
 * <pre>
 *    可以通过快指针先走K步 慢指针先指向head，导致 快指针和慢指针相差K个结点，
 *    然后快指针移到末尾 这个时候慢指针就是倒数第K个结点了。
 * 然后在遍历的时候 记录下慢指针的前一个结点，用来删除就OK了。
 * </pre>
 */
public class RemoveNthFromEnd {

    static final class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here

        ListNode slow = head ;
        ListNode fast = head ;
        for(int i = 0; i < n; i++) fast = fast.next;
        if(fast == null) return head.next;  //重要代码
        while(fast.next != null) {
            fast = fast.next ;
            slow = slow.next ;
        }
        slow.next = slow.next.next;
        return head;
    }
}
