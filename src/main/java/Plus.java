import listnode.ListNode;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/04 16:37
 */


public class Plus {
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
        ListNode a = new ListNode(7) ;
        ListNode a1 = new ListNode(4) ;
        ListNode a2 = new ListNode(0) ;
        ListNode a3 = new ListNode(7) ;
        ListNode a4 = new ListNode(5) ;
        ListNode b = new ListNode(2) ; ;
        ListNode b1 = new ListNode(7) ;
        ListNode b2 = new ListNode(2) ;
        ListNode b3 = new ListNode(3) ;
        ListNode b4 = new ListNode(4) ;
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
