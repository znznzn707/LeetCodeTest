package tree;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/06 14:59
 * <a href="https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">二叉搜索树与双向链表</a>
 */
public class Convert {
    TreeNode pre ;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null ;
        Convert(pRootOfTree.right);
        if(pre != null) {
            pRootOfTree.right = pre;
            pre.left = pRootOfTree ;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.left);
        return pre;
    }
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
