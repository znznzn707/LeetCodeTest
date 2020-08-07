import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/27 16:08
 *
 * <a href="https://www.nowcoder.com/questionTerminal/6a296eb82cf844ca8539b57c23e6e9bf">最小的K个数</a>
 */
public class KNumber {
    public static ArrayList<Integer> kNumber(int[] input, int k) {
        Comparator<Integer> comp = (x, y) -> (x < y)? -1:(x==y)? 0:1 ;
        PriorityQueue<Integer> queue = new PriorityQueue<>(comp) ;
        for(int i: input) {
            queue.offer(i) ;
        }
        ArrayList<Integer> list = new ArrayList<>() ;
        if(input.length >= k) {
            for(int i = 0; i < k; i++)
                list.add(queue.poll()) ;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8} ;
        ArrayList<Integer> list = kNumber(arr, 4) ;
        list.forEach(System.out::println);
    }
}
