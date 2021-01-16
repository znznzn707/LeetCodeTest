package tree;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/09/23 10:58
 * <a href="https://www.nowcoder.com/practice/a9fec6c46a684ad5a3abd4e365a9d362?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">实现二叉树的先序、中序、后序遍历</a>
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ThreeOrders {

    public static List<Integer> preList = new ArrayList<>() ;
    public static List<Integer> middleList = new ArrayList<>() ;
    public static List<Integer> postList = new ArrayList<>() ;

    public int[][] threeOrders (TreeNode root) {
        // write code here
        int[][] orders = new int[3][] ;
        preOrder(root);
        middleOrder(root);
        postOrder(root);
        orders[0] = toArray(preList) ;
        orders[1]  = toArray(middleList);
        orders[2] = toArray(postList) ;
        return orders;
    }

    /**
     * <p>先序遍历　递归</p>
     * @param root root
     */
    public static void preOrder(TreeNode root) {
        if(root != null) {
            preList.add(root.val) ;
            preOrder(root.left) ;
            preOrder(root.right) ;
        }
    }

    /**
     * <p>中序遍历　递归</p>
     * @param root root
     */
    public static void middleOrder(TreeNode root) {
        if(root != null) {
            middleOrder(root.left);
            middleList.add(root.val) ;
            middleOrder(root.right);
        }
    }

    /**
     * <p>后序遍历　递归</p>
     * @param root root
     */
    public static void postOrder(TreeNode root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            postList.add(root.val) ;
        }
    }

    /**
     * <p>List转array</p>
     * @param list list
     * @return int数组
     */
    public static int[] toArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray() ;
    }

    /**
     *
     * @param root root
     * @return int[] array
     */
        public static int[] preOrderWithNonRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>() ;
        TreeNode curNode = root ;
        while (curNode != null || !stack.empty()) {
            while (curNode != null) {
                preList.add(curNode.val);
                stack.push(curNode) ;
                curNode = curNode.left ;
            }
            curNode = stack.pop() ;
            curNode = curNode.right ;
        }
        return toArray(preList) ;
    }

    /**
     * <p>中序遍历　非递归</p>
     * @param root root
     * @return 结果
     */
    public static int[] middleOrderWithNonRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>() ;
        TreeNode curNode = root ;
        while (curNode != null || !stack.empty()) {
            while (curNode != null) {
                stack.push(curNode) ;
                curNode = curNode.left ;
            }
            curNode = stack.pop() ;
            middleList.add(curNode.val) ;
            curNode = curNode.right ;
        }
        return toArray(middleList) ;
    }

    /**
     * <p>后序遍历 非递归</p>
     * @param root root
     * @return int[]array
     */
    public static int[] postOrderWithNonRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>() ;
        TreeNode curNode = root ;
        TreeNode prev = root ;
        while (curNode != null || ! stack.empty()) {
            while(curNode != null) {
                stack.push(curNode) ;
                curNode = curNode.left ;
            }
            curNode = stack.peek() ;
            if(curNode.right == null || curNode.right == prev) {
                postList.add(curNode.val) ;
                prev = curNode ;
                stack.pop() ;
                curNode = null ;
            }else
                curNode = curNode.right ;
        }
        return null ;
    }
}
