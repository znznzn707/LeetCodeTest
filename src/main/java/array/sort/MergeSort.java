package array.sort;

import java.util.Arrays;

/**
 * <p>归并排序</p>
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right) >> 1;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr,mid+1,right,temp);
            mergeSortIntern(arr, left, mid, right, temp);
        }
    }
    private static void mergeSortIntern(int[] arr, int left, int mid, int right, int[] temp) {
        int l1 = left, r1 = mid, l2 = mid+1, r2 = right;
        int index = left; // Note that the index not equals 0, but equals left.
        while (l1 <= r1 && l2 <= r2) {
            if(arr[l1] <= arr[l2]) temp[index++] = arr[l1++];
            else temp[index++] = arr[l2++];
        }
        while (l1 <= r1)  temp[index++] = arr[l1++] ;
        while (l2 <= r2)  temp[index++] = arr[l2++] ;
        for (int i = left; i <= right; ++i) {
            arr[i] = temp[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,5,9,7,8,10,4,2,6,1,5,2,2} ;
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1, temp);
        System.out.println(Arrays.toString(arr)) ;
    }
}