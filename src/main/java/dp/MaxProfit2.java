package dp;

/**
 * <a href="https://www.nowcoder.com/practice/4892d3ff304a4880b7a89ba01f48daf9?tpId=190&tqId=36950&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey">股票收益2</a>
 */
public class MaxProfit2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 两次交易所能获得的最大收益
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public static int maxProfit2 (int[] prices) {
        // write code here
        int n = prices.length;
        int[] dp = new int[n];
        int max = prices[n-1];
        dp[n-1] = 0;
        for (int i = n-2; i >= 0; --i) {
            max = Math.max(max, prices[i]);
            dp[i] = Math.max(dp[i+1], max - prices[i]);
        }
        int res = 0;
        //从前往后遍历
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            min = Math.min(min,prices[i]);
            res  = Math.max(res,prices[i]-min + dp[i+1]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit2(new int[]{8,9,3,5,1,3})) ;
    }
}
