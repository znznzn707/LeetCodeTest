package math;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/09 10:48
 * <a href="https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&&tqId=11184&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">整数中1出现的次数</a>
 * <a href="https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/">问题求解</a>
 */
public class NumberOf1Between1AndN {
    public int numberOf1Between1AndN(int n) {
        int high, low, digit, res, cur ;
        high = n / 10;
        cur = n % 10 ;
        low = res = 0 ;
        digit = 1;
        while (high != 0 || cur != 0) {
            if(cur == 0) res += high * digit ;
            else if(cur  == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit ;
            low += cur * digit;
            cur =  high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

}
