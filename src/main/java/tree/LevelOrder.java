package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://www.nowcoder.com/practice/04a5560e43e24e9db4595865dc9c63a3?tpId=190&&tqId=35337&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking">二叉树的层次遍历</a>
 *
 */
public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>() ;
        if(root == null) return res;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int n = queue.size() ;
            ArrayList<Integer>list = new ArrayList<>() ;
            while(n > 0) {
                TreeNode cur = queue.poll() ;
                list.add(cur.val) ;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                --n;
            }
            if(list.size() != 0) res.add(list) ;
        }
        return res;
    }
}
