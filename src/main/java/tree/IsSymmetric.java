package tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/10/23 20:37
 * <a href="https://www.nowcoder.com/questionTerminal/1b0b7f371eae4204bc4a7570c84c2de1">判断二叉树是否对称</a>
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricIntern(root, root) ;
    }
    public boolean isSymmetricIntern(TreeNode x, TreeNode y) {
        if(x == null && y == null) return true ;
        if(x == null  || y == null) return false;
        return x.val == y.val
                && isSymmetricIntern(x.left, y.right)
                && isSymmetricIntern(x.right, y.left);
    }
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            queue.offer(left.right);
            queue.offer(right.left);
            queue.offer(left.left) ;
            queue.offer(right.right) ;
        }
        return true;
    }
}
