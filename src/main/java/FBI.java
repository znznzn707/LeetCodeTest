/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since  2020/07/23 16:40
 */
//斐波那契数 动态规划
    // 1 1 2 3 5 8...
public class FBI {
    public static int fbi(int n) {
        if(n <= 0)
            return 0;
        if(n == 1 || n == 2)
            return 1 ;
        int fn1, fn2, fn;
        fn1 = fn2 = 1 ;
        fn = 0 ;
        for(int i = 3; i <= n; i++) {
            fn = fn1 + fn2 ;
            fn1 = fn2 ;
            fn2 = fn ;
        }
        return fn ;
    }
    public static void main(String[] args) {
        System.out.println(fbi(6)) ;
    }
}
