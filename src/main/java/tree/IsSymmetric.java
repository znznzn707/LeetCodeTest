package tree;


/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/10/23 20:37
 * <a href="https://www.nowcoder.com/questionTerminal/1b0b7f371eae4204bc4a7570c84c2de1">判断二叉树是否对称</a>
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricIntern(root, root) ;
    }
    public boolean isSymmetricIntern(TreeNode x, TreeNode y) {
        if(x == null && y == null) return true ;
        if((x == null && y != null) || x != null && y == null) return false;
        return x.val == y.val
                && isSymmetricIntern(x.left, y.right)
                && isSymmetricIntern(x.right, y.left);
    }
}
