package two_pointer;
import java.util.*;

/**
 * <a href="https://www.nowcoder.com/practice/c466d480d20c4c7c9d322d12ca7955ac?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">最小覆盖子串</a>
 */

public class MinWindow {

    /**
     *
     * @param S string字符串
     * @param T string字符串
     * @return string字符串
     */
    public static String minWindow (String S, String T) {
        // write code here
        int[] needs = new int[128];
        int[] windows = new int[128];
        for(char ch : T.toCharArray()) needs[ch]++;
        int left = 0, right = 0;
        int count  = 0;
        String res = "";
        int minLen = S.length() + 1;
        while(right < S.length()) {
            char ch = S.charAt(right);
            windows[ch]++;
            if(needs[ch] > 0 && needs[ch] >= windows[ch]) {
                count++;
            }
            while(count == T.length()) {
                char c = S.charAt(left);
                if(needs[c] > 0 && needs[c] >= windows[c]) {
                    count--;
                }
                if(minLen > (right-left + 1)){
                    minLen = right - left + 1;
                    res = S.substring(left, right + 1);
                }
                left++;
                windows[c]--;
            }
            right++;
        }
        return res;
    }
    public static void main(String[] args) {
        String s = minWindow("XDOYEZODEYXNZ","XYZ");
        System.out.println(s) ;
    }
}
