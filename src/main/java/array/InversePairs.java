package array;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/17 15:44
 * <a href="https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">数组中的逆序对</a>
 * <pre>
 *
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * </pre>
 */
public class InversePairs {
    private int cnt;
    public int inversePairs(int[] array) {
        mergeSort(array, 0, array.length-1);
        return cnt;
    }
    public void mergeSort(int[] arr, int left, int right) {
        if(left >= right) return ;
        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        mergeSortIntern(arr, left, mid, right);
    }
    public void mergeSortIntern(int[] arr, int left, int mid,int right) {
        int[] temp = new int[right-left+1] ;
        int i = left, j = mid+1;
        int k = 0;
        while (i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++] ;
                cnt += (mid-i+1) % 1000000007;
            }
        }
        while (i <= mid) { temp[k++] = arr[i++] ; }
        while (j <= right) { temp[k++] = arr[j++] ; }
        for (int l = 0; l <k ;l++) {
            arr[left+l] = temp[l];
        }
    }
}
