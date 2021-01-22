package listnode;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/10/24 20:44
 */
public class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode(int val) {
        this.val = val ;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
