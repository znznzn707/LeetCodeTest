package string;

/**
 * <a href="https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">最长公共子串</a>
 * <p>dp</p>
 */
public class LCS {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        // write code here
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] dp = new int[l1+1][l2+1];
        int maxLen = 0;
        int end = 0;
        for(int i = 0; i <= l1; ++i) dp[i][0] = 0;
        for(int j = 0; j <= l2; ++j) dp[0][j] = 0;
        for(int i = 1 ; i <= l1; ++i) {
            for(int j = 1; j <= l2; ++j){
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = 0;
                if(dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    end = j-1;
                }
            }
        }
        if(end == 0) return "-1";
        else return str2.substring(end-maxLen+1, end+1);
    }
}
