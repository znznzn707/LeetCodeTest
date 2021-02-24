package listnode;

import util.Builder;
import util.ListNodeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.nowcoder.com/practice/3d281dc0b3704347846a110bf561ef6b?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">重排链表</a>
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        if(cur == null) return;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        int left = 0, right = nodes.size()-1;
        while (left < right) {
            nodes.get(left).next = nodes.get(right);
            ++left;
            if(left == right) break;
            nodes.get(right).next = nodes.get(left);
            --right;
        }
        nodes.get(left).next = null;
    }

    public static void main(String[] args) {
        Builder<ListNode> builder = new ListNodeBuilder();
        ListNode head = builder.deserialize("10,20,30,40,50,60,70");
        reorderList(head);
        System.out.println(builder.serialize(head)) ;
    }
}