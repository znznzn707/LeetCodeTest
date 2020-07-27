import java.util.List;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/27 18:25
 *
 * <a href="https://leetcode-cn.com/problems/triangle/">triangle</a>
 */
public class Triangle {
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
}
