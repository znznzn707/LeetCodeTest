package two_pointer;

import java.util.ArrayList;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/12/05 17:15
 * <a href="https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">和为S的两个数字</a>
 * <pre></pre>
 * 题目描述:
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 返回值描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int left = 0, right = array.length-1;
        int and = 0;
        int min = Integer.MAX_VALUE;
        int res1 = 0, res2 = 0 ;
        while (left < right) {
            and = array[left] + array[right] ;
            if(and < sum) ++left;
            else if(and > sum) --right;
            else {
                int mul = array[left] * array[right] ;
                if(min > mul) {
                    min = mul;
                    res1 = left;
                    res2 = right;
                }
                ++left;
                --right;
            }
        }
        if(res1 == res2) return new ArrayList<>() ;
        ArrayList<Integer> res = new ArrayList<>() ;
        res.add(array[res1]);
        res.add(array[res2]) ;
        return res;
    }
}
