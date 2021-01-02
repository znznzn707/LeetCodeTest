import java.util.Arrays;
/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3578/">Next Greater Element III</a>
 * <pre>
 *
 *Given a positive integer n, find the smallest integer which has exactly the same digits existing 
 *in the integer n and is greater in value than n. If no such positive integer exists, return -1.
 *
 *Note that the returned integer should fit in 32-bit integer,
 * if there is a valid answer but it does not fit in 32-bit integer, return -1.
 *
 *Example 1:
 *
 *Input: n = 12
 *Output: 21
 *
 *Example 2:
 *
 *Input: n = 21
 *Output: -1
 *
 *Constraints:
 *
 *    1 <= n <= 231 - 1
 *
 * </pre>
 */

public class NextGreaterElement {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n); 
        char[] ch = s.toCharArray() ;
        int i, j; 
        for(i = ch.length-1; i > 0; i--) {
            if(ch[i-1] < ch[i]) break; 
        }
        if(i == 0) return -1 ;
        int idx = i ; 
        for(j = i+1; j < ch.length; j++) {
            if(ch[j] > ch[i-1] && ch[j] <= ch[idx]) {
                idx = j ;
            }        
        }
        char temp = ch[i-1];
        ch[i-1] = ch[idx]; 
        ch[idx] = temp; 
        Arrays.sort(ch, i, ch.length);
        long val = Long.parseLong(new String(ch));
        return (val <= Integer.MAX_VALUE)? (int) val:-1;  
    }
}
