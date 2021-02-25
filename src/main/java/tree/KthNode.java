package tree;

import util.Builder;
import util.TreeNodeBuilder;

import java.util.Stack;

/**
 * <a href="https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">二叉搜索树的第K个节点</a>
 */
public class KthNode {
    public static TreeNode KthNode(TreeNode pRoot, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(--k == 0) return cur;
            cur = cur.right;
        }
        return null;
    }

    public static void main(String[] args) {
        Builder<TreeNode> builder = new TreeNodeBuilder();
        TreeNode root = builder.deserialize("5,3,7,2,4,6,8");
        int k = 3;
        TreeNode res = KthNode(root, k);
        System.out.println(res.val) ;
    }
}
