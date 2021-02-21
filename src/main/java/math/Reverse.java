package math;

/**
 * <a href="https://www.nowcoder.com/practice/1a3de8b83d12437aa05694b90e02f47a?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">翻转数字</a>
 */
public class Reverse {
    /**
     *
     * @param x int整型
     * @return int整型
     */
    public static int reverse (int x) {
        // write code here
        long ans = 0;
        int f = 1;
        if(x < 0) {
            f = -f;
            x = -x;
        }
        while (x > 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return (int) ans * f;
    }
}
