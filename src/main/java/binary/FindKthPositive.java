package binary;

/**
 * <p>leetcode</p>
 */
public class FindKthPositive {
    public static int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length, m;
        while(left < right)
        {
            m = (left + right) >> 1;
            if(arr[m] - m <= k) left = m + 1;
            else right = m;
        }
        return k + left;
    }
}
