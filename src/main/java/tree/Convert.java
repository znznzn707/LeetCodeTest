package tree;

import util.Builder;
import util.TreeNodeBuilder;

import java.util.Stack;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/06 14:59
 * <a href="https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">二叉搜索树与双向链表</a>
 */
public class Convert {

    public static TreeNode Convert(TreeNode root) {
        Stack<tree.TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode head = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(cur != null) {
                if (pre == null) head = pre = cur;
                else {
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }
                cur = cur.right;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        Builder<TreeNode> builder = new TreeNodeBuilder();
        TreeNode root = builder.deserialize("5,3,8,2,4,7,10");
        root = Convert(root);
        TreeNode cur = root;
        while (cur != null && cur.right != null) {
            System.out.print(cur.val+" ") ;
            cur = cur.right;
        }
        System.out.println(cur.val) ;
        while (cur != null) {
            System.out.print(cur.val+" ") ;
            cur = cur.left;
        }
        System.out.println() ;
    }
}
