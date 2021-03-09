package tree;

/**
 * <a href="https://www.nowcoder.com/practice/4eaccec5ee8f4fe8a4309463b807a542?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey"></a>
 */
public class IsContains {
    /**
     *
     * @param root1 TreeNode类
     * @param root2 TreeNode类
     * @return bool布尔型
     */
    public boolean isContains (TreeNode root1, TreeNode root2) {
        // write code here
        if(root1==null){
            return false;
        }
        return isContains(root1.left,root2) || isContains(root1.right,root2) || isSubTree(root1,root2);
    }

    public boolean isSubTree(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null || root1.val!=root2.val){
            return false;
        }
        return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
    }
}
