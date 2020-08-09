import java.math.BigDecimal;
import java.util.Scanner;
/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/09 17:21
 */


public class NumberClassify {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in) ;
        while (in.hasNext()) {
            int n = in.nextInt() ;
            int[] arr = new int[n] ;
            int a1, a2, a3, a4, a5 ;
            a1 = a2= a3 = a4 = a5 = 0;
            for(int i = 0; i < n; i++) {
                arr[i] = in.nextInt() ;
            }
            int flag = 1 ;
            int tmp = 0 ;
            double count = 0 ;
            boolean isUsed = false;
            for(int i = 0;i < n; i++) {
                int m = arr[i] % 5 ;
                switch (m) {
                    case 0: {
                        if((arr[i] & 1) == 0)
                            a1 += arr[i];
                        break; }
                    case 1: {
                        a2 += flag * arr[i] ;
                        flag = -flag;
                        isUsed = true ;
                        break;
                    }
                    case 2: {
                        a3++ ;
                        break;
                    }
                    case 3: {
                        a4 += arr[i] ;
                        count++ ;
                        break;
                    }
                    case 4: {
                        a5 = Math.max(arr[i], tmp) ;
                        tmp = a5 ;
                    }
                }
            }
            if(a1 != 0) System.out.print(a1 + " ");
            else System.out.print("N ");
            if(isUsed == true) System.out.print(a2 + " ");
            else System.out.print("N ");
            if(a3 != 0)
                System.out.print(a3+" ");
            else System.out.print("N ");
            if(count != 0) {
                BigDecimal decimal = new BigDecimal(a4/count) ;
                double x = decimal.setScale(1,4).doubleValue() ;
                System.out.print(x+" ");
            }else System.out.print("N ");
            if(tmp != 0) System.out.print(a5);
            else System.out.print("N");

        }
    }
}
