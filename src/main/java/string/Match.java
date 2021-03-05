package string;

/**
 * <a href="https://www.nowcoder.com/practice/28970c15befb4ff3a264189087b99ad4?tpId=190&tqId=36062&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey">正则表达式匹配</a>
 * <p>重要题目</p>
 */
public class Match {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str     string字符串
     * @param pattern string字符串
     * @return bool布尔型
     */
    public static boolean match(String str, String pattern) {
        // write code here
        if (pattern.length() == 0) return str.length() == 0;
        boolean match = str.length() > 0 && (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
        if (pattern.length() > 1 && pattern.charAt(1) == '*')
            return match(str, pattern.substring(2)) || (match && match(str.substring(1), pattern)); // 0次||多次
        else return match && match(str.substring(1), pattern.substring(1));
    }

    //dp
    public static boolean match2(String str, String pattern) {
        if (pattern.length() == 0) return str.length() == 0;
        int sl = str.length();
        int ptl = pattern.length();
        boolean[][] dp = new boolean[sl+1][ptl+1];
        for(int i = 0; i <= sl; ++i) {
            for(int j = 0; j <= ptl; ++j) {
                if(j == 0) dp[i][j] = (i == 0);
                else {
                    //pattern后面不是*的情况
                    if (pattern.charAt(j - 1) != '*') {
                        if (i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.'))
                            dp[i][j] = dp[i - 1][j - 1];
                    }else {
                        //pattern后面为*
                        if(j >= 2) dp[i][j] = dp[i][j-2]; //*表示0次
                        if(i>0 && j>=2 &&(str.charAt(i-1)==pattern.charAt(j-2)||pattern.charAt(j-2)=='.')){
                            dp[i][j] |= dp[i-1][j];//*表示多次，匹配*前面的字符
                        }
                    }
                }

            }
        }
        return dp[sl][ptl];
    }

    public static void main(String[] args) {
        boolean isMatch = match2("aaa", "a*a");
        System.out.println(isMatch);
    }
}