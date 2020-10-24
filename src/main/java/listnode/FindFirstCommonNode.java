package listnode;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/09/27 09:16
 * <a href="https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">两个链表的第一个公共节点</a>
 */
public class FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) p1 = pHead2;
                if (p2 == null) p2 = pHead1;
            }
        }
        return p1;

    }
}