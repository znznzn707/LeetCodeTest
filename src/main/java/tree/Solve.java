package tree;

import java.util.*;

/**
 * <a href="https://www.nowcoder.com/practice/c9480213597e45f4807880c763ddd5f0?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">输出二叉树的右视图</a>
 */
public class Solve {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     *
     * @param xianxu  int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve(int[] xianxu, int[] zhongxu) {
        // write code here
        TreeNode root = rebuild(xianxu, zhongxu);
        int[] arr = rightView(root);
        return arr;
    }

    /**
     * <p>重建二叉树</p>
     *
     * @param xianxu  先序
     * @param zhongxu 中序
     * @return 根节点
     */
    public TreeNode rebuild(int[] xianxu, int[] zhongxu) {
        if (xianxu == null || xianxu.length == 0) return null;
        int val = xianxu[0], pos = 0, len = xianxu.length;
        TreeNode root = new TreeNode(val);
        while (pos < len) {
            if (zhongxu[pos] == val) break;
            ++pos;
        }
        root.left = rebuild(Arrays.copyOfRange(xianxu, 1, pos + 1) //左闭右开
                , Arrays.copyOfRange(zhongxu, 0, pos));
        root.right = rebuild(Arrays.copyOfRange(xianxu, pos + 1, len)
                , Arrays.copyOfRange(zhongxu, pos + 1, len));
        return root;
    }

    /**
     * <p>右视图即添加每一层最后一个节点</p>
     * @param root 根节点
     * @return arr
     */
    public int[] rightView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)queue.offer(root);
        TreeNode tmp = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                tmp = queue.poll();
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            // 添加每层最右元素
            list.add(tmp.val);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
    public static void main(String[] args) {
        int[] xianxu = {1,2,4,5,3};
        int[] zhongxu = {4,2,5,1,3};
        Solve solve = new Solve() ;
        int[] arr = solve.solve(xianxu,zhongxu);
        System.out.println(Arrays.toString(arr)) ;
    }
}
