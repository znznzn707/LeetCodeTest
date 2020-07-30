package dp;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/30 14:30
 * <a href="https://leetcode-cn.com/problems/unique-paths-ii/">63.UniquePaths2</a>
 */
public class UniquePaths2 {
    public static int uniquePathsWithObstacles(int[][] nums) {
        int m = nums.length ;
        int n = nums[0].length ;
        int[][] result = new int[m][n] ;
        int k = 0;
        if(nums[0][0] == 1)
            return 0 ;
        for(int i = 0; i < n; i++) {
            if(nums[0][i] == 1) {
                result[0][i] = 0 ;
                k = 1 ;
            } else if(k == 1) result[0][i] = 0 ;
            else result[0][i] = 1 ;
        }
        k = 0;
        for(int j = 0; j < m; ++j) {
            if(nums[j][0] == 1) {
                result[j][0] = 0 ;
                k = 1 ;
            } else if(k == 1) result[j][0] = 0 ;
            else result[j][0] = 1 ;
        }
        int x = 0 ;
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                x = nums[i][j] ;
                if(x == 1) result[i][j] = 0 ;
                else result[i][j] = result[i-1][j] + result[i][j-1] ;
            }
        }
        return result[m-1][n-1] ;
    }
}
