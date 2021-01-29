package string;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3619/">Smallest String With A Given Numeric Value</a>
 */

public class GetSmallestString {
    public String getSmallestString(int n, int k) {
        char[] chars = new char[n] ;
        Arrays.fill(chars,'a');
        int sum = n;
        for(int i = n-1; i >= 0; --i) {
            while (chars[i] < 'z' && sum < k) {
                ++chars[i];
                ++sum;
            }
            if(sum == k) break;
        }
        return new String(chars) ;
    }

    public static void main(String[] args) {
        GetSmallestString smallestString = new GetSmallestString() ;
        String s = smallestString.getSmallestString(5, 73);
        System.out.println(s) ;
    }
}
