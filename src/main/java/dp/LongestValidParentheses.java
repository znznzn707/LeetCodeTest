package dp;

import java.util.Stack;

/**
 * <a href="https://www.nowcoder.com/practice/45fd68024a4c4e97a8d6c45fc61dc6ad?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">最长的括号子串</a>
 * <a href="https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/">solution</a>
 * <p>hard level</p>
 */
public class LongestValidParentheses {
    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public static int longestValidParentheses (String s) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        stack.push(-1);
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else maxLen = Math.max(maxLen, i - stack.peek());
            }
        }
        return maxLen;
    }

    //dp
        public static int  longestValidParentheses2(String s) {
            int maxans = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            return maxans;
        }

    public static void main(String[] args) {
        int longest = longestValidParentheses2("())((())");
        System.out.println(longest) ;
    }
}
