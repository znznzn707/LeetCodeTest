package listnode;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/09/25 20:48
 * <a href="https://www.nowcoder.com/practice/6e630519bf86480296d0f1c868d425ad?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">链表中环的入口节点</a>
 *  [*]
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next ;
            slow = slow.next;

            if(fast == slow){                 //利用快慢指针找相遇点
                ListNode slow2 = head;    //设置以相同速度的新指针从起始位置出发
                while(slow2 != slow){      //未相遇循环。
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
