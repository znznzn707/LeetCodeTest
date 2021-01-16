package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">最小的K个数</a>
 */

public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> lists = new ArrayList<>();
        if(k > input.length) return lists;
        Comparator<Integer> comp = (x, y)-> ((x<y)?-1:((x == y)? 0:1));
        PriorityQueue<Integer> queue = new PriorityQueue<>(comp);
        for(int i : input) queue.offer(i);
        while(k-- > 0) lists.add(queue.poll()) ;
        return lists ;
    }
}
