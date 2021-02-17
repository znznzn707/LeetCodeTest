package tree;

/**
 * <a href="https://www.nowcoder.com/practice/da785ea0f64b442488c125b441a4ba4a?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">二叉树的最大路径和</a>
 */
public class MaxPathSum {
    private int res = Integer.MIN_VALUE;
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxPathSum (TreeNode root) {
        // write code here
        if(root == null) return 0;
        maxPathSumIntern(root);
        return res;
    }
    private int maxPathSumIntern(TreeNode root) {
        if(root == null) return 0 ;
        int left = Math.max(0, maxPathSumIntern(root.left));
        int right = Math.max(0, maxPathSumIntern(root.right));
        res = Math.max(res, Math.max(left + right + root.val
                , Math.max(left, right)+ root.val));
        return Math.max(left,  right) + root.val;
    }
}
