import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/27 16:08
 *
 * <p>desc: 寻找第K大的数, k = 3</p>
 */
public class KNumber {
    public static int kNumber(int[] arr) {
        Comparator<Integer> comp = (x, y) -> ((x > y)? 1 : -1) ;
        TreeSet<Integer> set = new TreeSet<>(comp) ;
        for(int i: arr)
            set.add(i) ;
        int x = 0 ;
        for(int i = 0; i < 3; i++)
            x = set.pollLast() ;
        return x ;
    }
}
