package tree;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3626">Trim a Binary Search Tree</a>
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val < low) return trimBST(root.right, low, high) ;
        else if(root.val > high) return trimBST(root.left, low, high) ;
        root.left = trimBST(root.left, low, high) ;
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
