package dp;

/**
 * <a href="https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec?tpId=190&tqId=35181&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey">买卖股票的最佳时机</a>
 */
public class MaxProfit {
    /**
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here
        int n = prices.length;
        if(n == 1) return 0;
        int[] dp = new int[n] ;
        dp[1] = Math.max((prices[1] - prices[0]), 0);
        int min = Math.min(prices[0], prices[1]);
        for(int i = 2; i < n; ++i) {
            int diff = Math.max(prices[i] - min, 0);
            dp[i] = Math.max(dp[i-1], diff);
            min = Math.min(min, prices[i]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] prices = {3,5,3,4,1,4,5,0,7,8,5,6,9,4,1} ;
        MaxProfit maxProfit = new MaxProfit();
        int max = maxProfit.maxProfit(prices);
        System.out.println(max) ;
    }
}
