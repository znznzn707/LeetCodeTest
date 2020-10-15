package two_pointer;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/09/27 10:03
 * <a href="https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">合并数组</a>
 */
public class MergeArray {
    public void merge(int A[], int m, int B[], int n) {
        int len = m+n-1 ;
        int max = 0;
        int i = m-1;
        int j = n-1;
        while(i >= 0 && j >= 0) {
            if(A[i] >= B[j]) {
                max = A[i] ;
                i--;
            }else {
                max = B[j] ;
                j--;
            }
            A[len--] = max;
        }
        if(j >= 0) {
            while(len >= 0)  A[len--] = B[j--] ;
        }
    }
}
