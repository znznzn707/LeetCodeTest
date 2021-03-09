package tree;

/**
 * <a href="https://www.nowcoder.com/practice/4582efa5ffe949cc80c136eeb78795d6?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">找出二叉搜索树中两个错误的节点</a>
 */
public class FindError {
    static int[] res = new int[2];
    static int cur = Integer.MIN_VALUE;
    /**
     *
     * @param root TreeNode类 the root
     * @return int整型一维数组
     */
    public static int[] findError (TreeNode root) {
        // write code here
          pre(root);
          return res;
    }
    public static void pre(TreeNode root) {
        if(root == null) return;
        pre(root.left);
        if(root.val < cur) {
            res[0] = root.val;
            res[1] = cur;
        }else {
            cur = root.val;
        }
        pre(root.right);
    }
}
