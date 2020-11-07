/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/07 15:59
 * <a href="https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">数组中出现次数超过一半的数字</a>
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum(int[] array) {
        if(array == null) return 0;
        int count = 0;
        int win = 0 ;
        for (int i: array) {
            if(count == 0) {
                win = i ;
                count = 1;
            }else {
                if(win == i) count++ ;
                else count--;
            }
        }
        count = 0 ;
        for (int i: array) {
            if(win == i) count++;
        }
        return (count > (array.length>>1))? win : 0;
    }
}
