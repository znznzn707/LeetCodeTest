package binary;

import java.util.Arrays;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/29 15:31
 * <a href="https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">数字在升序数组中出现的次数</a>
 * <pre>
 * 题目描述:
 *      统计一个数字在升序数组中出现的次数。
 * </pre>
 */
public class GetNumberOfK {

    public int GetNumberOfK(int [] array , int k) {
       int index = binarySearch(array, k) ;
       int n = array.length;
       if(index < 0) return 0;
       int cnt = 0;
       int tmp = index ;
       while(tmp <= n && array[tmp] == k)  {
           tmp++;
           cnt++ ;
       }
       tmp = index-1;
       while (tmp >= 0 && array[tmp] == k) {
           tmp--;
           cnt++;
       }
       return cnt;
    }
    public int binarySearch(int [] arr, int k) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left+right) >>> 1;
            if(arr[mid] < k) left = mid+1;
            else if(arr[mid] > k) right = mid-1;
            else return mid;
        }
        return -1;
    }
}
