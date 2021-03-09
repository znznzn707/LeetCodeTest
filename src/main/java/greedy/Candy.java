package greedy;

import java.util.Arrays;

/**
 * <a href="https://www.nowcoder.com/practice/76039109dd0b47e994c08d8319faa352?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">分糖果问题</a>
 */
public class Candy {

    /**
     * pick candy
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int candy (int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        for (int i = 1; i < n; ++i) {
            if (arr[i] > arr[i - 1]) temp[i] = temp[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; --i) {
            if (arr[i] > arr[i + 1]) temp[i] = Math.max(temp[i], temp[i + 1] + 1);
        }
        int cnt = 0;
        for (int i : temp) cnt += i;
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        System.out.println(candy(arr)) ;
    }
}