package dp;

/**
 * <a href="https://www.nowcoder.com/practice/9c158345c867466293fc413cff570356?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">子数组最大乘积</a>
 * <p>需要考虑负数的问题</p>
 */
public class MaxProduct {
    public double maxProduct(double[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int n = arr.length;
        double max = arr[0];
        double min = arr[0];
        double res = arr[0];
        for(int i = 1; i < n; ++i) {
            double temp_max = max;
            max = Math.max(arr[i] * max, Math.max(arr[i] * min, arr[i]));
            min = Math.min(arr[i] * temp_max, Math.min(arr[i] * min, arr[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}
