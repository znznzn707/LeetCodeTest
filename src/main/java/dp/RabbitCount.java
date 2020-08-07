package dp;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/03 14:26
 * <a href="https://www.nowcoder.com/questionTerminal/1221ec77125d4370833fd3ad5ba72395">统计每个月兔子的总数</a>
 * <pre>
 *     有一只兔子，从出生后第3个月起每个月都生一只兔子，
 *     小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * </pre>
 *
 */
public class RabbitCount {

    /**
     * 统计出兔子总数。
     *
     * @param monthCount 第几个月
     * @return 兔子总数
     */
    public static int getTotalCount(int monthCount) {
        if(monthCount < 3)
            return 1 ;
        else
            return getTotalCount(monthCount-1)
                    + getTotalCount(monthCount-2) ;
    }
    //动态规划
    public static int getTotalCountWithDP(int monthCount) {
        int[] arr = new int[monthCount] ;
        arr[0] = arr[1] = 1 ;
        for(int i = 2; i < monthCount; i++) {
            arr[i] = arr[i-1] + arr[i-2] ;
        }
        return arr[monthCount-1] ;
    }
}
