/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/04 16:37
 */


public class Plus {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode aHead = a ;
        ListNode bHead = b ;
        int x  ;
        ListNode tail  = null;
        ListNode head  = null;
        int count = 0;
        while (aHead != null || bHead != null) {
            x = 0 ;
            if(aHead != null) {
                x += aHead.val;
                aHead = aHead.next ;
            }
            if(bHead != null) {
                x += bHead.val;
                bHead = bHead.next ;
            }
            if(tail == null)
                head = tail = new ListNode((x+count) % 10);
            else {
                tail.next = new ListNode((x+ count) % 10);
                tail = tail.next ;
            }
            if (((count + x) / 10) > 0)
                count = 1;
            else
                count = 0;
        }
        if(count == 1)
            tail.next = new ListNode(1);
        return head ;
    }

    public static void main(String[] args) {
        Plus.ListNode a = new Plus.ListNode(7) ;
        Plus.ListNode a1 = new Plus.ListNode(4) ;
        Plus.ListNode a2 = new Plus.ListNode(0) ;
        Plus.ListNode a3 = new Plus.ListNode(7) ;
        Plus.ListNode a4 = new Plus.ListNode(5) ;
        Plus.ListNode b = new Plus.ListNode(2) ; ;
        Plus.ListNode b1 = new Plus.ListNode(7) ;
        Plus.ListNode b2 = new Plus.ListNode(2) ;
        Plus.ListNode b3 = new Plus.ListNode(3) ;
        Plus.ListNode b4 = new Plus.ListNode(4) ;
        a.next = a1; ;
        a1.next = a2 ;
        a2.next = a3 ;
        a3.next = a4 ;
        b.next = b1 ;
        b1.next = b2 ;
        b2.next = b3 ;
        b3.next = b4 ;
        ListNode c = plusAB(a, b) ;
        while (c != null) {
            System.out.print(c.val+ " ");
            c = c.next ;
        }
    }
}
