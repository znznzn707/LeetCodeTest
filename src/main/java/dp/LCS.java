package dp;

/**
 * <a href="https://www.nowcoder.com/practice/6d29638c85bb4ffd80c020fe244baf11?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">最长公共子序列</a>
 * <a href="https://blog.csdn.net/hrn1216/article/details/51534607">图解</a>
 */
public class LCS {
    /**
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String s1, String s2) {
        // write code here
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 0; i <= l1; ++i) {
            for(int j = 0; j <= l2; ++j) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (l1 > 0 && l2 > 0) {
            if(s1.charAt(l1-1) == s2.charAt(l2-1)) {
                sb.append(s1.charAt(l1-1));
                --l1;
                --l2;
            }
            else {
                if(dp[l1-1][l2] > dp[l1][l2-1]) --l1;
                else --l2;
            }
        }
        if(sb.length() == 0) return "-1";
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        String res = lcs.LCS("1A2C3D4B56","B1D23CA45B6A");
        System.out.println(res) ;
    }
}
