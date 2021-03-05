package binary;

/**
 * <a href="https://www.nowcoder.com/practice/5145394607ea4c5f8b25755718bfddba?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">矩阵查找</a>
 */
public class SearchMatrix {
    /**
     * @param matrix int整型二维数组
     * @param target int整型
     * @return bool布尔型
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // write code here
        int i = 0, j = matrix[0].length-1;
        while (i < matrix.length && j >= 0)  {
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) --j;
            else ++i;
        }
        return false;
    }
    /**
     *
     * <p>二分</p>
     * @param matrix int整型二维数组
     * @param target int整型
     * @return bool布尔型
     */
    public boolean searchMatrix2 (int[][] matrix, int target) {
        // write code here
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while(left <= right) {
            int mid = (left + right) >> 1;
            if(matrix[mid / n][mid % n] == target) return true;
            else if(matrix[mid / n][mid % n] > target) right = mid-1;
            else left = mid + 1;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 9}, {10, 11, 12, 30}, {230, 300, 350, 500}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
