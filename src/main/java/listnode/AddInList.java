package listnode;

import java.util.List;
import java.util.ArrayList;
/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/09/25 19:52
 * <a href="https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=190&&tqId=35219&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking">两个链表生成相加链表</a>
 */
public class AddInList {
    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        int x = NodeToInt(head1) ;
        int y = NodeToInt(head2) ;
        return IntToNode(String.valueOf(x+y)) ;
    }
    public static int NodeToInt(ListNode head) {
        double count = 0 ;
        ListNode cur = head;
        List<Integer> list = new ArrayList<>() ;
        while(cur != null) {
            list.add(cur.val) ;
            count++ ;
            cur = cur.next ;
        }
        int x = (int )Math.pow(10, count-1);
        int y = 0 ;
        for(int i: list) {
            y += i * x ;
            x = x / 10;
        }
        return y;
    }
    public static ListNode IntToNode(String s) {
        ListNode head = null ;
        ListNode tail =  null;
        for(char ch: s.toCharArray()) {
            int x = Integer.valueOf(String.valueOf(ch));
            if(head == null) {
                head = new ListNode(x) ;
                tail = head;
            }else {
                ListNode newNode = new ListNode(x) ;
                tail.next = newNode ;
                tail = newNode;
            }
        }
        return head;
    }
}