/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/09/24 14:44
 * <a href="https://www.nowcoder.com/practice/7bc4a1c7c371425d9faa9d1b511fe193?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">二分查找</a>
 */
public class UpperBound {
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int left = 0;
        int right = a.length-1;
        int mid ;
        while(left <= right) {
            mid = (left + right) >> 1;
            if(a[mid] < v) {
                left = mid + 1;
            }else if(mid > 0 && a[mid-1] >= v) {
                right = mid - 1;
            }else {
                return mid+1 ;
            }
        }
        return n+1;
    }
}
