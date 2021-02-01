package binary;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/07 16:29
 * <a href="https://www.nowcoder.com/practice/7bc4a1c7c371425d9faa9d1b511fe193?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">二分查找</a>
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = (left+right) >> 1;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,8,14,14,45,68} ;
        System.out.println(search(arr,14));
    }
}
