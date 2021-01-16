package heap;

/**
 * <a href="https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">寻找第K大</a>
 * <p>快速排序</p>
 */

public class FindKth {
    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a, 0, n-1);
        while (K > 0) {
            if(a[n-2] != a[n-1]) --K;
            --n;
        }
        return a[n] ;
    }
    private void quickSort(int[] a, int left, int right) {
        if(left < right) {
            int mid = quickSortIntern(a, left, right);
            quickSort(a,left, mid-1) ;
            quickSort(a,mid+1, right);
        }
    }
    private int quickSortIntern(int[] a, int left, int right) {
        int key = a[left];
        while (left < right) {
            while (left < right && a[right] >= key) --right;
            a[left] = a[right];
            while (left < right && a[left] <= key) ++left;
            a[right] = a[left];
        }
        a[left] = key;
        return left;
    }

    public static void main(String[] args) {
       FindKth kth = new FindKth() ;
       int x = kth.findKth(new int[]{1,3,5,2,2},5,3);
       System.out.println(x) ;
    }
}
