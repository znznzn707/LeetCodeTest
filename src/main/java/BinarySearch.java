/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/07 16:29
 * <p>二分查找</p>
 */
public class BinarySearch {
    public static int search(int[] arr, int k) {
        int left = 0;
        int right = arr.length-1 ;
        int mid  ;
        while (left <= right) {
            mid = (left+right) / 2 ;
            if(arr[mid] < k)
                left = mid + 1 ;
            else if(arr[mid] > k)
                right  = mid - 1 ;
            else
                return mid ;
        }
        return -1 ;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,8,14,23,45,68} ;
        System.out.println(search(arr,14));
    }
}
