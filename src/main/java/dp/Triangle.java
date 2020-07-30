package dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/27 18:25
 *
 * <a href="https://leetcode-cn.com/problems/triangle/">triangle</a>
 * <pre>
 *     我们用 f[i][j]f[i][j] 表示从三角形顶部走到位置 (i, j)(i,j) 的最小路径和。
 *     这里的位置 (i, j)(i,j) 指的是三角形中第 ii 行第 jj 列（均从 00 开始编号）的位置。
 *
 * 由于每一步只能移动到下一行「相邻的节点」上，因此要想走到位置 (i, j)(i,j)，
 * 上一步就只能在位置 (i - 1, j - 1)(i−1,j−1) 或者位置 (i - 1, j)(i−1,j)。
 * 我们在这两个位置中选择一个路径和较小的来进行转移，状态转移方程为：
 *
 * f[i][j]=min(f[i−1][j−1],f[i−1][j])+c[i][j]
 *
 * 其中 c[i][j]c[i][j] 表示位置 (i, j)(i,j) 对应的元素值。
 *
 * </pre>
 */
public class Triangle {
    //X 错误解法，状态方程错误，只是做到了局部路径最短
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size() ;
        int[] nums = new int[n] ;
        nums[0] = triangle.get(0).get(0) ;
        int index = 0 ;
        for(int i = 1; i < n; i++) {
            int x = triangle.get(i).get(index) ;
            int y = triangle.get(i).get(index+1) ;
            int z = Math.min(x, y) ;
            nums[i] = nums[i-1] + z ;
            index = ((z == x)? index: index+1) ;
        }
        return nums[n-1] ;
    }


    /*　时间复杂度: O(n^2)　*/
    /* 空间复杂度: O(n^2)　*/
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size() ;
        int[][] nums = new int[n][n] ;
        nums[0][0] = triangle.get(0).get(0) ;
        for(int i = 1; i < n; ++i) {
            nums[i][0] = nums[i-1][0] + triangle.get(i).get(0) ;
            for(int j = 1; j < i; ++j) {
                nums[i][j] = Math.min(nums[i-1][j-1], nums[i-1][j])
                        + triangle.get(i).get(j);
            }
            nums[i][i] = nums[i-1][i-1] + triangle.get(i).get(i) ;
        }
        int min = Arrays.stream(nums[n-1]).min().getAsInt();
        return min ;
    }
}
