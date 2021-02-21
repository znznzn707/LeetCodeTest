package backtrack;

import java.util.ArrayList;

/**
 * <a href="https://www.nowcoder.com/practice/c9addb265cdf4cdd92c092c655d164ca?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">括号生成</a>
 */
public class GenerateParenthesis {
    /**
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
    public static ArrayList<String> generateParenthesis (int n) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        backtrack("", n, n, res);
        return res;
    }
    private static void backtrack(String s, int left, int right, ArrayList<String> res) {
        if(left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if(left > 0) backtrack(s+"(", left-1, right, res);
        if(right > left) backtrack(s+")", left, right-1, res);
    }
    public static void main(String[] args) {
        ArrayList<String> list =  generateParenthesis(3);
        list.forEach(System.out::println);
    }
}
