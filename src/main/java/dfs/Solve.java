package dfs;

/**
 * <a href="https://www.nowcoder.com/practice/7a71a88cdf294ce6bdf54c899be967a2?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">矩阵最长递增路径</a>
 */
public class Solve {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 递增路径的最大长度
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    public static int solve (int[][] matrix) {
        // write code here
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] flags = new int[rows][cols];
        int cout = 0;
        for(int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if(flags[i][j] == 0) cout = Math.max(cout, dfs(matrix, i, j, flags)) ;
            }
        }
        return cout;
    }
    public static int  dfs(int[][] matrix, int row, int col, int[][] flags) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(row < 0 || row >= rows || col < 0 || col >= cols) return 0;
        if(flags[row][col] > 0) return flags[row][col];
        int max = 0;
        if(row - 1 >= 0 && matrix[row-1][col] > matrix[row][col]){
            max = Math.max(max, dfs(matrix, row-1, col,  flags));
        }
        if(row + 1 < matrix.length && matrix[row+1][col] > matrix[row][col]){
            max = Math.max(max, dfs(matrix, row+1, col, flags));
        }
        if(col - 1 >= 0 && matrix[row][col-1] > matrix[row][col]){
            max = Math.max(max, dfs(matrix, row, col-1, flags));
        }
        if(col + 1 < matrix[0].length && matrix[row][col+1] > matrix[row][col]){
            max = Math.max(max, dfs(matrix, row, col+1,  flags));
        }
        flags[row][col] = max+1;
        return max+1;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(solve(matrix)) ;
    }
}
