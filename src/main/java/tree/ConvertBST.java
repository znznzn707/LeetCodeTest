package tree;

import util.Builder;
import util.TreeNodeBuilder;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3634/">Convert BST to Greater Tree</a>
 */
public class ConvertBST {
    //middleOrder
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            if(prev != null) cur.val += prev.val;
            prev = cur;
            cur = cur.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Builder<TreeNode> builder = new TreeNodeBuilder() ;
        TreeNode root = builder.deserialize("4,1,6,0,2,5,7,#,#,#,3,#,#,#,8");
        ConvertBST convertBST = new ConvertBST();
        TreeNode res = convertBST.convertBST(root);
        System.out.println(builder.serialize(res)) ;
    }
}
