package binary;

import java.util.Arrays;

/**
 * <a href="https://www.nowcoder.com/practice/3afe6fabdb2c46ed98f06cfd9a20f2ce?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">矩阵元素查找</a>
 */
public class FindElement {
    public static int[] findElement(int[][] mat, int n, int m, int x) {
        int row = 0, col = m-1;
        int[] res = new int[2];
        while (row < n && col >= 0) {
            if(mat[row][col] < x) ++row;
            else if(mat[row][col] > x) --col;
            else {
                res[0] = row;
                res[1] = col;
                return res;
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}} ;
        int n = 2, m = 3, x = 6;
        int[] res = findElement(mat, n, m, x);
        System.out.println(Arrays.toString(res)) ;
    }
}
