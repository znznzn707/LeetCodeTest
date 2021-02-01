package tree;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/583/week-5-january-29th-january-31st/3621"> Vertical Order Traversal of a Binary Tree</a>
 */
class Pair{
    TreeNode node;
    int x;
    int y;
    Pair(TreeNode node,  int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}
public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Pair>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        if(root != null) queue.offer(new Pair(root,0,0));
        int left = 0, right = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            left = Math.min(left, pair.x);
            right = Math.max(right, pair.x);
            if(!map.containsKey(pair.x)) map.put(pair.x,new ArrayList<>());
            map.get(pair.x).add(pair);
            if(pair.node.left != null) queue.offer(new Pair(pair.node.left, pair.x-1, pair.y+1));
            if(pair.node.right != null) queue.offer(new Pair(pair.node.right, pair.x+1, pair.y+1));
        }
        Comparator<Pair> comp = (a, b) ->{
            if(a.y == b.y) return a.node.val - b.node.val;
            return 0;
        };
        for(int i = left; i <= right; ++i) {
            List<Pair> cur = map.get(i);
            Collections.sort(cur,comp);
            ArrayList<Integer> list = new ArrayList<>();
            for(Pair pair: cur) {
                list.add(pair.node.val);
            }
            res.add(list);
        }
        return res;
    }
}
