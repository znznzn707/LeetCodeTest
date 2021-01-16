package binary;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/07 16:29
 * <a href="https://www.nowcoder.com/practice/7bc4a1c7c371425d9faa9d1b511fe193?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">二分查找</a>
 */
public class BinarySearch {
    public static int search(int[] arr, int v) {
        int n = arr.length;
        if(arr[n-1]<v){return n+1;}//如果不存在这样的数：即数组中所有数字都比
        int Left = 0;
        int Right = n-1;
        while(Left < Right) {
            int Mid = (Left+Right) >> 1;//防溢出
            if(arr[Mid] >= v){ Right = Mid; }
            else{ Left = Mid+1; }
        }
        return Left+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,8,14,14,45,68} ;
        System.out.println(search(arr,14));
    }
}
