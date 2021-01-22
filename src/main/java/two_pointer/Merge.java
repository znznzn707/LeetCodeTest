package two_pointer;

import java.util.Arrays;

/**
 * <a href="https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=190&tqId=35361&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking">合并两个有序的数组</a>
 */
public class Merge {
    public void merge(int A[], int m, int B[], int n) {
        while(m > 0 && n > 0) {
            if (A[m - 1] >= B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                --m;
            } else {
                A[m + n - 1] = B[n - 1];
                --n;
            }
        }
        while (n > 0) {
            A[n-1] = B[n-1];
            --n;
        }
    }
}
