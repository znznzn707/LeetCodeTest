package listnode;

import java.util.Stack;

/**
 * <a href="https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">两个链表生成相加链表</a>
 */
public class AddInList {
    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        int carry = 0;
        ListNode cur = head1;
        ListNode head = null;
        while(cur != null){
            s1.push(cur);
            cur = cur.next ;
        }
        cur = head2;
        while(cur != null) {
            s2.push(cur);
            cur = cur.next;
        }
        while(!s1.empty() || !s2.empty()|| carry!= 0) {
            int sum = 0 ;
            if(!s1.empty()) sum += s1.pop().val;
            if(!s2.empty()) sum += s2.pop().val;
            sum += carry;
            if(sum > 9) carry = sum / 10;
            else  carry = 0;
            ListNode newNode = new ListNode(sum % 10);
            if(head != null)   newNode.next = head;
            head = newNode;
        }
        return head;
    }
}
