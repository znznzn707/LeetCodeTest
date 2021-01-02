package dp; 
/**
 * <a href="https://leetcode.com/problems/cherry-pickup-ii/">Cherry Pickup II</a>
 * <p>自下而上</p>
 */
public class CherryPickup {
    static int[][][] dpCache ;
    public static void main(String[] args) {
        CherryPickup pickup = new CherryPickup() ;
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}}; 
        int x =  pickup.cherryPickup(grid); 
        System.out.println(x) ; 
    }
    public int cherryPickup(int[][] grid) {
        int rows = grid.length ;
        int cols = grid[0].length ;
        int[][][] dp = new int[rows][cols][cols];
        for(int i = rows-1; i >= 0; i--) {
            for(int j = 0; j < cols; j++) {
                for(int k = 0; k < cols; k++) {
                    int res = 0; 
                    res += grid[i][j] ;
                    if(j != k) res += grid[i][k];
                    if(i != rows-1) {
                        int max = 0; 
                        for(int newCol1 = j - 1; newCol1 <= j+1; newCol1++) {
                            for(int newCol2 = k - 1; newCol2 <= k+1; newCol2++) {
                                if(newCol1 >= 0 && newCol1 < cols 
                                        && newCol2 >= 0 && newCol2 < cols) {
                                    max = Math.max(max, dp[i+1][newCol1][newCol2]) ;
                                }
                            }
                        }
                        res += max; 
                    }
                        dp[i][j][k] = res;  
                }
            }
        }
        return dp[0][0][cols-1] ;
    }
}
