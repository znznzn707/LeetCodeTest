package string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://www.nowcoder.com/practice/fc897457408f4bbe9d3f87588f497729?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">最大数</a>
 */
public class MaxNumber {
    /**
     * 最大数
     * @param nums int整型一维数组
     * @return string字符串
     */
    public static String solve (int[] nums) {
        // write code here
        Comparator<String> comp = (x, y) -> (y + x).compareTo(x + y);
        List<String> list =  new ArrayList<>();
        for (int i: nums) list.add(String.valueOf(i));
        list.sort(comp);
        if(list.get(0).equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] num = {12, 34, 32, 1, 0};
        String s = solve(num);
        System.out.println(s) ;
    }
}
