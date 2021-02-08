package dp;

/**
 * <a href="https://www.nowcoder.com/practice/7d21b6be4c6b429bb92d219341c4f8bb?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">矩阵的最小路径和</a>
 */
public class MinPathSum {
    /**
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        // write code here
        int rowlen = matrix.length;
        int colen = matrix[0].length;
        int[][] dp = new int[rowlen][colen] ;
        dp[0][0] = matrix[0][0];
        for(int row = 1; row < rowlen; ++row) {
            dp[row][0] = matrix[row][0] + dp[row-1][0];
        }
        for(int col = 1; col < colen; ++col) {
            dp[0][col] = matrix[0][col] + dp[0][col-1];
        }
        for(int row = 1; row < rowlen; ++row) {
            for(int col = 1; col < colen; ++col) {
                dp[row][col] = Math.min(dp[row-1][col], dp[row][col-1]) + matrix[row][col];
            }
        }
        return dp[rowlen-1][colen-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,9}
                ,{8,1,3,4}
                ,{5,0,6,1},
                {8,8,4,0}
        };
        MinPathSum pathSum = new MinPathSum();
        int sum = pathSum.minPathSum(matrix);
        System.out.println(sum) ;
    }
}
