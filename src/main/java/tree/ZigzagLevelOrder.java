package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://www.nowcoder.com/practice/47e1687126fa461e8a3aff8632aa5559?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">二叉树的之字形层次遍历</a>
 */
public class ZigzagLevelOrder {
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int flag = 1;
        while(!queue.isEmpty()) {
            int size = queue.size(); //后面要添加子节点
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if(flag == 1) list.add(cur.val);
                else list.add(0, cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            if (list.size() != 0) res.add(list);
            flag = -flag;
        }
        return  res;
    }
}

