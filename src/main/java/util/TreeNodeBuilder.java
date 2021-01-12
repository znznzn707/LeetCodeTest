package util;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/10/27 17:12
 */
public class TreeNodeBuilder implements Builder<TreeNode>  {

    /**
     * <pre>
     *        1
     *      /   \
     *     2     2
     *   /  \   / \
     *  3   #  #   3
     *
     * </pre>
     * <p>层次遍历构建二叉树</p>
     * @param str "1,2,2,3,#,#,3"
     * @return root
     */
    @Override
    public  TreeNode deserialize(String str) {
        String[] strs = str.split(",");
        int n = strs.length;
        Queue<TreeNode> queue = new LinkedList<>() ;
        if("#".equals(strs[0])) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.add(root) ;
        int idx = 0;
        while (!queue.isEmpty() && idx < n-2) {
            TreeNode cur = queue.remove();
            String left = strs[++idx] ;
            String right = strs[++idx] ;
            if(cur != null) {
                if(!"#".equals(left))
                    cur.left = new TreeNode(Integer.parseInt(left));
                if(!"#".equals(right))
                    cur.right = new TreeNode(Integer.parseInt(right));
                queue.add(cur.left) ;
                queue.add(cur.right) ;
            }
        }
        return root;
    }
    @Override
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>() ;
        if(root != null) queue.offer(root) ;
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll() ;
            builder.append(((cur != null)? cur.val:"#") + ", ");
            if(cur != null && (cur.left != null || cur.right != null)) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return (builder.length() != 0)? builder.substring(0,builder.length()-2) : "null";
    }
}