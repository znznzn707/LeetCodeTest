package array.sort;

import java.util.Arrays;

/**
 * <p>插入排序</p>
 */
public class InsertSort {
    public static void insertSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; ++i) {
            int key = arr[i+1];
            int j = i;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,5,9,7,8,10,4,2,6,1,5,2,2} ;
        insertSort(arr);
        System.out.println(Arrays.toString(arr)) ;
    }
}
