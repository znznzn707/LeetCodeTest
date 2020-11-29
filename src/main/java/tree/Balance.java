package tree;

import tree.TreeNode;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/09 16:45
 * <a href="https://www.nowcoder.com/questionTerminal/b6bbed48cd864cf09a34a6ca14a3976f">二叉树平衡检查</a>
 */

public class Balance {
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root == null)
            return true ;
        int left = getTreeWeight(root.left) ;
        int right = getTreeWeight(root.right) ;
        if(Math.abs(left - right) > 1)
            return false ;
        return isBalance(root.left) && isBalance(root.right) ;
    }
    public int getTreeWeight(TreeNode root) {
        if(root == null)
            return 0 ;
        return Math.max(getTreeWeight(root.left), getTreeWeight(root.right)) + 1 ;
    }
}
