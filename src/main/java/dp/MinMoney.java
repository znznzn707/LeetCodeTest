package dp;

import java.util.Arrays;

/**
 * <a href="https://www.nowcoder.com/practice/3911a20b3f8743058214ceaa099eeb45?tpId=190&tqId=36067&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey">换钱的最少货币数</a>
 */

public class MinMoney {
    /**
     * 最少货币数
     *
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public static int minMoney(int[] arr, int aim) {
        // write code here
        int[] count = new int[aim + 1];
        Arrays.fill(count, aim + 1);
        //初始化数组
        count[0] = 0;
        for (int i = 1; i <= aim; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i >= arr[j]) {
                    //当前的钱数-当前面值，为之前换过的钱数，如果能够兑换只需要在加+1即可，如果不能就取aim+1;
                    count[i] = Math.min(count[i - arr[j]] + 1, count[i]);
                }
            }
        }
        //对应的总数是否能够兑换取决于是否等于aim+1
        return count[aim] != aim + 1 ? count[aim] : -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3} ;
        int aim = 20;
        System.out.println( minMoney(arr, aim)) ;
    }
}