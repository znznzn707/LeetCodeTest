package dp;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/09 20:40
 * <pre>
 *    * 动态规划　背包问题 *
 * </pre>
 */
public class PackageProblem {
    public static int getMaxValue(int[] weight, int[] value, int capacity) {
        int n = weight.length ;
        int[][] max = new int[n+1][capacity+1] ;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= capacity; j++) {
                if(weight[i-1] <= j) {
                    max[i][j] = Math.max(max[i-1][j],
                            value[i-1]+max[i-1][j-weight[i-1]]);
                }else
                    max[i][j] = max[i-1][j] ;
            }
        }
        return max[n][capacity] ;
    }
}
