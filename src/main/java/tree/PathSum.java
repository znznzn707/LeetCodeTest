package tree;

import util.Builder;
import util.TreeNodeBuilder;

import java.util.ArrayList;

/**
 * <a href="https://www.nowcoder.com/practice/840dd2dc4fbd4b2199cd48f2dadf930a?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">二叉树根节点到叶子节点和</a>
 */
public class PathSum {

    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static ArrayList<Integer> temp = new ArrayList<>();
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here
        dfs(root, sum, 0);
        return res;
    }
    private void dfs(TreeNode root, int sum, int cnt) {
        if(root == null) return; // 如果节点为空结束当前递归
        temp.add(root.val); //将当前节点加入tmp数组
        cnt += root.val; //把当前节点加入到路径和中
        if(root.left == null && root.right == null){ //当递归到没有子树的时候就需要判断
            if(cnt == sum){ //如果当前节点的路径和等于sum，那么就在res中插入tmp
                res.add(new ArrayList<>(temp));
            }
        }else{
            dfs(root.left,sum,cnt); //递归左子树
            dfs(root.right,sum,cnt); //递归右子树
        }
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        Builder<TreeNode> builder = new TreeNodeBuilder() ;
        TreeNode root = builder.deserialize("5,4,8,1,11,#,9,#,#,2,7");
        PathSum sumPath = new PathSum();
        int sum = 22;
        sumPath.pathSum(root, sum);
        for (ArrayList<Integer> l : res) {
            l.forEach(i->System.out.print(i+", "));
            System.out.println() ;
        }
    }
}
