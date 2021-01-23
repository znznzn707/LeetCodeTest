package string;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/">最长子串</a>
 * <p>***</p>
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    /*
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0; j < n; ++j) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j))+1, i); //"abba"
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    } */
}
