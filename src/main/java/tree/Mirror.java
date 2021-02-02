package tree;

import util.Builder;
import util.TreeNodeBuilder;

/**
 * <a href="https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">二叉树的镜像</a>
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {
        Builder<TreeNode> builder = new TreeNodeBuilder();
        TreeNode root= builder.deserialize("8,6,10,5,7,9,11");
        Mirror mirror = new Mirror();
        mirror.Mirror(root);
        System.out.println(builder.serialize(root)) ;
    }
}
