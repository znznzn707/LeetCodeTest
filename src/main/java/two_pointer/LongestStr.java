package two_pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/16 18:21
 * <h1>* 双指针　滑动窗口 *</h1>
 * <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">无重复字符的最长子串</a>
 */
public class LongestStr {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>() ;
        int count = 0 ;
        for(int start = 0, end = 0; end < s.length(); end++) {
            char ch = s.charAt(end) ;
            if(map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            map.put(ch, end) ;
            count = Math.max(count, end - start + 1) ;
        }
        return count ;
    }
}
