package binary;

import java.util.Arrays;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/29 15:31
 * <a href="https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">数字在升序数组中出现的次数</a>
 * <pre>
 * 题目描述:
 *      统计一个数字在升序数组中出现的次数。
 * </pre>
 */
public class GetNumberOfK {

    public int GetNumberOfK(int [] array , int k) {
        int n = array.length;
        int left = 0, right = n;
        int lbound = 0, rbound = 0;
        while (left < right) {
            int mid = (left + right) >> 1;
            if(array[mid] < k) left = mid+1;
            else right = mid;
        }
        lbound = left;
        left = 0;
        right = n-1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if(array[mid] <= k) left = mid+1;
            else right = mid;
        }
        rbound = left;
        return rbound - lbound;
    }
}
