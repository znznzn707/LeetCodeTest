package util;

import listnode.ListNode;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/10/24 18:06
 * <p>用字符串构建二叉树{@link listnode.ListNode}、链表{@link listnode.ListNode}等复杂结构</p>
 */
    public final class Builder {

    /**
     * <pre>
     *        1
     *      /   \
     *     2     2
     *   /  \   / \
     *  3   #  #   3
     *
     * </pre>
     * <p>层次遍历构建二叉树</p>
     * @param str "1,2,2,3,#,#,3"
     * @return root
     */
    public static TreeNode buildTree(String str) {
        String[] strs = str.split(",");
        int n = strs.length;
        Queue<TreeNode> queue = new LinkedList<>() ;
        if("#".equals(strs[0])) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.add(root) ;
        int idx = 0;
        while (!queue.isEmpty() && idx < n-2) {
            TreeNode cur = queue.remove();
            String left = strs[++idx] ;
            String right = strs[++idx] ;
            if(cur != null) {
                if(!"#".equals(left))
                    cur.left = new TreeNode(Integer.parseInt(left));
                if(!"#".equals(right))
                    cur.right = new TreeNode(Integer.parseInt(right));
                queue.add(cur.left) ;
                queue.add(cur.right) ;
            }
        }
        return root;
    }

    /**
     * <pre>
     *     1->2->3->4->5
     * </pre>
     * @param s linkedlist string
     * @return listnode head 1
     */
    public static ListNode buildList(String s) {
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