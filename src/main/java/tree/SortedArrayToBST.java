package tree;

/**
 * <a href="https://www.nowcoder.com/practice/7e5b00f94b254da599a9472fe5ab283d?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">升序数组转化为平衡二叉树</a>
 */
public class SortedArrayToBST {
    /**
     *
     * @param num int整型一维数组
     * @return TreeNode类
     */
    public TreeNode sortedArrayToBST (int[] num) {
        // write code here
        if(num == null || num.length == 0) return null;
        return buildBST(num, 0, num.length-1);
    }
    public TreeNode buildBST(int[] num, int left, int right) {
        if(left > right) return null;
        int mid = 1+ (left+right) >> 1 ;
        TreeNode leftNode = buildBST(num, left, mid-1);
        TreeNode rightNode = buildBST(num, mid+1, right);
        TreeNode root = new TreeNode(num[mid]);
        root.left = leftNode;
        root.right=  rightNode;
        return root;
    }
}
