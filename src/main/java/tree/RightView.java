package tree;

import java.util.*;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/15 20:50
 * <a href="https://leetcode-cn.com/problems/binary-tree-right-side-view/">右视图</a>
 * <pre>
 *　输入: [1,2,3,null,5,null,4]
 *　输出: [1, 3, 4]
 *　解释:
 * </pre>
 * 难度系数：中等
 */
public class RightView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1) ;
        TreeNode n1 = new TreeNode(2) ;
        TreeNode n2 = new TreeNode(3) ;
        TreeNode n3 = new TreeNode(5) ;
        TreeNode n4 = new TreeNode(4) ;

        root.left = n1 ;
        root.right = n2 ;
        n1.left = null ;
        n1.right = n3 ;
        n2.left = null ;
        n2.right = n4;
//        List<Integer> list = rightSideViewWithBFS(root) ;
        List<Integer> list = rightSideViewWithDFS(root) ;
        list.forEach(System.out::println);

    }
    public static List<Integer> rightSideViewWithBFS(TreeNode root) {
        Map<Integer, Integer> rightView = new HashMap<>() ;
        Queue<TreeNode> nodeQueue = new LinkedList<>() ;
        Queue<Integer> depthQueue = new LinkedList<>() ;
        nodeQueue.add(root) ;
        int maxDepth = -1 ;
        depthQueue.add(0) ;
        while (! nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.remove();
            int depth = depthQueue.remove();
            if (curNode != null) {
                maxDepth = Math.max(maxDepth, depth);
                //覆盖
                rightView.put(depth, curNode.val);

                nodeQueue.add(curNode.left);
                nodeQueue.add(curNode.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }
        List<Integer> result = new ArrayList<>() ;
        for(int i = 0; i <= maxDepth; i++)
            result.add(rightView.get(i)) ;
        return result ;
    }
    public static List<Integer> rightSideViewWithDFS(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }
}
