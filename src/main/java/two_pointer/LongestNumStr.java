package two_pointer;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/27 15:19
 * <p>desc: 最长连续数字串</p>
 * */
public class LongestNumStr {

    public static String numStr(String str) {
        int max, count, end ;
        max = count = end = 0 ;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' &&
                    str.charAt(i) <= '9') {
                count++;
                if(max < count) {
                    max = count ;
                    end = i ;
                }
            }else
                count = 0 ;
        }
        return str.substring(end - max + 1, end + 1) ;
    }
}
