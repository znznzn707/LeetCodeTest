package dfs;

/**
 * <a href="https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&&tqId=11218&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">矩阵中的路径</a>
 * 时间复杂度：O(n^3)，空间复杂度：O(n)
 *<p>需要注意：并不是像贪吃蛇一样，只要路径包含str中的字符即可</p>
 */

public class HasPath {

    int rows, cols;
    int[] flags ; //用来标记是否已经访问过
    int[] dir = {-1, 0, 1, 0, -1}; //这一点设计很巧妙
    public  boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.rows = rows;
        this.cols = cols;
        flags = new int[matrix.length];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (dfs(matrix, i, j, 0, str)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[] matrix, int row, int col, int pos, char[] str) {
        if(row < 0 || col < 0 || row >= rows || col >= cols) return false;
        int index = row * cols + col;
        if(flags[index] == 1 || matrix[index] !=str[pos]) return false;
        if(pos+1 == str.length) return true;
        flags[index] = 1;
        for(int i = 0; i < 4; ++i) {
            if(dfs(matrix, row+dir[i], col+dir[i+1], pos+1, str)) {
                return true;
            }
        }
        flags[index] = 0;
        return false;
    }
}