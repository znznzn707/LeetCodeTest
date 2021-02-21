package backtrack;

import java.util.ArrayList;

/**
 * <a href="https://www.nowcoder.com/practice/ce73540d47374dbe85b3125f57727e1e?tpId=190&tqId=35339&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey">数字字符串转化成IP地址</a>
 */
public class RestoreIpAddresses {
    /**
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public static ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        ArrayList<String> strings = new ArrayList<>();
        if (s.length() == 0) return strings;
        backtrackIpAddresses(s, 0, 3, strings);
        return strings;
    }
    /**
     * @param str 字符串
     * @param i   要添加点的位置 //*关键*
     * @param cnt 剩余点的个数
     * @param res 结果
     */
    private static void backtrackIpAddresses(String str, int i, int cnt, ArrayList<String> res) {
        if (cnt == 0) {
            String[] strings = str.split("\\.");
            if (strings.length < 4) return;
            for (String s : strings) {
                if (s.length() > 1 && s.charAt(0) == '0') return;
                if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) return;
            }
            res.add(str);
            return;
        }
        int n = str.length();
        if (i >= n) return;
        backtrackIpAddresses(str.substring(0, i + 1) + "." + str.substring(i + 1, n), i + 2, cnt - 1, res);
        if (i + 2 < n)
            backtrackIpAddresses(str.substring(0, i + 2) + "." + str.substring(i + 2, n), i + 3, cnt - 1, res);
        if (i + 3 < n)
            backtrackIpAddresses(str.substring(0, i + 3) + "." + str.substring(i + 3, n), i + 4, cnt - 1, res);
    }

    public static void main(String[] args) {
        ArrayList<String> strings = restoreIpAddresses("25525522135");
        strings.forEach(System.out::println);
    }
}
