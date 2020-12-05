package tree;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/12/02 16:34
 * <a href="https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">二叉树的深度</a>
 * <pre>
 * 题目描述:
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * </pre>
 */
public class TreeDepth {
    public int treeDepth(TreeNode root) {
        if(root == null) return 0;
        int left = treeDepth(root.left) ;
        int right = treeDepth(root.right) ;
        return Math.max(left, right) + 1;
    }
}
