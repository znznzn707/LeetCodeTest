package math;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">孩子们的游戏</a>
 */
public class LastRemaining_Solution {

    public static int LastRemaining_Solution(int n, int m) {
        if(n <= 0 || m <= 0) return -1;
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; ++i) {
            list.add(i);
        }
        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m-1) % list.size();
            list.remove(bt);
        }
        return n == 1? 0: list.get(0);
    }

    public static void main(String[] args) {
        int n = 5, m = 3;
        System.out.println(LastRemaining_Solution(n, m)) ;
    }
}
