package dp;

/**
 * <a href="https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">最长公共子串</a>
 * <p>dp</p>
 */
public class LCS2 {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] dp = new int[l1+1][l2+1];
        int max = 0;
        int end = 0;
        for(int i = 0; i <= l1; ++i) {
            for(int j = 0; j <= l2; ++j) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = 0;
                if(max < dp[i][j]) {
                    max = dp[i][j];
                    end = i-1;
                }
            }
        }
        return (max != 0)? str1.substring(end + 1 - max,end + 1) : "-1";
    }
}
