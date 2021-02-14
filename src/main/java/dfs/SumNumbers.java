package dfs;

import tree.TreeNode;

/**
 * <a href="https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">二叉树根节点到叶节点的所有路径和</a>
 */

public class SumNumbers {
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int sumNumbers (TreeNode root) {
        // write code here
        if(root == null) return 0;
        return sumNumbersIntern(root,0);
    }
    private int sumNumbersIntern(TreeNode root, int sum) {
        if(root == null) return 0;
        sum = 10 * sum + root.val;
        if(root.left == null && root.right == null) return sum;
        return sumNumbersIntern(root.left,sum)
                + sumNumbersIntern(root.right,sum);
    }
}
