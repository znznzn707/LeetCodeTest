/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/02 15:50
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Partition {

    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode minHead = new ListNode(-1) ;
        ListNode maxHead = new ListNode(-1) ;
        ListNode curMin = minHead ;
        ListNode curMax = maxHead ;
        ListNode cur = pHead ;
        while (cur != null) {
            if(cur.val < x) {
                curMin.next = new ListNode(cur.val) ;
                curMin = curMin.next ;
            }
            else {
                curMax.next = new ListNode(cur.val) ;
                curMax = curMax.next ;
            }
            cur = cur.next ;
        }
        ListNode tail  = minHead;
        while (tail.next != null) {
            tail = tail.next ;
        }
        tail.next = maxHead.next ;
        return minHead.next ;
    }

    public static void main(String[] args) {
        //1,4,8,2,9,5,7,11
        ListNode phead = new ListNode(1) ;
        ListNode p2 = new ListNode(4);
        ListNode p3 = new ListNode(8);
        ListNode p4 = new ListNode(2);
        ListNode p5 = new ListNode(9);
        ListNode p6 = new ListNode(5);
        ListNode p7 = new ListNode(7);
        ListNode p8 = new ListNode(11);
        phead.next = p2;
        p2.next = p3 ;
        p3.next = p4 ;
        p4.next = p5 ;
        p5.next = p6;
        p6.next = p7 ;
        p7.next = p8;
        Partition partition = new Partition() ;
        ListNode node = partition.partition(phead, 6) ;
        while (node.next != null) {
            System.out.print(node.val+" -> ");
            node = node.next ;
        }
        System.out.println(node.val);
    }
}
