package listnode;

import util.Builder;
import util.ListNodeBuilder;

/**
 * <a href="https://www.nowcoder.com/practice/02bf49ea45cd486daa031614f9bd6fc3?tpId=190&tqId=36037&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey">链表的奇偶重排</a>
 */
public class OddEvenList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode oddEvenList (ListNode head) {
        // write code here
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddTail = head;
        ListNode evenTail = head.next;
        while (evenTail != null && evenTail.next != null) {
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }
        oddTail.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        Builder<ListNode> builder = new ListNodeBuilder();
        ListNode head = builder.deserialize("1,2,3,4,5,6");
        System.out.println(builder.serialize(oddEvenList(head))) ;
    }
}
