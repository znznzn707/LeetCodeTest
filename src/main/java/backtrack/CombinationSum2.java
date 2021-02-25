package backtrack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <a href="https://www.nowcoder.com/practice/75e6cd5b85ab41c6a7c43359a74e869a?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">加起来和为目标值的组合</a>
 */
public class CombinationSum2 {

    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(num == null || num.length==0 || target<0)return res;
        Arrays.sort(num);
        dfs(num,target,res,arr,0);
        return res;
    }
    public static void dfs(int[] num,int target,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> arr,int start){
        if(target==0){
            res.add(new ArrayList<>(arr));
            return;
        }
        if(start >= num.length)return;
        for(int i=start;i<num.length;i++){
            if(i > start && num[i] == num[i-1])continue;
            if(num[i] > target) continue;
            arr.add(num[i]);
            dfs(num,target-num[i],res,arr,i+1);
            arr.remove(arr.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] num = {100,10,20,70,60,10,50};
        int target = 80;
        ArrayList<ArrayList<Integer>> res = combinationSum2(num, target);
        res.forEach(l -> {
            for (Integer integer : l) System.out.print(integer + " ") ;
            System.out.println() ;
        });
    }
}
