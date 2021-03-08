package tree;

import util.Builder;
import util.TreeNodeBuilder;

public class BuildTree {

    //给出先序和中序构件二叉树
    public static TreeNode buildTreeWithPreAndMiddle(String pre, String middle) {
        if(pre.length() == 0) return null;
        TreeNode root = new TreeNode(pre.charAt(0));
        int i ;
        for (i = 0; i < middle.length(); ++i) {
            if(middle.charAt(i) == pre.charAt(0)) break;
        }
        root.left = buildTreeWithPreAndMiddle(pre.substring(1, i+1), middle.substring(0, i));
        root.right = buildTreeWithPreAndMiddle(pre.substring(i+1), middle.substring(i+1));
        return root;
    }
    //给出中序和后序构建二叉树
    public static TreeNode buildTreeWithMiddleAndPost(String middle, String post) {
        if(post.length() == 0) return null;
        char ch = post.charAt(post.length()-1);
        TreeNode root = new TreeNode(ch);
        int i ;
        for (i = 0; i < middle.length(); ++i) {
            if(ch == middle.charAt(i)) break;
        }
        root.left = buildTreeWithMiddleAndPost(middle.substring(0, i), post.substring(0, i));
        root.right = buildTreeWithMiddleAndPost(middle.substring(i+1), post.substring(i, post.length()-1));
        return root;
    }
    /*
    public static void main(String[] args) {
        String pre = "ADFGHKLPQRWZ";
        String middle = "GFHKDLAWRQPZ";
        TreeNode root = buildTreeWithPreAndMiddle(pre, middle);
        Builder<TreeNode> builder = new TreeNodeBuilder();
        String s = builder.serialize(root);
        System.out.println(s) ;
    }
    */
    public static void main(String[] args) {
        String middle = "ABCDEFG";
        String post = "BDCAFGE";
        TreeNode root = buildTreeWithMiddleAndPost(middle, post);
        Builder<TreeNode> builder = new TreeNodeBuilder();
        String s = builder.serialize(root);
        System.out.println(s) ;
    }
}
