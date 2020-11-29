package dp;

import java.util.Arrays;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/23 22:41
 * <pre>
 *     连续子数组的最大和
 *     int[] arr
 *     F(i) = max(F(i-1)+arr[i], max)
 * </pre>
 * <a href="https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&&tqId=11183&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">连续子数组的最大和</a>
 */

public class GreatestSumOfSubArray {
    public static int findGreatestSumOfSubArray(int[] arr) {
        int[] sumArr ;
        sumArr = new int[arr.length] ;
        sumArr[0] = arr[0] ;
        for(int i = 1; i <= arr.length-1; i++) {
            sumArr[i] = Math.max(sumArr[i-1] + arr[i], arr[i]) ;
        }
        int max = Arrays.stream(sumArr).max().getAsInt() ;
        return max ;
    }
}
