package two_pointer;

import java.util.ArrayList;

/**
 * <a href="https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&&tqId=11217&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">滑动窗口的最大值</a>
 */
public class MaxInWindows {
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        int len = num.length;
        ArrayList<Integer> res = new ArrayList<>();
        if(size > len || size == 0) return res;
        int left = 0, right = left + size - 1;
        while (right < len) {
            res.add(max(num, left, right));
            ++left ;
            ++right;
        }
        return res;

    }
    private static int max(int[] num, int left, int right) {
        int max = num[left];
        for(int i = left; i <= right; i++) {
            if(max < num[i]) max = num[i] ;
        }
        return max;
    }
}
