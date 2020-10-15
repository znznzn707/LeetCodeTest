package tree;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/09/27 09:39
 * <a href="https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">在二叉树中找到两个节点的最近公共祖先节点</a>
 */
public class LowestCommonAncestor {

  static final class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }

    /**
     *
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        return commonAncestor(root, o1, o2).val ;
    }

    public TreeNode commonAncestor(TreeNode root, int o1, int o2) {
        if(root == null|| root.val == o1 || root.val == o2) return root;
        TreeNode left = commonAncestor(root.left, o1, o2) ;
        TreeNode right = commonAncestor(root.right, o1, o2) ;
        if(left == null) {
            return right ;
        }
        if(right == null) {
            return left ;
        }
        return root;
    }
}

