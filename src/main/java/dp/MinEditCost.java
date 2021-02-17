package dp;

/**
 * <a href="https://www.nowcoder.com/practice/05fed41805ae4394ab6607d0d745c8e4?tpId=190&tqId=35213&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey">最小编辑代价</a>
 * <pre>
 最小编辑代价：给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价。

 较难的动态规划题目(主要要着眼于三个基本操作带来的操作)：
 如果选择将str1的前i个字符转换为str2的前j个字符则需要分类讨论->dp[i]j
 如果str1[i] == str2[j]->则只需要将前i-1个字符转换为前j-1个字符即可，最后一个字符不动：dp[i][j] = dp[i-1][j-1]
 如果str1[i] != str2[j]->分三类操作：
 1.插入：将i个字符串转变为前j-1个字符串在插入第j个字符->dp[i][j-1]+ic
 2.删除：将i-1个字符串转换为前j个字符串删除第i个字符->dp[i-1][j]+id
 3.替换：将i-1个字符串转换为前j-1个字符串替换掉第i个字符为第j个字符->dp[i-1][j-1]+rc
 取最小的即可

 * </pre>
 */
public class MinEditCost {
    /**
     * min edit cost
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic int整型 insert cost
     * @param dc int整型 delete cost
     * @param rc int整型 replace cost
     * @return int整型
     */
    public static int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int[][] dp = new int[str1.length()+1][str2.length()+1] ; //将str1前i个字符编辑成str2前j个字符的最小代价
        for(int i = 0; i <= str1.length(); ++i) {
            dp[i][0] = i * dc;
        }
        for(int j = 0; j <= str2.length(); ++j) {
            dp[0][j] = j * ic;
        }
        for(int i = 1; i <= str1.length(); ++i) {
            for(int j = 1; j <= str2.length(); ++j) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    int insert = dp[i][j-1] + ic;
                    int delete = dp[i-1][j] + dc;
                    int replace = dp[i-1][j-1] + rc;
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minEditCost("abc", "adc", 5, 3, 2)) ;
        System.out.println(minEditCost("abc", "adc", 5, 3, 100)) ;
    }
}
