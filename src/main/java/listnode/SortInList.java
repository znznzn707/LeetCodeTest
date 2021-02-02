package listnode;

import util.Builder;
import util.ListNodeBuilder;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://www.nowcoder.com/practice/f23604257af94d939848729b1a5cda08?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">单链表排序</a>
 */
public class SortInList {
    public ListNode sortInList (ListNode head) {
        // write code here
        Comparator<ListNode> comp = (x, y) -> (x.val < y.val)? -1 : (x.val == y.val)? 0 : 1;
        Queue<ListNode> queue = new PriorityQueue<>(comp);
        ListNode cur = head;
        while (cur != null) {
            queue.offer(cur);
            cur = cur.next;
        }
        cur = queue.poll();
        while (!queue.isEmpty()) {
            ListNode pre = queue.poll();
            cur.next = pre;
            cur = pre;
        }
        return cur;
    }

    public static void main(String[] args) {
        Builder<ListNode> builder = new ListNodeBuilder();
        ListNode root = builder.deserialize("1,3,2,4,5");
        SortInList sortInList = new SortInList();
        sortInList.sortInList(root) ;
        String s = builder.serialize(root);
        System.out.println(s) ;
    }
}
