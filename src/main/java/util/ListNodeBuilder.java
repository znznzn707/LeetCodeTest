package util;

import listnode.ListNode;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/10/27 17:12
 */
public class ListNodeBuilder implements Builder<ListNode> {

    /**
     * <pre>
     *     1->2->3->4->5
     * </pre>
     * @param s linkedlist string
     * @return listnode head 1
     */
    @Override
    public ListNode build(String s) {
        String[] strs = s.split("->") ;
        ListNode head = null ;
        ListNode tail = null ;
        for (int i = 0; i < strs.length; i++) {
            ListNode cur = new ListNode(Integer.parseInt(strs[i])) ;
            if(head == null) {
                tail = head = cur ;
            }else {
                tail.next = cur ;
                tail = cur ;
            }
        }
        return head;
    }
}
