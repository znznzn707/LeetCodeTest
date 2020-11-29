package string;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/17 15:22
 * <a href="https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">第一个只出现一次的字符</a>
 * <pre>
 * 题目描述:
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 *
 * </pre>
 */
public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        int[] count = new int[256] ;
        int n = str.length();
        for(int i = 0; i < n; i++) {
            count[str.charAt(i)]++;
        }
        for(int i = 0; i < n; i++) {
            if(count[str.charAt(i)] == 1) return i;
        }
        return -1;
    }
}
