package array.sort;

import java.util.Arrays;

/**
 * <p>快排</p>
 */
public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = quickSortIntern(arr, left,right);
            quickSort(arr, left, mid-1);
            quickSort(arr, mid+1, right);
        }
    }
    public static int quickSortIntern(int[] arr, int left, int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) --right;
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) ++left;
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,9,7,8,10,4,2,6,1,5,2,2} ;
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr)) ;
    }
}